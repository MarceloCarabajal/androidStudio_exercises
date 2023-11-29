package com.marce.proyecto020;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE vehiculos (\n" +
                " patente TEXT PRIMARY KEY,\n" +
                " marca TEXT,\n" +
                " modelo INTEGER,\n" +
                " precio REAL\t\n" +
                ")");

        // Insertar algunos registros de ejemplo para probar
        ContentValues registro = new ContentValues();
        registro.put("patente", "ABC123");
        registro.put("marca", "Toyota");
        registro.put("modelo", 2022);
        registro.put("precio", 25000.0);
        db.insert("vehiculos", null, registro);

        registro.clear();
        registro.put("patente", "XYZ789");
        registro.put("marca", "Honda");
        registro.put("modelo", 2021);
        registro.put("precio", 22000.0);
        db.insert("vehiculos", null, registro);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
