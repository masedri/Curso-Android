package com.example.masedri.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] names = {"pepe", "juan", "migules"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView  namesLV = (ListView) findViewById(R.id.namesListView);
        namesLV.setAdapter(new NamesAdapter(this, R.layout.row_layout, names));
    }
    public class NamesAdapter extends ArrayAdapter<String>{
        private Context  context;

        public NamesAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.context = context;
        }
        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent){ // View convertView  recontruir la fila. ViewGroup parent: donde se alaojado el listView

          //El layoutFlater nos permite construir clases obj tipo java  partir del xml definido

            LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row =  inflater.inflate(R.layout.row_layout,null);
            TextView nameTV = (TextView) row.findViewById(R.id.nameTV);
            nameTV.setText(names[position]);
            return row;
        };

    }
}
