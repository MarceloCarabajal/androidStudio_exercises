package com.marce.proyecto037;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    TextView tv1;
    int suma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);

        if(savedInstanceState != null){
            suma = savedInstanceState.getInt("valor");
            tv1.setText("la suma es: "+suma);
        }
    }

    public void sumar(View v){
        int numero1 = Integer.parseInt(et1.getText().toString());
        int numero2 = Integer.parseInt(et2.getText().toString());
        suma = numero1 + numero2;
        tv1.setText("La suma: "+suma);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("valor", suma);
    }

    /* no es necesario onRestoreInstanceState, podemos hacerlo desde el mismo onCreate
    mas arriba, con un condicional

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        suma = savedInstanceState.getInt("valor");
        tv1.setText("la suma: "+suma);
    }*/
}