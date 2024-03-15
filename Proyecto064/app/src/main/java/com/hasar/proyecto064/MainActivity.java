package com.hasar.proyecto064;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private CronometroRegresivo cronometroRegresivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cronometroRegresivo = findViewById(R.id.cronometroRegresivo);
        cronometroRegresivo.fijarSegundos(10);
        cronometroRegresivo.fijarTiempoCumplido(new CronometroRegresivo.TiempoCumplido() {
            @Override
            public void tiempo() {
                finish();
            }
        });
    }

    public void iniciar(View v){

        cronometroRegresivo.iniciar();
    }
}