package com.marce.proyecto006;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageButton img_btn;
    private ImageView iv_1, iv_2, iv_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_1 = findViewById(R.id.iv1);
        iv_2 = findViewById(R.id.iv2);
        iv_3 = findViewById(R.id.iv3);
    }

    public void tirar(View v){
        int valor1 = 1 + (int)(Math.random()*6);
        int valor2 = 1 + (int)(Math.random()*6);
        int valor3 = 1 + (int)(Math.random()*6);
        switch (valor1){
            case 1: iv_1.setImageResource(R.drawable.dado1); break;
            case 2: iv_1.setImageResource(R.drawable.dado2); break;
            case 3: iv_1.setImageResource(R.drawable.dado3); break;
            case 4: iv_1.setImageResource(R.drawable.dado4); break;
            case 5: iv_1.setImageResource(R.drawable.dado5); break;
            case 6: iv_1.setImageResource(R.drawable.dado6); break;
        }
        switch (valor2){
            case 1: iv_2.setImageResource(R.drawable.dado1); break;
            case 2: iv_2.setImageResource(R.drawable.dado2); break;
            case 3: iv_2.setImageResource(R.drawable.dado3); break;
            case 4: iv_2.setImageResource(R.drawable.dado4); break;
            case 5: iv_2.setImageResource(R.drawable.dado5); break;
            case 6: iv_2.setImageResource(R.drawable.dado6); break;
        }
        switch (valor3){
            case 1: iv_3.setImageResource(R.drawable.dado1); break;
            case 2: iv_3.setImageResource(R.drawable.dado2); break;
            case 3: iv_3.setImageResource(R.drawable.dado3); break;
            case 4: iv_3.setImageResource(R.drawable.dado4); break;
            case 5: iv_3.setImageResource(R.drawable.dado5); break;
            case 6: iv_3.setImageResource(R.drawable.dado6); break;
        }
    }
}