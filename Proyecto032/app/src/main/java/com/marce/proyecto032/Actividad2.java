package com.marce.proyecto032;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Actividad2 extends AppCompatActivity {
    WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        //getSupportActionBar().hide();

        wv1 = findViewById(R.id.wv1);
        String direccion = getIntent().getExtras().getString("direccion");
        wv1.loadUrl(direccion);
        wv1.setWebViewClient(new WebViewClient());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && wv1.canGoBack()){
            wv1.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}