package com.example.masedri.vehiculoslistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.masedri.vehiculoslistview.adapters.CarAdapter;
import com.example.masedri.vehiculoslistview.model.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Vehiculo> data = getData();
        CarAdapter adapter =  new CarAdapter(this, R.layout.card_row_layout, data);
        ListView carListView = (ListView) findViewById(R.id.cardListView);
        carListView.setAdapter(adapter);
        carListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "click en item " + position + " ");
                Toast.makeText(MainActivity.this, "click en item  " + position +"..", Toast.LENGTH_SHORT).show();

            }

        });
    }

    private List<Vehiculo> getData(){
        List<Vehiculo> arrayList = new ArrayList<>();
        arrayList.add(new Vehiculo("El Fucker", "blabla", "Ruben ",R.drawable.ruben, R.drawable.ruben));
        arrayList.add(new Vehiculo("El Hiperactivo", "blabla", "Alex ",R.drawable.alex, R.drawable.alex));
        arrayList.add(new Vehiculo("El Troll", "blabla", "David ",R.drawable.david, R.drawable.david));
        arrayList.add(new Vehiculo("La Timida", "blabla", "Fabiola ",R.drawable.fabiola, R.drawable.fabiola));
        arrayList.add(new Vehiculo("The Father", "blabla", "Ivan ",R.drawable.ivan, R.drawable.ivan));
        arrayList.add(new Vehiculo("El Crack", "blabla", "Jonathan ",R.drawable.jonathan, R.drawable.jonathan));
        arrayList.add(new Vehiculo("El Motivado ", "blabla", "Marco ",R.drawable.yo, R.drawable.yo));
        arrayList.add(new Vehiculo("El Cachondo", "blabla", "Jose ",R.drawable.jose, R.drawable.jose));
        arrayList.add(new Vehiculo("El Mr.Heroku ", "blabla", "Juan ",R.drawable.juan, R.drawable.juan));
        arrayList.add(new Vehiculo("El Arquitecto", "blabla", "Rafa ",R.drawable.rafa, R.drawable.rafa));
        arrayList.add(new Vehiculo("El Frances", "blabla", "Nicolas ",R.drawable.nicolas, R.drawable.nicolas));

        return arrayList;
    }

}
