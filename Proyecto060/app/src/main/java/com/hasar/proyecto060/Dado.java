package com.hasar.proyecto060;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Dado extends View {
    private int lado = 6;
    public Dado(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
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
}
