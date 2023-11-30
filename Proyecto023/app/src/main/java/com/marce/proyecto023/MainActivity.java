package com.marce.proyecto023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudeopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int nro = item.getItemId();
        float valor;

        if(nro == R.id.agrandarfuente){
            valor = tv1.getTextSize();
            valor = valor + 20;
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_PX, valor);
            return true;
        } else if(nro == R.id.reducirfuente){
            valor = tv1.getTextSize();
            valor = valor - 20;
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_PX, valor);
            return true;
        } else if(nro == R.id.salir){
            finish();
            return true;
        } else if(nro == R.id.azul){
            tv1.setTextColor(Color.BLUE);
            return true;
        } else if(nro == R.id.rojo){
            tv1.setTextColor(Color.RED);
            return true;
        } else if(nro == R.id.verde){
            tv1.setTextColor(Color.GREEN);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}