package com.example.masedri.dinamycfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.masedri.dinamycfragments.fragments.QuoteFragment;
import com.example.masedri.dinamycfragments.fragments.TitlesListFragment;

public class MainActivity extends AppCompatActivity implements TitlesListFragment.TitlesListFragmetHostingActivity{

    //la actividad principal construye los fragmentos
    private QuoteFragment qFragment;
    private TitlesListFragment titlesListFragment;
    private FrameLayout titlesContainer, quotesContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlesContainer = (FrameLayout) findViewById(R.id.containerTitle);
        quotesContainer = (FrameLayout) findViewById(R.id.containerQuotes);

        qFragment =  new QuoteFragment();
        titlesListFragment =  new TitlesListFragment();
        FragmentManager fm = getSupportFragmentManager(); //

        fm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {  // para definir una accio cuando se produce un cambio;
            @Override
            public void onBackStackChanged() {

                setLayout();

            }
        });


        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.containerTitle, titlesListFragment);
        ft.addToBackStack("composicion inicial"); // es para añadir a la pila una composicion de fragmentos, puedo darle un nombre o sino pongo null

        ft.commit(); // para confirmar los cambios.

        fm.executePendingTransactions(); // para que se apliquen las trsaciones pendientes.

    }

    private void setLayout() {

        //la distribucion del espacio depende de que este añadido el fragmento correspondiente o no.
        //para verifr si esta añanido
        if (qFragment.isAdded()){
            titlesContainer.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
            quotesContainer.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 2f));
        }else{
            titlesContainer.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f));
            quotesContainer.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 0f));
        }


    }

    @Override
    public void showTitle(int index) {

        if (!qFragment.isAdded()){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft =  fm.beginTransaction();
            ft.add(R.id.containerQuotes, qFragment);
            ft.addToBackStack(null);
            ft.commit();
            fm.executePendingTransactions();

        }
        qFragment.showTitle(index); // paara diferenciar el

    }
}
