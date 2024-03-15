package com.hasar.proyecto064;


import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class CronometroRegresivo extends AppCompatTextView implements Runnable{
    private int segundos = 60;
    public CronometroRegresivo(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setTextSize(50);
        setText(String.valueOf(segundos));
    }

    public void iniciar() {
        postDelayed(this, 1000);
    }

    public void fijarSegundos(int segundos){
        this.segundos = segundos;
        setText(String.valueOf(this.segundos));
    }

    @Override
    public void run() {
        if (segundos > 0){
            segundos --;
            setText(String.valueOf(segundos));
            postDelayed(this, 1000);
        } else {
            if (tiempoCumplido != null) {
                tiempoCumplido.tiempo();
            }
        }
    }

    public interface TiempoCumplido {
        public void tiempo();
    }
    private TiempoCumplido tiempoCumplido = null;

    public void fijarTiempoCumplido(TiempoCumplido t){
        tiempoCumplido = t;
    }

}
