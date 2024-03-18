package com.hasar.proyecto068;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv1;
    private ArrayList<String> lista1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv1 = findViewById(R.id.rv1);
        for (int f = 1; f <= 100; f++) {
            lista1.add(String.valueOf(f));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            rv1.setLayoutManager(linearLayoutManager);
            rv1.addItemDecoration(new DividerItemDecoration(rv1.getContext(), DividerItemDecoration.VERTICAL));
            AdaptadorNumero adaptadorNumero = new AdaptadorNumero();
            rv1.setAdapter(adaptadorNumero);

            ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    lista1.remove(viewHolder.getAdapterPosition());
                    adaptadorNumero.notifyItemRemoved(viewHolder.getAdapterPosition());
                }

                @Override
                public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                    int valor = Integer.parseInt(lista1.get(viewHolder.getAdapterPosition()));
                    if (valor % 2 == 0)
                        return 0;
                    return super.getSwipeDirs(recyclerView, viewHolder);
                }
            };
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
            itemTouchHelper.attachToRecyclerView(rv1);
        }
    }

    private class AdaptadorNumero extends RecyclerView.Adapter<AdaptadorNumero.AdaptadorNumeroHolder> {
        @NonNull
        @Override
        public AdaptadorNumeroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorNumeroHolder(getLayoutInflater().inflate(R.layout.layout_numero, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorNumeroHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return lista1.size();
        }

        class AdaptadorNumeroHolder extends RecyclerView.ViewHolder {
            TextView tvNumero;

            public AdaptadorNumeroHolder(@NonNull View itemView) {
                super(itemView);
                tvNumero = itemView.findViewById(R.id.tvNumero);
            }

            public void imprimir(int position) {
                tvNumero.setText(lista1.get(position));
            }
        }
    }
}