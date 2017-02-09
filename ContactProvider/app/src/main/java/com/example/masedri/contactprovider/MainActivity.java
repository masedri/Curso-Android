package com.example.masedri.contactprovider;

import android.app.ListActivity;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Obtenemos una lista con los nombres de los contactos

        //Para solicitar, modificar o elimnar datos, el content provider de cada aplicacion tiene que  publicar las uris para poder acceder a los datos.
        // Una URI esn identificador de un recurso
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.PHOTO_URI,
                ContactsContract.Contacts.DISPLAY_NAME}, null, null, null);
        List<String> conctacNames = new ArrayList<>();
        while (cursor.moveToNext()){
          String name =  cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            conctacNames.add(name);
        }

        cursor.close(); // Para liberar memoria, cerramos el cursor.
        //utilizamos un modelo de fila por defecto
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, conctacNames);

        setListAdapter(adapter);


    }
}
