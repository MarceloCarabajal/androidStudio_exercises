package com.marce.proyecto042;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etDireccion, etTema, etContenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDireccion = findViewById(R.id.etDireccion);
        etTema = findViewById(R.id.etTema);
        etContenido = findViewById(R.id.etContenido);
    }

    public void enviar(View v){
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{etDireccion.getText().toString()});
        i.putExtra(Intent.EXTRA_SUBJECT, new String[]{etTema.getText().toString()});
        i.putExtra(Intent.EXTRA_TEXT, new String[]{etContenido.getText().toString()});
        startActivity(i);
    }
}