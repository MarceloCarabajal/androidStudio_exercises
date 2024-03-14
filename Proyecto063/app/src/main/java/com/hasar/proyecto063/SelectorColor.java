package com.hasar.proyecto063;

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

public class SelectorColor extends View implements View.OnTouchListener {
    private int[] colores = {Color.RED, Color.BLUE, Color.BLACK, Color.YELLOW, Color.CYAN, Color.DKGRAY, Color.GREEN};
    private int colorSeleccionado = colores[0];
    public SelectorColor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        int ancho = getWidth();
        int anchoColor= ancho / colores.length;
        Paint pincel1 = new Paint();
        int columna = 0;
        for (int f=0; f<colores.length; f++){
            pincel1.setColor(colores[f]);
            canvas.drawRect(columna, 0,columna + anchoColor, anchoColor, pincel1);
            if(colores[f] == colorSeleccionado){
                Paint pincel2 = new Paint();
                pincel2.setColor(Color.WHITE);
                canvas.drawCircle(columna+(anchoColor/2), getHeight()/2, getHeight()/2, pincel2);
            }
            columna=columna+anchoColor;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int anchoDeseado = displayMetrics.widthPixels;
        int altoDeseado = displayMetrics.widthPixels/10;

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

    public int retornarColor() {
        return colorSeleccionado;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int anchoColor = getWidth()/colores.length;
        float columnaClick = event.getX();
        colorSeleccionado = colores[(int)(columnaClick/anchoColor)];
        invalidate();
        return false;
    }
}
