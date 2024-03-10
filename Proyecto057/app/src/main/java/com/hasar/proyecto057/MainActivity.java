package com.hasar.proyecto057;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private RequestQueue rq;
    private ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = findViewById(R.id.iv1);
        rq = Volley.newRequestQueue(this);
        recuperarImagen();
    }

    private void recuperarImagen() {
        ImageRequest requerimiento = new ImageRequest("https://scratchya.com.ar/videosandroidjava/volley/foto1.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        iv1.setImageBitmap(response);
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
        rq.add(requerimiento);
    }
}