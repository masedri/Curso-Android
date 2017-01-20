package com.example.masedri.carrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CarDetailActivity extends AppCompatActivity {
    public static  final String IMAGEN_EXTRA= "image";
    public static  final String MODEL_EXTRA= "model";
    public static  final String FABRICANTE_EXTRA= "fabricante";
    public static  final String DESCRIPCION_EXTRA= "descripcion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);
        Intent intent = getIntent();

        int imageResource = intent.getIntExtra(IMAGEN_EXTRA, 0);
        String modelo = intent.getStringExtra(MODEL_EXTRA);
        String fabricante = intent.getStringExtra(FABRICANTE_EXTRA);
        String descripcion = intent.getStringExtra(DESCRIPCION_EXTRA);

        ImageView carImage = (ImageView) findViewById(R.id.carDetailImage);
        TextView carText = (TextView) findViewById(R.id.carDetailText);
        if (imageResource != 0)
            carImage.setImageResource(imageResource);

        carText.setText("Fabricante: " + fabricante +  "\n" + "modelo: " +  modelo + "\n" + "descripcion: "+ descripcion);

    }
}
