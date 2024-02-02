package com.hasar.proyecto049_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable{
    private TextView tv1;
    private long suma;
    private boolean procesando = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
    }

    public void sumar (View v){
        if (procesando ==false){
            procesando = true;
            tv1.setText("Espere mientras calculamos la suma");
            Thread hilo = new Thread(this);
            hilo.start();
        }

    }

    @Override
    public void run() {
        suma = 0;
        for (long f = 0; f <=2_000_000_000; f++){
            suma += f;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv1.setText("La suma de 1 a 2000000000 es " + suma);
                procesando = false;
            }
        });
        }
    }
}