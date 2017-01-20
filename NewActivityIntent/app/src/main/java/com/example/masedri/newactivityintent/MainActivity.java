package com.example.masedri.newactivityintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Un intent es para manifestar un evento, en general cuando se produce un evento aparecen obj d tipo intent
        //hay dos tipos de intents. Cuando hay un intent implicito android se encarga de escoger el componenet para resolver la accion.
        // un intenet explicito es cuando yo se que componenet va a realizar la accion.

    }
    public void  starNewActivity(View v) {
        Intent  intent = new Intent(this, Activity2.class);
        intent.putExtra("key", "Ejemplo"); // para pasarle informacion entre actividades.
        startActivity(intent);
    }

    public void starNewActivityImpcita(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW); // estas acciones estan declaradas en la clase Intent
        intent.setData(Uri.parse("http://www.marckrodriguez.com")); //una url es uri
        startActivity(intent);
    }
    public void implicitgeointenet(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW); // estas acciones estan declaradas en la clase Intent
        intent.setData(Uri.parse("geo:0.0?"+"q=1600+Pennsylvania+Ave+Washington+DC")); //una url es uri
        startActivity(intent);
    }
    public void launchhttpintenet(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW); // estas acciones estan declaradas en la clase Intent
        intent.setData(Uri.parse("http://estaticos.elmundo.es/assets/multimedia/imagenes/2017/01/19/14848172017527.png")); //una url es uri
        intent.setType("image/png");
        startActivity(intent);
    }
}
