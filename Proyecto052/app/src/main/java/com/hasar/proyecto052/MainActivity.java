package com.hasar.proyecto052;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private RadioButton r1, r2;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        tv1 = findViewById(R.id.tv1);
    }

    public void operar(View v){
        int valor1 = Integer.parseInt(et1.getText().toString());
        int valor2 = Integer.parseInt(et2.getText().toString());
        if(r1.isChecked()){
            int suma = valor1 + valor2;
            tv1.setText(getString(R.string.resultado)+suma);
        }
        if(r2.isChecked()){
            int resta = valor1-valor2;
            tv1.setText(getString(R.string.resultado)+resta);
        }
    }
}