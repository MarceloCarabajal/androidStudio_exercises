package com.marce.proyecto005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch switch_1, switch_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switch_1 = findViewById(R.id.switch1);
        switch_2 = findViewById(R.id.switch2);
    }

    public void verificar(View v){
        if(switch_1.isChecked()) {
            Toast.makeText(MainActivity.this, "Datos moviles activados", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(MainActivity.this, "Datos moviles Desactivados", Toast.LENGTH_SHORT).show();
        }
        if(switch_2.isChecked()){
            Toast.makeText(this, "Wifi activado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wifi desactivado", Toast.LENGTH_SHORT).show();
        }
    }

    public void verificarDatosMoviles(View v){
        if(switch_1.isChecked()) {
            Toast.makeText(MainActivity.this, "Datos moviles activados", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(MainActivity.this, "Datos moviles Desactivados", Toast.LENGTH_SHORT).show();
        }
    }

    public void verificarWifi(View v){
        if(switch_2.isChecked()){
            Toast.makeText(this, "Wifi activado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wifi desactivado", Toast.LENGTH_SHORT).show();
        }
    }
}