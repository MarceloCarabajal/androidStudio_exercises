package com.hasar.proyecto049;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable{
    private TextView tv1;
    private long suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
    }

    public void sumar (View v) {
        tv1.setText("Espere un momento estamos sumando");
        Thread hilo = new Thread(this);
        hilo.start();
    }

    public void salir(View v){
        finish();
    }

    @Override
    public void run() {
        //algoritmo que requiere mucho tiempo
        suma = 0;
        for (long i = 1; i <=2000000000; i++){
            suma+=i;
        }
        tv1.post(new Runnable() {
            @Override
            public void run() {
                tv1.setText("La suma del 1 al 2000000000 es "+ suma);
            }
        });

    }
}