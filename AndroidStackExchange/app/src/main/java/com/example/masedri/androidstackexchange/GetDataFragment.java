package com.example.masedri.androidstackexchange;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.masedri.androidstackexchange.events.NewDataEvent;
import com.example.masedri.androidstackexchange.events.QuestionsOpenHelper;
import com.example.masedri.androidstackexchange.model.Item;
import com.example.masedri.androidstackexchange.model.QuestionGroup;
import com.example.masedri.androidstackexchange.retrofitresources.QuestionCall;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */

// estos fragmentos no se van a crean al menos que una actividad los aloje
public class GetDataFragment extends Fragment {


    public GetDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) { // la actividy agregan los fragmentos, cuando la actividad lo haya usado con el metodo attach que es la primera notifiacion que recibe un fragmento
        super.onActivityCreated(savedInstanceState);
        new GetLoadThread().start(); // lanzamos el hilo cuando el fragmento se crea
    }

    public class GetLoadThread extends Thread{ //esta es la class hilo donde se van a cargar los datos


        public void run(){

                //EventBus.getDefault().postSticky(new NewDataEvent()); // Con el metodo post notificamos los eventos
                //postStiky lanza una notificacion pero si en el moto de lanzar la notificaion no hay nadie subscrito se queda pendiente hasta que alguien se suscriba

           //Es el encargado de administrar la peticion http
            Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.stackexchange.com")
                        .addConverterFactory(GsonConverterFactory.create()) // covnersor a json
                        .build();

                QuestionCall service = retrofit.create(QuestionCall.class);
            try {

                QuestionGroup questionGroupList =  service.getQuestionsCall("Android").execute().body();// me permite ejecutar la peticion http de forma asincrona y obtener una lista de items.

                QuestionsOpenHelper questionsOpenHelper = QuestionsOpenHelper.getInstance(getActivity());
                 Cursor cursor = questionsOpenHelper.insert(questionGroupList.items);
                EventBus.getDefault().postSticky(new NewDataEvent(cursor));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
