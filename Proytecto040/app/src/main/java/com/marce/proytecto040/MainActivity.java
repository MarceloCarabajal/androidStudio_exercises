package com.marce.proytecto040;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button boton1, boton2;
    TextView tv1;
    MediaPlayer mp1;
    String numeroRecordar;
    String numeroJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = findViewById(R.id.button1);
        boton2 = findViewById(R.id.button2);
        tv1 = findViewById(R.id.tv1);
        desactivarBotones();

    }

    public void desactivarBotones(){
        boton1.setEnabled(false);
        boton2.setEnabled(false);
    }

    public void activarBotones(){
        boton1.setEnabled(true);
        boton2.setEnabled(true);
    }

    public void iniciarJuego(View v){
        desactivarBotones();
        numeroRecordar="";
        agregarUnNumeroAlFinal();
        tv1.setText("Cantidad de cifras a recordar: "+numeroRecordar.length());
        numeroJugador = "";
        emitirSonido(0);
    }

    private void emitirSonido(int pos){
        if (mp1 != null)
            mp1.release();
        if(numeroRecordar.charAt(pos) == '1'){
            mp1 = MediaPlayer.create(this, R.raw.uno);
        } else if(numeroRecordar.charAt(pos) == '2') {
            mp1 = MediaPlayer.create(this, R.raw.dos);
        }
        if(mp1 != null){
            mp1.start();
            mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (pos < numeroRecordar.length()-1){
                        emitirSonido(pos+1);
                    } else {
                        activarBotones();
                    }
                }
            });
        }
    }


    private void agregarUnNumeroAlFinal() {
        int min = 1;
        int max = 2;
        int aleatorio = min + (int) (Math.random() * ((max - min) + 1));
        switch (aleatorio) {
            case 1:
                numeroRecordar = numeroRecordar + "1";
                break;
            case 2:
                numeroRecordar = numeroRecordar + "2";
                break;
        }
    }

    public void presionBtn1(View v){
        numeroJugador = numeroJugador + "1";
        controlarSiEsCorrecto();
    }
    public void presionBtn2(View v){
        numeroJugador = numeroJugador + "2";
        controlarSiEsCorrecto();
    }



    private void controlarSiEsCorrecto(){
        if(numeroJugador.charAt(numeroJugador.length()-1) != numeroRecordar.charAt(numeroJugador.length()-1)){
            Toast.makeText(this, "Perdiste", Toast.LENGTH_SHORT).show();
            desactivarBotones();
        } else if(numeroJugador.length() == numeroRecordar.length()){
                desactivarBotones();
                numeroJugador = "";
                agregarUnNumeroAlFinal();
                emitirSonido(0);
                tv1.setText("Cantidad de cifras a recordar: "+ numeroRecordar.length());
            }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mp1 != null){
            mp1.release();
            mp1 = null;
        }
    }
}