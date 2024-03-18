package com.hasar.proyecto069;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private View view2;
    private View view3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        view2 = findViewById(R.id.view2);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("Se presiona vista 2");
            }
        });
        view2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tv1.setText("Se presiono largo la vista 2");
                return true;
            }
        });
        view3 = findViewById(R.id.view3);
        view3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    tv1.setText("Evento ACTION DOWN");
                    return true;
                }
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    tv1.setText("Evento ACTION_UP");
                    return true;
                }
                if(event.getAction() == MotionEvent.ACTION_MOVE) {
                    tv1.setText("Evento ACTION_MOVE");
                    return true;
                }
                return false;
            }
        });
    }

    public void presion1(View v){
        tv1.setText("Se presiona vista 1");
    }
}