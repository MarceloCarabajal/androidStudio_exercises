package com.marce.proyecto030;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoMensaje extends DialogFragment {
    private String mensaje;
    public DialogoMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(mensaje);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                respuesta.confirmar(DialogoMensaje.this);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                respuesta.cancelar(DialogoMensaje.this);
            }
        });
        return builder.create();

    }

    public interface Respuestas {
        public void confirmar(DialogFragment dialog);
        public void cancelar(DialogFragment dialog);
    }

    private Respuestas respuesta;
    public void procesarRespuesta(Respuestas r){
        respuesta = r;
    }
}
