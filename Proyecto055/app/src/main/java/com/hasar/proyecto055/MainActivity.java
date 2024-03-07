package com.hasar.proyecto055;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText etCodigo, etDescripcion, etPrecio;
    private RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCodigo = findViewById(R.id.etCodigo);
        etDescripcion = findViewById(R.id.etDescripcion);
        etPrecio = findViewById(R.id.etPrecio);
        rq = Volley.newRequestQueue(this);
    }

    public void consultar (View v){
        String url = "https://scratchya.com.ar/videosandroidjava/volley/consultar.php?codigo="+etCodigo.getText().toString();
        JsonArrayRequest requerimiento = new JsonArrayRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response.length()==1){
                            try {
                                JSONObject objeto = new JSONObject(response.get(0).toString());
                                etDescripcion.setText(objeto.getString("descripcion"));
                                etPrecio.setText(objeto.getString("precio"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "No existe codigo de articulo ingresado", Toast.LENGTH_SHORT).show();
                            etDescripcion.setText("");
                            etPrecio.setText("");
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

    public void borrar(View v) {
        String url = "https://scratchya.com.ar/videosandroidjava/volley/borrar.php";
        JSONObject parametros = new JSONObject();
        try {
            parametros.put("codigo", etCodigo.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest requerimiento = new JsonObjectRequest(Request.Method.POST,
                url,
                parametros,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String resu = response.get("resultado").toString();
                            if(resu.equals("1")){
                                Toast.makeText(MainActivity.this, "Se elimino el artículo", Toast.LENGTH_SHORT).show();
                                etDescripcion.setText("");
                                etCodigo.setText("");
                                etPrecio.setText("");
                            } else {
                                Toast.makeText(MainActivity.this, "No existe codigo de articulo ingresado", Toast.LENGTH_SHORT).show();
                            }
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

    public void modificar(View v) {
        String url = "https://scratchya.com.ar/videosandroidjava/volley/modificar.php";
        JSONObject parametros = new JSONObject();
        try {
            parametros.put("codigo", etCodigo.getText().toString());
            parametros.put("descripcion", etDescripcion.getText().toString());
            parametros.put("precio", etPrecio.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest requerimiento = new JsonObjectRequest(Request.Method.POST,
                url,
                parametros,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String resu = response.get("resultado").toString();
                            if(resu.equals("1")){
                                Toast.makeText(MainActivity.this, "Se modificaron los datos del artículo", Toast.LENGTH_SHORT).show();
                                etDescripcion.setText("");
                                etCodigo.setText("");
                                etPrecio.setText("");
                            } else {
                                Toast.makeText(MainActivity.this, "No existe codigo de articulo ingresado", Toast.LENGTH_SHORT).show();
                            }
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
}