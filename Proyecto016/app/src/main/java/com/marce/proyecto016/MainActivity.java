package com.marce.proyecto016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        spinner1 = findViewById(R.id.spinner1);
        String[] operaciones = {"sumar", "restar", "multiplicar", "dividir"};
        ArrayAdapter <String>adaptador1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operaciones);
        spinner1.setAdapter(adaptador1);
    }
    public void resultado(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        int valor1 = Integer.parseInt(et1.getText().toString());
        int valor2 = Integer.parseInt(et2.getText().toString());
        String operacion = spinner1.getSelectedItem().toString();
        intent.putExtra("valor1", valor1);
        intent.putExtra("valor2", valor2);
        intent.putExtra("operacion", operacion);
        startActivity(intent);
    }


}