package com.hasar.proyecto061;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Dado extends View implements View.OnTouchListener {
    private int lado = 6;
    public Dado(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(0,0,0);
        int ancho = getWidth();
        int alto = getHeight();
        int radio = ancho/10;
        Paint pincel1 = new Paint();
        pincel1.setColor(Color.RED);
        if(lado==1 || lado==3 || lado ==5){
            canvas.drawCircle(0.5f*ancho, 0.5f*alto, radio, pincel1);
        }
        if(lado==2 || lado==3 || lado==4 || lado==5 || lado==6){
            canvas.drawCircle(0.25f*ancho,0.25f*alto, radio, pincel1);
            canvas.drawCircle(0.75f*ancho,0.75f*alto, radio, pincel1);
        }
        if(lado==4 || lado ==5 || lado ==6){
            canvas.drawCircle(0.75f*ancho,0.25f*alto, radio, pincel1);
            canvas.drawCircle(0.25f*ancho,0.75f*alto, radio, pincel1);
        }
        if(lado==6){
            canvas.drawCircle(0.5f*ancho,0.25f*alto, radio, pincel1);
            canvas.drawCircle(0.5f*ancho,0.75f*alto, radio, pincel1);
        }
    }
    public void tirar(){
        lado = 1+(int)(Math.random()*6);
        invalidate();
    }

    public int getLado() {
        return lado;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        tirar();
        return false;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int anchoDeseado = displayMetrics.widthPixels/5;
        int altoDeseado = displayMetrics.widthPixels/5;

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