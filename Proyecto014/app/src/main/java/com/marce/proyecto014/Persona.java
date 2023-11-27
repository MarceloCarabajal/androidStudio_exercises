package com.marce.proyecto014;

public class Persona {
    private String nombre;
    private String telefono;
    public Persona(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre(){
        return nombre;
    }
    public String getTelefono(){
        return telefono;
    }
}
