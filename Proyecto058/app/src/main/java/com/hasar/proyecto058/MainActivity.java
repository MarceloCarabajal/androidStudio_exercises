package com.hasar.proyecto058;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Usuario> listaUsuario;
    private RecyclerView rv1;
    private AdaptadorUsuario adaptadorUsuario;
    private RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaUsuario = new ArrayList<>();
        rq = Volley.newRequestQueue(this);
        for(int f=0; f<10; f++){
            cargarPersona();
        }
        rv1 = findViewById(R.id.rv1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv1.setLayoutManager(linearLayoutManager);
        adaptadorUsuario = new AdaptadorUsuario();
        rv1.setAdapter(adaptadorUsuario);
    }

    private void cargarPersona(){
        String url = "https://randomuser.me/api/";
        JsonObjectRequest requerimiento = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String valor = response.get("results").toString();
                            JSONArray arreglo = new JSONArray(valor);
                            JSONObject objeto = new JSONObject(arreglo.get(0).toString());
                            String mail = objeto.getString("email");
                            String nombre = objeto.getJSONObject("name").getString("last");
                            String foto = objeto.getJSONObject("picture").getString("large");
                            Usuario usuario = new Usuario(nombre, mail, foto);
                            listaUsuario.add(usuario);
                            adaptadorUsuario.notifyItemRangeInserted(listaUsuario.size(), 1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        rq.add(requerimiento);
    }

    private class AdaptadorUsuario extends RecyclerView.Adapter<AdaptadorUsuario.AdaptadorUsuarioHolder>{

        @NonNull
        @Override
        public AdaptadorUsuarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorUsuarioHolder(getLayoutInflater().inflate(R.layout.layout_tarjeta, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorUsuarioHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return listaUsuario.size();
        }

        class AdaptadorUsuarioHolder extends RecyclerView.ViewHolder{
            TextView tvNombre, tvMail;
            ImageView ivFoto;
            public AdaptadorUsuarioHolder(@NonNull View itemView) {
                super(itemView);
                tvNombre = itemView.findViewById(R.id.tvNombre);
                tvMail = itemView.findViewById(R.id.tvMail);
                ivFoto = itemView.findViewById(R.id.ivFoto);
            }
            public void imprimir(int position){
                tvNombre.setText("Nombre: "+listaUsuario.get(position).getNombre());
                tvMail.setText("Email: "+listaUsuario.get(position).getMail());
                recuperarImg(listaUsuario.get(position).getFoto(), ivFoto);
            }

            public void recuperarImg(String foto, ImageView iv) {
                ImageRequest peticion = new ImageRequest(foto,
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {
                                iv.setImageBitmap(response);
                            }
                        },
                        0,
                        0,
                        null,
                        null,
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                rq.add(peticion);
            }
        }
    }
}