package com.marce.proyecto032;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ingresar(View v){
        Intent intento = new Intent(this, Actividad2.class);
        EditText et1 = findViewById(R.id.et1);
        intento.putExtra("direccion", et1.getText().toString());
        startActivity(intento);
    }
}