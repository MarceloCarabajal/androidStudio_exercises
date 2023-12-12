package com.marce.proyecto041;
//INTENT EXPLICITOS E IMPLICITOS
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirNavegador(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lanacion.com.ar"));
        startActivity(i);
    }

    public void abrirMapa(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-31.417, -64.183"));
        startActivity(i);
    }

    public void mostrarContactos(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
        startActivity(i);
    }
    public void abrirCamara(View v){
        Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(i);
    }
    public void abrirMarcadorTel(View v){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567"));
        startActivity(i);
    }
    public void enviarSms(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:1234567"));
        startActivity(i);
    }
}