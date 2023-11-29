package com.marce.proyecto020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPatente, etMarca, etModelo, etPrecio;
    AdminSQLiteOpenHelper admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPatente = findViewById(R.id.etpatente);
        etMarca = findViewById(R.id.etmarca);
        etModelo = findViewById(R.id.etmodelo);
        etPrecio = findViewById(R.id.etprecio);
        admin = new AdminSQLiteOpenHelper(this, "bd1", null, 1);
    }

    public void agregar(View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("patente", etPatente.getText().toString());
        registro.put("marca", etMarca.getText().toString());
        registro.put("modelo", etModelo.getText().toString());
        registro.put("precio", etPrecio.getText().toString());
        bd.insert("vehiculos", null, registro);
        etPatente.setText("");
        etMarca.setText("");
        etModelo.setText("");
        etPrecio.setText("");
        bd.close();
        Toast.makeText(this, "Se almaceno vehiculo", Toast.LENGTH_SHORT).show();
    }

    public void consultaPatente(View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        String patente = etPatente.getText().toString();
        Cursor fila = bd.rawQuery("select marca,modelo,precio from vehiculos where patente= '"+patente+"'",null);
        if(fila.moveToFirst()){
            etMarca.setText(fila.getString(0));
            etModelo.setText(fila.getString(1));
            etPrecio.setText(fila.getString(2));
        } else {
            Toast.makeText(this, "No existe vehiculo con dicha patente", Toast.LENGTH_SHORT).show();
            etPatente.setText("");
            etMarca.setText("");
            etModelo.setText("");
            etPrecio.setText("");
        }
        bd.close();
    }

    public void borrar(View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        String patente = etPatente.getText().toString();
        int cant = bd.delete("vehiculos", "patente='"+patente+"'", null);
        if(cant == 1){
            Toast.makeText(this, "Se elimino el vehículo", Toast.LENGTH_SHORT).show();
            etPatente.setText("");
            etMarca.setText("");
            etModelo.setText("");
            etPrecio.setText("");
        } else {
            Toast.makeText(this, "No existe vehiculo con dicha patente", Toast.LENGTH_SHORT).show();
            bd.close();
        }
    }

    public void modificar(View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        String patente = etPatente.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("marca", etMarca.getText().toString());
        registro.put("modelo", etModelo.getText().toString());
        registro.put("precio", etPrecio.getText().toString());
        int cant = bd.update("vehiculos", registro,"patente = '"+patente+"'", null);
        if(cant == 1){
            Toast.makeText(this, "Se modifican datos del vehículo", Toast.LENGTH_SHORT).show();
            etPatente.setText("");
            etMarca.setText("");
            etModelo.setText("");
            etPrecio.setText("");
        } else {
            Toast.makeText(this, "No existe un vehiculo con dicha patente", Toast.LENGTH_SHORT).show();
            bd.close();
        }
    }
}

