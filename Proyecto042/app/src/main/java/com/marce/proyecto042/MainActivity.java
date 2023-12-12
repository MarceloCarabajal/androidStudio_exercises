package com.marce.proyecto042;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etEmail, etTema, etContenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = findViewById(R.id.etEmail);
        etTema = findViewById(R.id.etTema);
        etContenido = findViewById(R.id.etContenido);
    }

    public void enviar(View v){
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{etEmail.getText().toString()});
        i.putExtra(Intent.EXTRA_SUBJECT, etTema.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT, etContenido.getText().toString());

        startActivity(i);
    }
}