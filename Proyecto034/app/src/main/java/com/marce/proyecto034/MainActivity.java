package com.marce.proyecto034;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView vv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        vv1 = findViewById(R.id.vv1);

        vv1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.tanbionicaciudadmagica));

        MediaController mc = new MediaController(this);
        vv1.setMediaController(mc);
        mc.setAnchorView(vv1);

        vv1.start();
    }
}