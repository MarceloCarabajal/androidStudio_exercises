package com.marce.proyecto022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    String []dias = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
    String []actividades = {"", "", "", "", "", "", ""};
    ViewPager2 vp2;
    TabLayout tabLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        for(int f=0; f<dias.length; f++){
            String acti = preferencias.getString(dias[f], "");
            actividades[f] = acti;
        }

        vp2 = findViewById(R.id.vp2);
        tabLayout1 = findViewById(R.id.tablayout1);

        vp2.setAdapter(new AdaptadorAgenda());
        TabLayoutMediator tlm = new TabLayoutMediator(tabLayout1, vp2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(dias[position]);
            }
        });
        tlm.attach();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = preferencias.edit();
        for(int f=0; f<dias.length; f++){
            editor1.putString(dias[f], actividades[f]);
        }
        editor1.commit();
    }

    private class AdaptadorAgenda extends RecyclerView.Adapter<AdaptadorAgenda.AdaptadorAgendaHolder>{

        @NonNull
        @Override
        public AdaptadorAgendaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            return new AdaptadorAgendaHolder(getLayoutInflater().inflate(R.layout.layoutdia, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorAgendaHolder holder, int position) { //llama a un metodo de AdaptadorAgendaHolder para que vaya graficando el dia
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() { //Retorna la cantidad de elementos que va a tener nuestro adaptadorAgenda
            return dias.length;
        }

        class AdaptadorAgendaHolder extends RecyclerView.ViewHolder {
            EditText et1;
            public AdaptadorAgendaHolder(@NonNull View itemView){
                super(itemView);
                et1 = itemView.findViewById(R.id.etactividades);
                et1.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        actividades[getLayoutPosition()] = et1.getText().toString();
                        return false;
                    }
                });
            }
            public void imprimir(int position){
                et1.setText(actividades[position]);
            }
        }
    }


}