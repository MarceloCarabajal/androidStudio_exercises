package com.hasar.proyecto047;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        wv1 = findViewById(R.id.wv1);

        Bundle datos = getIntent().getExtras();
        if (datos != null) {
            et1.setText(datos.getString("direccion"));
        }

        wv1.loadUrl(et1.getText().toString());
    }
}