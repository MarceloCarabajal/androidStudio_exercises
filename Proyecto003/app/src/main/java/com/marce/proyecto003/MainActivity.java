package com.marce.proyecto003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText et_1, et_2;
    private RadioButton rb_1, rb_2;
    private TextView tv_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_1 = findViewById(R.id.et1);
        et_2 = findViewById(R.id.et2);
        rb_1 = findViewById(R.id.rb1);
        rb_2 = findViewById(R.id.rb2);
        tv_1 = findViewById(R.id.tv1);

    }

    public void operar(View v){
        String s1 = et_1.getText().toString();
        String s2 = et_2.getText().toString();
        String s3 = tv_1.getText().toString();
        int v1 = Integer.ParseInt(s1)

        if (rb_1.isChecked()) {

        }
    }
}