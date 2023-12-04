package com.marce.proyecto028;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
    }

    public void seleccionarDia(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione un día");
        String[] dias = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
        builder.setItems(dias, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("dia = "+dias[which]);
            }
        });
        builder.create().show();
    }

    public void seleccionarMeses(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione mes/meses");
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
                "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        boolean[] checks = new boolean[12];
        builder.setMultiChoiceItems(meses, checks, new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String todo = "";
                for(int f=0; f<checks.length; f++){
                    if(checks[f]){
                        todo = todo + meses[f]+"-";
                    }
                }
                tv2.setText(todo);
            }
        });
        builder.setPositiveButton("Confirmar", null);
        builder.create().show();
    }

    public void seleccionarHora(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione hora");
        String [] horas = {"8:00", "8:30", "9:00", "9:30", "10:00"};
        builder.setSingleChoiceItems(horas, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv3.setText(horas[which]);
            }
        });
        builder.setPositiveButton("Confirmar", null);
        builder.create().show();
    }
}