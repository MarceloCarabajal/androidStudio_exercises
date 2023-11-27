package com.marce.proyecto008;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private String jugador = "x";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
    }

    public void presion(View v){
        Button b = (Button)v;
        if(b.getText().toString().equals(""))
            b.setText(jugador);
            verificarGano(jugador);
            cambiarJugador();
    }

    private void cambiarJugador() {
        if(jugador.equals("x")){
            jugador = "o";
        } else{
            jugador = "x";
        }
    }

    private void verificarGano(String turno){
        String casilla1 = b1.getText().toString();
        String casilla2 = b2.getText().toString();
        String casilla3 = b3.getText().toString();
        String casilla4 = b4.getText().toString();
        String casilla5 = b5.getText().toString();
        String casilla6 = b6.getText().toString();
        String casilla7 = b7.getText().toString();
        String casilla8 = b8.getText().toString();
        String casilla9 = b9.getText().toString();
        if(casilla1.equals(turno) && casilla2.equals(turno) && casilla3.equals(turno))
            gano(turno);
        if(casilla4.equals(turno) && casilla5.equals(turno) && casilla6.equals(turno))
            gano(turno);
        if(casilla7.equals(turno) && casilla8.equals(turno) && casilla9.equals(turno))
            gano(turno);
        if(casilla1.equals(turno) && casilla4.equals(turno) && casilla7.equals(turno))
            gano(turno);
        if(casilla2.equals(turno) && casilla5.equals(turno) && casilla8.equals(turno))
            gano(turno);
        if(casilla3.equals(turno) && casilla6.equals(turno) && casilla9.equals(turno))
            gano(turno);
        if(casilla1.equals(turno) && casilla5.equals(turno) && casilla9.equals(turno))
            gano(turno);
        if(casilla3.equals(turno) && casilla5.equals(turno) && casilla7.equals(turno))
            gano(turno);
    }

    private void gano(String jugador){
        Toast.makeText(this, "Gano el jugador " + jugador, Toast.LENGTH_SHORT).show();
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }

    public void salir(View v){
        finish();
    }
}