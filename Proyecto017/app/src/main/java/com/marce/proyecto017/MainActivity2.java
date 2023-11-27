package com.marce.proyecto017;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText et1, et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1 = findViewById(R.id.et1);
    }

    public void confirmar(View v){
        Intent intent = new Intent();
        intent.putExtra("usuario", et1.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
    public void cancelar(View v){
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }
}