package com.marce.proyecto021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String []paises = {"argentina", "brasil", "chile", "colombia", "costa rica"};
    int []fotos = {R.drawable.argentina, R.drawable.brasil, R.drawable.chile, R.drawable.colombia, R.drawable.costarica};
    ViewPager2 vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp);
        vp.setAdapter(new AdaptadorPaises());
        //SI QUIERO QUE EL DESPLAZAMIENTO SEA VERTICAL:
        //vp.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
    }

    private class AdaptadorPaises extends RecyclerView.Adapter<AdaptadorPaises.AdaptadorPaisHolder> {

        @NonNull
        @Override
        public AdaptadorPaisHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            return new AdaptadorPaisHolder(getLayoutInflater().inflate(R.layout.layoutpais, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorPaisHolder holder, int position){
            holder.imprimir(position);
        }

        @Override
        public int getItemCount(){
            return paises.length;
        }

        class AdaptadorPaisHolder extends RecyclerView.ViewHolder {
            ImageView iv1;
            TextView tv1;
            public AdaptadorPaisHolder(@NonNull View itemView){
                super(itemView);
                iv1 = itemView.findViewById(R.id.ivpais);
                tv1 = itemView.findViewById(R.id.tvpais);
            }
            public void imprimir(int position){
                iv1.setImageResource(fotos[position]);
                tv1.setText(paises[position]);
            }
        }
    }
}