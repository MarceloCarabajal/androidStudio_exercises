package com.marce.proyecto016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = findViewById(R.id.tv1);
        Bundle datos = getIntent().getExtras();
        int valor1 = datos.getInt("valor1");
        int valor2 = datos.getInt("valor2");
        String op = datos.getString("operacion");
        switch (op){
            case "sumar":
                int sumar = valor1 + valor2;
                tv1.setText(valor1+"+"+valor2+"="+sumar);
                break;
            case "restar":
                int restar = valor1 - valor2;
                tv1.setText(valor1+"-"+valor2+"="+restar);
                break;
            case "multiplicar":
                int multiplicar = valor1 * valor2;
                tv1.setText(valor1+"*"+valor2+"="+multiplicar);
                break;
            case "dividir":
                int dividir = valor1 / valor2;
                tv1.setText(valor1+"/"+valor2+"="+dividir);
                break;
        }
    }

    public void regresar(View v){
        finish();
    }


}