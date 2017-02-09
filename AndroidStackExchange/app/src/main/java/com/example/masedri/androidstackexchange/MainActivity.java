package com.example.masedri.androidstackexchange;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private static final String DATA_TAG = "DataFragmentTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Para trabajar con fragmentos tenemos que utilizar el fragmentManager
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction(); // Una transacion es un conjuto de operaciones que tenemos que realizar para alojar un fragmento. la transaccion se trata como una unidad desde que empieza hasta que se confirma.
        QuestionListFragment questionListFragment = new QuestionListFragment(); // creamos el fragment
        fragmentTransaction.add(R.id.fragmentContainer, questionListFragment); // agregamos el fragmento, lo alojamos

        GetDataFragment getDataFragment = new GetDataFragment();
        fragmentTransaction.add(getDataFragment,DATA_TAG);

        fragmentTransaction.commit(); // completamos la transaccion, la confirmamos
        getSupportFragmentManager().executePendingTransactions();
    }
}
