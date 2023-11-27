package com.marce.proyecto004;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_1, et_2;
    private CheckBox check_1, check_2;
    private TextView tv_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_1 = findViewById(R.id.et1);
        et_2 = findViewById(R.id.et2);
        check_1 = findViewById(R.id.check1);
        check_2 = findViewById(R.id.check2);
        tv_1 = findViewById(R.id.tv1);

    }

    public void operar(View v){
        int v1 = Integer.parseInt(et_1.getText().toString());
        int v2 = Integer.parseInt(et_2.getText().toString());
        String resu = "";
        if (check_1.isChecked()){
            int suma = v1 + v2;
            resu += "La suma es " + suma + " ";
        }
        if (check_2.isChecked()){
            int resta = v1-v2;
            resu += "La resta es: " + resta + " ";
        }
        tv_1.setText(resu);
    }
}