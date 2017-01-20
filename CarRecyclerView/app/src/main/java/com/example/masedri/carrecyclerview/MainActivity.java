package com.example.masedri.carrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG= "MainActivity";
    List<Car> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Car> data = getData();
        CardAdapter adapter = new CardAdapter(this, R.layout.row_car,data);
        ListView carListView = (ListView) findViewById(R.id.carRecyclerView);



    }




    private List<Car> getData() {
    }
}
