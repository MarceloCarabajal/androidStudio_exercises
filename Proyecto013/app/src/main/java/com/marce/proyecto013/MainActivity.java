package com.marce.proyecto013;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String []nombres = {"anana", "banana", "durazno", "frutilla", "kiwi", "mandarina", "manzana verde", "manzana"};

    float []precios = {170, 120, 260, 155, 130, 180, 120, 39};

    int []fotos = {R.drawable.anana, R.drawable.banana, R.drawable.durazno, R.drawable.frutilla, R.drawable.kiwi,
            R.drawable.mandarina, R.drawable.manzana, R.drawable.manzanaroja};
    RecyclerView rv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv1 = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv1.setLayoutManager(linearLayoutManager);
        rv1.setAdapter(new AdaptadorFrutas());
    }

    private class AdaptadorFrutas extends RecyclerView.Adapter<AdaptadorFrutas.AdaptadorFrutasHolder> {
        @NonNull
        @Override
        public AdaptadorFrutasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            return new AdaptadorFrutasHolder(getLayoutInflater().inflate(R.layout.itemfruta, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorFrutasHolder holder, int position){
            holder.imprimir(position);
        }

        @Override
        public int getItemCount(){
            return nombres.length;
        }
        private class AdaptadorFrutasHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView tv1, tv2;
            ImageView iv1;
            int position;

            public AdaptadorFrutasHolder(@NonNull View itemView) {
                super(itemView);
                iv1 = itemView.findViewById(R.id.imageView);
                tv1 = itemView.findViewById(R.id.tvnombre);
                tv2 = itemView.findViewById(R.id.tvprecio);
                itemView.setOnClickListener(this);
            }

            public void imprimir(int position) {
                this.position = position;
                iv1.setImageResource(fotos[position]);
                tv1.setText(nombres[position]);
                tv2.setText(String.valueOf(precios[position]));
            }

            @Override
            public void onClick(View v) {
                int clickedPosition = getAdapterPosition();
                if(clickedPosition != RecyclerView.NO_POSITION){
                    Toast.makeText(MainActivity.this, nombres[clickedPosition], Toast.LENGTH_SHORT).show();

                }
           }

        }
    }
}