package com.hasar.proyecto063;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Dibujo extends View implements View.OnTouchListener {
    private ArrayList<Circulo> circulos = new ArrayList<Circulo>();
    private int colorSeleccionado = Color.RED;
    public Dibujo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(230, 230,230);
        Paint pincel1 = new Paint();
        for(int f = 0 ; f<circulos.size(); f++){
            pincel1.setColor(circulos.get(f).color);
            canvas.drawCircle(circulos.get(f).x, circulos.get(f).y,20, pincel1);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Circulo circulo = new Circulo(event.getX(), event.getY(), colorSeleccionado);
        circulos.add(circulo);
        invalidate();
        return true;
    }

    public void fijarColor(int color) {
        colorSeleccionado = color;
    }

    class Circulo {
        float x,y;
        int color;

        public Circulo(float x, float y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
