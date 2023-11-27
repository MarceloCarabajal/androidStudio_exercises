package com.marce.proyecto014;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Persona> personas;
    RecyclerView rv1;
    EditText et1, et2;
    AdaptadorPersona ap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv1 = findViewById(R.id.rv1);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        personas = new ArrayList<Persona>();
        personas.add(new Persona("Juan", "34343434"));
        personas.add(new Persona("Carlos", "2323232323"));
        personas.add(new Persona("Luis", "123121212"));
        personas.add(new Persona("Ruben", "54545454"));
        personas.add(new Persona("Raul", "45454554"));
        LinearLayoutManager l = new LinearLayoutManager(this);
        rv1.setLayoutManager(l);
        ap = new AdaptadorPersona();
        rv1.setAdapter(ap);
    }

    public void agregar(View v){
        Persona persona1 = new Persona(et1.getText().toString(), et2.getText().toString());
        personas.add(persona1);
        et1.setText("");
        et2.setText("");
        ap.notifyDataSetChanged();
        rv1.scrollToPosition(personas.size()-1);
    }

    public void mostrar(int pos){
        et1.setText(personas.get(pos).getNombre());
        et2.setText(personas.get(pos).getTelefono());
    }

    public void eliminar(View v){
        int pos = -1;
        String nombreEliminar = et1.getText().toString();
        for(int f=0; f < personas.size(); f++) {
            if (personas.get(f).getNombre().equals(nombreEliminar)) {
                pos = f;
                break;
            }
        }
            if(pos!= -1){
                personas.remove(pos);
                et1.setText("");
                et2.setText("");
                ap.notifyDataSetChanged();
                Toast.makeText(this, "Se elimino persona", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "No existe persona", Toast.LENGTH_SHORT).show();
            }
    }
    private class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.AdaptadorPersonaHolder> {

        @NonNull
        @Override
        public AdaptadorPersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorPersonaHolder(getLayoutInflater().inflate(R.layout.itempersona, parent, false));
        }
        
        @Override
        public void onBindViewHolder(@NonNull AdaptadorPersonaHolder holder, int position){
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return personas.size();
        }

        class AdaptadorPersonaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView tv1, tv2;

            public AdaptadorPersonaHolder(@NonNull View itemView) {
                super(itemView);
                tv1 = itemView.findViewById(R.id.tvnombre);
                tv2 = itemView.findViewById(R.id.tvtelefono);
                itemView.setOnClickListener(this);
            }

            public void imprimir(int position) {
                tv1.setText("nombre: " + personas.get(position).getNombre());
                tv2.setText("telefono: " + personas.get(position).getTelefono());
            }

            @Override
            public void onClick(View v) {
                mostrar(getLayoutPosition());
            }
        }
    }
}