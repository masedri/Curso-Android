package com.example.masedri.androidstackexchange;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.masedri.androidstackexchange.events.NewDataEvent;
import com.example.masedri.androidstackexchange.events.QuestionsOpenHelper;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * A simple {@link Fragment} subclass.
 *
 */

// Este es el encargado de mostrar la vista
public class QuestionListFragment extends ListFragment {


    private static final String TAG = QuestionListFragment.class.getCanonicalName(); // Normalmente en el tag se guarda el nombre de la clase para saber qué clase ha dejado la traza

    public QuestionListFragment() { // Los fragmentos tienes un ciclo de vida donde se activan y se detienen
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    //las anotaciones tienen efecto en la compilacion, sirven para decirle al compilador que metodo tiene que usar cuando se lanza un evento
    // Casi siempre las anotaciones las utiliza algun infractrustura por debajo de nuestra aplicacion, para saber que eventos tiene que producir, a quien tiene que llamar etc.
    // Los atributos de un anotacion se escriben entre los parentesis
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getDataNotification(NewDataEvent event){
        Log.i(TAG, "getData");
        Cursor cursor = event.getCursor();
        ((CursorAdapter)getListView().getAdapter()).swapCursor(cursor);
        ((CursorAdapter)getListView().getAdapter()).notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(), R.layout.question_row, null, new String[]{QuestionsOpenHelper.AVATAR_COLUM, QuestionsOpenHelper.QUESTION_TITLE_COLUM}, new int[]{R.id.imageViewAvatar, R.id.textViewQuestion},0); // el nombre de las columnas, y los identificadores de las columnas.

        adapter.setViewBinder(new QuestionViewBinder()); // un Binder define los metodos que van a ser llamados cuando una interfaz tenga que configurar los widgets de la vista

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class QuestionViewBinder implements SimpleCursorAdapter.ViewBinder {
        @Override
        public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
            switch (view.getId()){
                case R.id.imageViewAvatar:
                    Picasso.with(getActivity()).load(cursor.getString(columnIndex)).resize(54,54).centerCrop().into((ImageView) view);
                    return true;
                case  R.id.textViewQuestion:
                    ((TextView)view).setText(cursor.getString(cursor.getColumnIndex(QuestionsOpenHelper.QUESTION_TITLE_COLUM)));
                    return true;
            }
            return false;
        }
    }
}
