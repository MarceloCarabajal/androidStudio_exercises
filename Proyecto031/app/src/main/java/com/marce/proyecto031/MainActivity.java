package com.marce.proyecto031;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv1;
    String []nombres = {"Chino", "Dario", "Diego", "Fede", "Gastón", "Juli", "Seba", "Victor"};
    int []edades = {29, 33, 27, 31, 28, 25, 34, 34};
    int []fotos = {R.drawable.chino, R.drawable.dario, R.drawable.diego, R.drawable.fede, R.drawable.gato, R.drawable.juli, R.drawable.seba, R.drawable.victor};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv1 = findViewById(R.id.rv1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv1.setLayoutManager(linearLayoutManager);

        rv1.setAdapter(new AdaptadorPersona());
    }

    private class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.AdaptadorPersonaHolder> {
        @NonNull
        @Override
        public AdaptadorPersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorPersonaHolder(getLayoutInflater().inflate(R.layout.layout_tarjeta,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPersonaHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return nombres.length;
        }

        class AdaptadorPersonaHolder extends RecyclerView.ViewHolder{
            ImageView iv1;
            TextView tv1, tv2;
            public AdaptadorPersonaHolder(@NonNull View itemView){
                super(itemView);
                iv1 = itemView.findViewById(R.id.imagev);
                tv1 = itemView.findViewById(R.id.tvnombre);
                tv2 = itemView.findViewById(R.id.tvedad);
            }

            public void imprimir(int position){
                iv1.setImageResource(fotos[position]);
                tv1.setText(nombres[position]);
                tv2.setText(String.valueOf(edades[position]));
            }

        }
    }
}