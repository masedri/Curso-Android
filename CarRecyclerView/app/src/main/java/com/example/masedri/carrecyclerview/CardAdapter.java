package com.example.masedri.carrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by masedri on 20/1/17.
 */


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<Car> carlist;
    private Context ctx;

    public CardAdapter(Context ctx, List<Car> list){
        carlist =  list;
        this.ctx= ctx;
    }

    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View row =  inflater.inflate(R.layout.row_car, parent, false); // contruccion de la fila
        //return new ViewHolder(row); // se guardan la fila.
         ViewHolder holder= new ViewHolder(row);

        return holder;
    }

    @Override
    public void onBindViewHolder(CardAdapter.ViewHolder holder, int position) { // se recicla la fila
            holder.carImageView.setImageResource(carlist.get(position).getMiniatura());
            holder.carTextView.setText(carlist.get(position).getFabricante()+" "+ carlist.get(position).getModelo());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView carImageView;
        private TextView carTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            carImageView = (ImageView) carImageView.findViewById(R.id.carImageView);
            carTextView = (TextView) carImageView.findViewById(R.id.carTextView);

            carImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("HolderView","Click en image car" + "Old position: " +  getOldPosition() +
                            "LayoutPosition " +getLayoutPosition() + "adapter position" +  getAdapterPosition()); // la mas fiable es getaapterposition la posicion en la que hemos hecho click relacionada con la fuente de datos.
                    Intent intent =  new Intent(ctx,CarDetailActivity.class);
                    intent.putExtra(CarDetailActivity.IMAGEN_EXTRA, carlist.get(getAdapterPosition()).getImagen());
                    intent.putExtra(CarDetailActivity.DESCRIPCION_EXTRA, carlist.get(getAdapterPosition()).getDescripcion());
                    intent.putExtra(CarDetailActivity.FABRICANTE_EXTRA, carlist.get(getAdapterPosition()).getFabricante());
                    intent.putExtra(CarDetailActivity.MODEL_EXTRA, carlist.get(getAdapterPosition()).getModelo());
                    ctx.startActivity(intent); // estar activity es un metodo de la calse context

                }
            });
            carTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Adapter","Click en text car");
                }
            });




        }
    }
}

