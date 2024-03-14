package com.hasar.proyecto063;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SelectorColor selectorColor1;
    private Dibujo dibujo1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectorColor1 = findViewById(R.id.selectorColor1);
        dibujo1 = findViewById(R.id.dibujo1);
    }

    public void seleccion(View v){
        dibujo1.fijarColor(selectorColor1.retornarColor());
    }
}