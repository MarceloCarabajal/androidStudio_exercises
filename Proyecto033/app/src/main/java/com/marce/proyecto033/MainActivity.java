package com.marce.proyecto033;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv1 = findViewById(R.id.wv1);
        wv1.setWebViewClient(new WebViewClient());
        WebSettings ws = wv1.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDefaultFontSize(10);

        wv1.loadUrl("https://www.scratchya.com.ar/phpyotros/crud");
    }

    public void retroceder(View v){
        wv1.goBack();
    }

    public void aumentar(View v){
        wv1.zoomIn();
    }

    public void reducir(View v){
        wv1.zoomOut();
    }
}