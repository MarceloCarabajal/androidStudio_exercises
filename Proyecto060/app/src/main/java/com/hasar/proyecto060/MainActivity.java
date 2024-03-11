package com.hasar.proyecto060;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Dado dado1, dado2, dado3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dado1 = findViewById(R.id.dado1);
        dado2 = findViewById(R.id.dado2);
        dado3 = findViewById(R.id.dado3);
    }

    public void tirar(View v){
        dado1.tirar();
        dado2.tirar();
        dado3.tirar();
        int suma = dado1.getLado()+dado2.getLado()+dado3.getLado();
        Toast.makeText(this, "La suma de los 3 dados es "+suma, Toast.LENGTH_SHORT).show();
    }
}