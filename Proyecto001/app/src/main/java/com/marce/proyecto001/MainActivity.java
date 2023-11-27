package com.marce.proyecto001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void presion(View v){
        Toast.makeText(MainActivity.this, "Se presiono el boton", Toast.LENGTH_SHORT).show();
    }

    public void presion2(View v){
        Toast.makeText(MainActivity.this, "Se presiono el segundo boton", Toast.LENGTH_SHORT).show();
    }
}