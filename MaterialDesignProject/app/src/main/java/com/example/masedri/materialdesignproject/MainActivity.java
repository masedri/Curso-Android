package com.example.masedri.materialdesignproject;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Gradel es un gestor de proyectos, es el encargado de instalar la app, ejecula etc.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // es un metodo de la acvitivdad, para referinos a algun dato del xml
        /*View*/ FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton); // todos los widgets son del tipo View
        //Sin embarg, yo quiero tratarlo como un floatingactionbutton, por eso hemos importando la libreria
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                //Es un mensaje que aparece en la parte inferior de la pantalla, adnroid desaconseja el uso de toast.
                Snackbar.make(view, "click on fb", Snackbar.LENGTH_LONG).show();
                //Toast.makeText("hola", Toast.LENGTH_LONG).show();



            }

        }); // Metodo para detectar el evento click.
    }
}
