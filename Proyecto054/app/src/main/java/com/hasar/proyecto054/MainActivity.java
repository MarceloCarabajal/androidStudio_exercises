package com.hasar.proyecto054;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText etdescripcion, etPrecio;
    private RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etdescripcion = findViewById(R.id.etDescripcion);
        etPrecio = findViewById(R.id.etPrecio);
        rq = Volley.newRequestQueue(this);
    }

    public void agregar(View v){
        String url ="https://scratchya.com.ar/videosandroidjava/volley/insertar.php";
        JSONObject parametros = new JSONObject();
        try {
            parametros.put("descripcion", etdescripcion.getText().toString());
            parametros.put("precio", etPrecio.getText().toString());
        } catch (JSONException e){
            e.printStackTrace();
        }
        JsonObjectRequest requerimiento = new JsonObjectRequest(Request.Method.POST,
                url,
                parametros,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.get("respuesta").toString().equals("ok")) {
                                Toast.makeText(MainActivity.this, "Datos cargados correctamente", Toast.LENGTH_SHORT).show();
                                etdescripcion.setText("");
                                etPrecio.setText("");
                            } else {
                                Toast.makeText(MainActivity.this, response.get("respuesta").toString(), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Problemas con el servidor", Toast.LENGTH_SHORT).show();
                    }
                });
        rq.add(requerimiento);
    }
}