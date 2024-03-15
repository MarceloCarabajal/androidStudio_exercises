package com.hasar.proyecto065;

public class Pregunta {
    private String pregunta;
    private String respuesta1, respuesta2, respuesta3;
    private int respuesta;

    public Pregunta(String pregunta, String respuesta1, String respuesta2, String respuesta3, int respuesta) {
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public int getRespuesta() {
        return respuesta;
    }
}
