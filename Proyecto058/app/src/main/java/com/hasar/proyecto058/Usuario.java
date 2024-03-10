package com.hasar.proyecto058;

public class Usuario {
    private String nombre;
    private String mail;
    private String foto;

    public Usuario() {
    }

    public Usuario(String nombre, String mail, String foto) {
        this.nombre = nombre;
        this.mail = mail;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }

    public String getFoto() {
        return foto;
    }
}
