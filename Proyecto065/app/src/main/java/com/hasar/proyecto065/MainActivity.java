package com.hasar.proyecto065;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Pregunta> lista = new ArrayList<>();
    private LinearLayout layout1;
    private ScrollView sv1;
    private int correctas, incorrectas;
    private TextView tvRespuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
        layout1 = findViewById(R.id.layout1);
        sv1 = findViewById(R.id.sv1);
        tvRespuesta = findViewById(R.id.tvResultado);
        lista.add(new Pregunta("Cual es el lenguajes mas usado?", "Kotlin", "PHP", "C", 3));
        lista.add(new Pregunta("Cual de estos lenguajes creó Google?", "Go", "Swift", "Java", 1));
        lista.add(new Pregunta("Cual de estos lenguajes se utiliza para programar en Android?", "Java", "PHP", "Perl", 1));
        lista.add(new Pregunta("Que lenguaje se utiliza para consultar una base de datos relacional?", "C#", "SQL", "Java", 2));
        lista.add(new Pregunta("Cual de estos lenguajes creo Microsoft?", "Java", "Kotlin", "C#", 3));

        for(int f = 0 ; f<lista.size(); f++){
            VistaPregunta vistaPregunta = new VistaPregunta(this, null);
            vistaPregunta.fijarDatos(lista.get(f));
            layout1.addView(vistaPregunta);
            vistaPregunta.setResputa(new VistaPregunta.Respuesta() {
                @Override
                public void responder(Pregunta pregunta, boolean bien) {
                    if(bien){
                        correctas++;
                    } else {
                        incorrectas++;
                    }
                    if(correctas+incorrectas == lista.size()){
                        tvRespuesta.setText("Correctas: "+ correctas +" - Incorrectas: "+incorrectas);
                        sv1.fullScroll(View.FOCUS_UP);
                    }
                }
            });
        }

    }
}