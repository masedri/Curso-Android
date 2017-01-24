package com.example.masedri.toolbar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG =  "MainActivity";
    private EditText searchEditText;
    private ActionBar aBar;
    private ListView listView;
    ArrayAdapter<String> adapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); // todos los elementos del xml que define una UI hay que infltarlos para poder manipularlos por codigo.
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.includedToolbar);
        setSupportActionBar(toolbar); // registramos la barra de accion que vamos a utilizar en la aplicacion.
        aBar = getSupportActionBar();

        String myList[] ={"pepe", "juan", "pedro"};
        listView = (ListView) findViewById(R.id.listView);
        listView.setTextFilterEnabled(true);
        searchEditText = (EditText) findViewById(R.id.searchEditText);
        adapter = new ArrayAdapter<>(this, R.layout.row_item, R.id.textView, myList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.search_IT:
                Log.d(TAG, "Search item...");
                aBar.setDisplayShowTitleEnabled(false);
                aBar.setDisplayShowCustomEnabled(true);
                aBar.setCustomView(R.layout.search_layout);
                searchEditText =  (EditText) aBar.getCustomView().findViewById(R.id.searchEditText);
                searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH){
                            String searchtText =  searchEditText.getText().toString();
                            Log.d(TAG, "Search: "+ searchtText);
                            //Ocultar el teclado
                            InputMethodManager inm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // PARA utilizar un sercicio del systema.
                            inm.hideSoftInputFromWindow(searchEditText.getWindowToken(),0);
                            // restablecer titulo del toolbar
                            aBar.setDisplayShowTitleEnabled(true);
                            aBar.setDisplayShowCustomEnabled(false);

                            //Empezar la busqueda
                            return true;
                        }
                        return false;


                    }

                });


                searchEditText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        MainActivity.this.adapter.getFilter().filter(s);
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                InputMethodManager inm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // PARA utilizar un sercicio del systema.
                inm.showSoftInput(searchEditText, InputMethodManager.SHOW_IMPLICIT);
                searchEditText.requestFocus();
                break;
            case R.id.settingIT:
                Log.d(TAG, "Settings item...");
                break;
            case R.id.titleAbout:
                Log.d(TAG, "Settings item...");
                Intent intent = new Intent(this, MyPreferences.class);
                startActivity(intent);

                break;

        }

        return true;

    }


}
