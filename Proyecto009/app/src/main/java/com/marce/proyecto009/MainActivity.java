package com.marce.proyecto009;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv_1;
    String pais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_1 = findViewById(R.id.tv1);
        int nro=(int)(Math.random()*6);
        switch (nro){
            case 0: pais = "Argentina"; break;
            case 1: pais = "Brasil"; break;
            case 2: pais = "Chile"; break;
            case 3: pais = "El Salvador"; break;
            case 4: pais = "Uruguay"; break;
            case 5: pais = "Venezuela"; break;
        }
        tv_1 = findViewById(R.id.tv1);
        tv_1.setText("Cual es la bandera de "+ pais);
    }

    public void presionar(View v){
        ImageButton b = (ImageButton)v;
        if(b.getTag().toString().equals(pais)){
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrecto, señalaste la bandera de " + b.getTag().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}