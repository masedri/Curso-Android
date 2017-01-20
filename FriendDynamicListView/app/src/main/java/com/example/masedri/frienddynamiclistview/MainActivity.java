package com.example.masedri.frienddynamiclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ListView friendsLiestView;
    private EditText friendEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Contruimos el adaptador
        List<String> listaInicial = new ArrayList<String>();
        listaInicial.add("juan");
        listaInicial.add("pepe");
        listaInicial.add("pedro");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listaInicial); // utilizamos un modelo de fila definido en el adnroid sdk por defecto.
        friendsLiestView = (ListView) findViewById(R.id.friendsListView);
        friendsLiestView.setAdapter(adapter);
        friendEditText =  (EditText) findViewById(R.id.newNameEditText);
    }

    public void addFriend(View v){
        String newFriend = friendEditText.getText().toString();
        adapter.add(newFriend);
        adapter.notifyDataSetChanged(); // esto hace que el adpator repercuta el cambio en el interzaz.
        friendEditText.setText("");
    }
}
