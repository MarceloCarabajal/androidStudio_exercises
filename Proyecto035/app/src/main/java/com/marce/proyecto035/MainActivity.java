package com.marce.proyecto035;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView vv1;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vv1 = findViewById(R.id.vv1);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
    }

    public void iniciar(View v){
        tv1.setText("Estado: Descargando de internet");
        vv1.setVideoURI(Uri.parse("https://www.scratchya.com.ar/video1.mp4"));
        vv1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                tv1.setText("Estado: Reproduciendo");
                tv2.setText("Duracion: "+(vv1.getDuration()/1000)+" seg.");
                vv1.start();
            }
        });
        vv1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                tv1.setText("Estado: Finalizado");

            }
        });
        vv1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(vv1.isPlaying()){
                    pausar(null);
                } else {
                    continuar(null);
                }
                return false;
            }
        });
    }
    public void pausar(View v){
        tv1.setText("Estado: Pausado");
        vv1.pause();
    }

    public void continuar(View v){
        tv1.setText("Estado: Reproduciendo");
        vv1.start();
    }

    public void avanzar(View v){
        int posicionActual = vv1.getCurrentPosition();
        vv1.seekTo(posicionActual+5000);
    }

    public void retroceder(View v){
        int posicionActual = vv1.getCurrentPosition();
        vv1.seekTo(posicionActual-5000);
    }
}