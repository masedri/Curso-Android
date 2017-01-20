package com.example.masedri.vehiculoslistview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.masedri.vehiculoslistview.R;
import com.example.masedri.vehiculoslistview.model.Vehiculo;

import java.util.List;

/**
 * Created by masedri on 19/1/17.
 */

public class CarAdapter extends ArrayAdapter<Vehiculo> {// Hay tres tipos de adaptador --> BasAdapter ArrayAdapter, CursorAdapter.
    private Context ctx; //  Context es una clase a la que hacemos referencia asignandolo a  variable, porque luego el contructor debe saber cual es el contexto actual, es decir nuestra clase.
                        // en android sirve para como un enlace para saber que componentes estan interelacionados. asi cuando android elimine un componenet, tambien elimina sus dependecias.
    private List<Vehiculo> data;

    public CarAdapter(Context context, int resource, List<Vehiculo> objects) {
        super(context, resource, objects);
        ctx = context;
        data= objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =  LayoutInflater.from(ctx);
        View row = inflater.inflate(R.layout.card_row_layout, null);
        ImageView carIV = (ImageView) row.findViewById(R.id.carImage);
        TextView carTextView = (TextView) row.findViewById(R.id.cardNameTextView);
        carIV.setImageResource(data.get(position).getMiniatura());
        carTextView.setText(data.get(position).getFabricante() + "" + data.get(position).getModelo());
        return row;
    }
}

