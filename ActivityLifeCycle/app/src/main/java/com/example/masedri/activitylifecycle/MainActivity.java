package com.example.masedri.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { //Una actividad extiende de AppcompatActivity porque
    // Si pone extendes Activity me compula la activity de la api actual, con AppCompatActivity hacemos compatible con las apis anteriores y recrea la actividad de la api actual.


    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // SetContentView definimos que interfaz de usuario utilizar. Que vista. El setcontenview lee el xml y construye los objs.
        //Android registra todos los recursos no compilados que forman parte del proyecto.
        Log.d(TAG, "onCreate()...");
        TextView titleTv = (TextView) findViewById(R.id.titleTv); // findViewById devuelve una referencia del id, todos los widgets son obj de la clase View, que  asu vez tiene sub clases especializadas.
        titleTv.setText("ActivityLifyCycleMoney");
        Toast.makeText(this, "onCreate!", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        //Para dejar trazas en el log // depuración.
        Log.d(TAG, "OnStart()...");
        Toast.makeText(this, "OnStart!", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()...");
        Toast.makeText(this, "OnStart!", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnStart()...");
        Toast.makeText(this, "onPause!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "OnRestart()...");
        Toast.makeText(this, "onRestart!", Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()...");
        Toast.makeText(this, "onStop!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()...");
        Toast.makeText(this, "onDestroy!", Toast.LENGTH_LONG).show();
    }


}
