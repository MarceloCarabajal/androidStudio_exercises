package com.hasar.proyecto071;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private GestureDetector gestos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        gestos = new GestureDetector(this, new EscuchaGestos());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestos.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class EscuchaGestos extends GestureDetector.SimpleOnGestureListener {

        @Override
        public void onLongPress(@NonNull MotionEvent e) {
            tv1.setText("Presion Larga");
        }

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            tv1.setText("Doble toque");
            return true;
        }

        @Override
        public void onShowPress(@NonNull MotionEvent e) {
            tv1.setText("Presion");
        }

        @Override
        public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            float ancho = Math.abs(e2.getX()-e1.getX());
            float alto = Math.abs(e2.getY()-e1.getY());
            if (ancho > alto){
                if(e2.getX()>e1.getX()){
                    tv1.setText("Desplazamiento a derecha");
                } else {
                    tv1.setText("Desplazamiento a izquierda");
                }
            } else {
                if(e2.getY()>e1.getY()){
                    tv1.setText("Desplazamiento abajo");
                } else {
                    tv1.setText("Desplazamiento arriba");
                }
            }

            return true;
        }
    }
}