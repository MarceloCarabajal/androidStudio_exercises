package com.marce.proyecto010;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void presion(View v){
        ImageButton ib = (ImageButton)v;
        ib.setVisibility(View.INVISIBLE);
    }

    public void mostrarCartas(View v){
        ImageButton ib1 = findViewById(R.id.imageButton);
        ImageButton ib2 = findViewById(R.id.imageButton2);
        ImageButton ib3 = findViewById(R.id.imageButton3);

        ib1.setVisibility(View.VISIBLE);
        ib2.setVisibility(View.VISIBLE);
        ib3.setVisibility(View.VISIBLE);
    }
}