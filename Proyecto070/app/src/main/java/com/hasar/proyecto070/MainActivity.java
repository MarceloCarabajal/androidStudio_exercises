package com.hasar.proyecto070;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View view1;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1 = findViewById(R.id.view1);
        tv1 = findViewById(R.id.tv1);
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int dedos = event.getPointerCount();
                if (dedos == 2) {
                    int x1 = (int) event.getX(0);
                    int y1 = (int) event.getY(0);
                    int x2 = (int) event.getX(1);
                    int y2 = (int) event.getY(1);
                    int cateto1 = Math.abs(x1-x2);
                    int cateto2 = Math.abs(y1-y2);
                    float hipotenusa = (float)Math.sqrt(cateto1*cateto1+cateto2*cateto2);
                    tv1.setText("X1 = " + x1 + " Y1 = " + y1 + "\nX2 = " + x2 + " Y2 = " +y2+"\nHipotenusa: "+hipotenusa);
                    float transparencia = 1 -(hipotenusa)/1000;
                    view1.setAlpha(transparencia);
                }
                else
                    view1.setAlpha(1);
                return true;
            }
        });
    }
}