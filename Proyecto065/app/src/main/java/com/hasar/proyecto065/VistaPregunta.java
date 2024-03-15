package com.hasar.proyecto065;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class VistaPregunta extends LinearLayout {
    private TextView tvPregunta;
    private Button buttonRta1, buttonRta2, buttonRta3;
    public VistaPregunta(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_pregunta, this, true);
        tvPregunta = findViewById(R.id.tvPregunta);
        buttonRta1 = findViewById(R.id.buttonRta1);
        buttonRta2 = findViewById(R.id.buttonRta2);
        buttonRta3= findViewById(R.id.buttonRta3);

    }
    public void fijarDatos(Pregunta pregunta) {
        tvPregunta.setText(pregunta.getPregunta());
        buttonRta1.setText(pregunta.getRespuesta1());
        buttonRta2.setText(pregunta.getRespuesta2());
        buttonRta3.setText(pregunta.getRespuesta3());
        buttonRta1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pregunta.getRespuesta() == 1) {
                    if (respuesta != null)
                        respuesta.responder(pregunta, true);
                } else {
                    if (respuesta != null) {
                        respuesta.responder(pregunta, false);
                    }
                }
                desactivarBotones();
            }
        });

        buttonRta2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pregunta.getRespuesta() == 2) {
                    if (respuesta != null)
                        respuesta.responder(pregunta, true);
                } else {
                    if (respuesta != null) {
                        respuesta.responder(pregunta, false);
                    }
                }
                desactivarBotones();
            }
        });

        buttonRta3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pregunta.getRespuesta() == 3) {
                    if (respuesta != null)
                        respuesta.responder(pregunta, true);
                } else {
                    if (respuesta != null) {
                        respuesta.responder(pregunta, false);
                    }
                }
                desactivarBotones();
            }
        });
    }

    private void desactivarBotones(){
        buttonRta1.setEnabled(false);
        buttonRta2.setEnabled(false);
        buttonRta3.setEnabled(false);
    }

    public interface Respuesta {
        public void responder(Pregunta pregunta, boolean bien);
    }
    private Respuesta respuesta;
    public void setResputa(Respuesta r){
        respuesta = r;
    }
}
