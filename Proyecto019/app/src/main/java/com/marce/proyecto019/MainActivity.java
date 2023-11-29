package com.marce.proyecto019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
    }

    public void guardar(View v){
        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String fecha = et1.getText().toString();
        String actividades = et2.getText().toString();
        editor.putString(fecha,actividades);
        editor.commit();
        et1.setText("");
        et2.setText("");
        Toast.makeText(this, "actividades registradas", Toast.LENGTH_SHORT).show();
    }

    public void recuperar(View v){
        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String dato = sp.getString(et1.getText().toString(), "");
        if (dato.equals("")){
            et2.setText("");
            Toast.makeText(this, "No hay actividades para dicha fecha", Toast.LENGTH_SHORT).show();
        } else{
            et2.setText(dato);
        }
    }

}