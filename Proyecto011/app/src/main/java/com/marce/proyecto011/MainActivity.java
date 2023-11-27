package com.marce.proyecto011;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1;
    private TextView tv_3;
    private EditText et_1, et_2;
    private String[] operaciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_1 = findViewById(R.id.et1);
        et_2 = findViewById(R.id.et2);
        tv_3 = findViewById(R.id.tv3);
        spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<String> adaptador1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operaciones);
        spinner1.setAdapter(adaptador1);
    }

    public void operar(View v){
        int valor1 = Integer.parseInt(et_1.getText().toString());
        int valor2 = Integer.parseInt(et_2.getText().toString());
        String operacion = spinner1.getSelectedItem().toString();
        if(operacion.equals("Sumar")){
            int suma = valor1 + valor2;
            tv_3.setText("La suma es: "+suma);
        }
        if(operacion.equals("Restar")){
            int resta = valor1 - valor2;
            tv_3.setText("La resta es: "+resta);
        }
        if(operacion.equals("Multiplicar")){
            int multiplica = valor1 * valor2;
            tv_3.setText("La multiplicación es: "+multiplica);
        }
        if(operacion.equals("Dividir")){
            int div = valor1 / valor2;
            tv_3.setText("La División es: "+div);
        }
    }
}