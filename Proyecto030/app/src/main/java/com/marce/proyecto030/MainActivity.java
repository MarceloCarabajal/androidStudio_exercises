package com.marce.proyecto030;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
    }

    public void borrar(View v){
        DialogoMensaje dialogo = new DialogoMensaje("Desea borrar el nombre ingresado?");
        dialogo.show(getSupportFragmentManager(), "dialogo1");
        dialogo.procesarRespuesta(new DialogoMensaje.Respuestas() {
            @Override
            public void confirmar(DialogFragment dialog) {
                et1.setText("");
            }

            @Override
            public void cancelar(DialogFragment dialog) {

            }
        });
    }

    public void salir(View v){
        DialogoMensaje dialogo = new DialogoMensaje("Realmente quiere abandonar el programa?");
        dialogo.show(getSupportFragmentManager(), "dialogo2");
        dialogo.procesarRespuesta(new DialogoMensaje.Respuestas() {
            @Override
            public void confirmar(DialogFragment dialog) {
                finish();
            }

            @Override
            public void cancelar(DialogFragment dialog) {
                Toast.makeText(MainActivity.this, "Gracias por seguir utilizando el programa", Toast.LENGTH_LONG).show();
            }
        });
    }
}