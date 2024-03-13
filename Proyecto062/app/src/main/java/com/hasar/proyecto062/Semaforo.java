package com.hasar.proyecto062;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class Semaforo extends View {
    private int color = Color.GREEN;
    private Paint p1;
    private Handler manejador = new Handler(Looper.getMainLooper());
    private Runnable tiempo;
    public Semaforo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        p1 = new Paint();
        tiempo = new Runnable() {
            @Override
            public void run() {
                if (color==Color.GREEN){
                    color = Color.YELLOW;
                    manejador.postDelayed(this, 1000);
                } else if (color == Color.YELLOW){
                    color = Color.RED;
                    manejador.postDelayed(this, 5000);
                } else {
                    color = Color.GREEN;
                    manejador.postDelayed(this, 5000);
                }
                invalidate();
            }
        };
        manejador.postDelayed(tiempo, 5000);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(60,60,60);
        int ancho = getWidth();
        int alto = getHeight();
        int radio = alto/6 - 30;
        if (color == Color.RED)
            p1.setColor(color);
        else
            p1.setColor(Color.GRAY);
        canvas.drawCircle(ancho/2, alto*0.16f, radio, p1);

        if (color == Color.YELLOW)
            p1.setColor(color);
        else
            p1.setColor(Color.GRAY);
        canvas.drawCircle(ancho/2, alto*0.5f, radio, p1);

        if (color == Color.GREEN)
            p1.setColor(color);
        else
            p1.setColor(Color.GRAY);
        canvas.drawCircle(ancho/2, alto*0.83f, radio, p1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int anchoDeseado = displayMetrics.widthPixels/4;
        int altoDeseado = anchoDeseado*3;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int ancho = 0;

        //Measure ancho
        if(widthMode == MeasureSpec.EXACTLY){
            //significa que el valor layout_width o layout_height se establecio en un valor especifico
            ancho = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST){
            //significa que el valor layout_width o layout_height se establecio en un valor match_marent o wrap_parent
            ancho= Math.min(anchoDeseado, widthSize);
        } else {
            ancho = anchoDeseado;
        }

        int alto = 0;
        // Measure alto
        if (heightMode == MeasureSpec.EXACTLY) {
            alto = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            alto = Math.min(altoDeseado, heightSize);
        } else {
            alto = altoDeseado;
        }
        //obligatoriamente debemos llamar a este metodo
        setMeasuredDimension(ancho, alto);
    }
}
