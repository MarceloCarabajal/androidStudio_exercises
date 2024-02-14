package com.hasar.proyecto051;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //almaceno la referencia de los 16 imageViews
    private ImageView[][] mat = new ImageView[4][4];
    //indico que imagen hay debajo de la carta
    private int[][] tablero =
            {{1, 1, 2, 2},
                    {3, 3, 4, 4},
                    {5, 5, 6, 6},
                    {7, 7, 8, 8}};
    //indica si la carta se debe mostrar o no
    //empiezan todas tapadas. Es decir, con false por defecto
    private boolean[][]destapado = new boolean[4][4];
    //indica si esta activa la posibilidad de presionar una carta
    //se desactiva luego de destapar dos cartas distintas y se lo vuelve
    //a activar luego de 3 seg
    private boolean activo = true;
    //contador que indica si es la primera vez o la segunda vez que se presiona la carta
    private int nropresion;
    //guardo la coordenada de la primera carta presionada
    private int primerox = -1, primeroy= -1;
    private Handler manejador = new Handler(Looper.myLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mat[0][0] = findViewById(R.id.imageView);
        mat[0][1] = findViewById(R.id.imageView2);
        mat[0][2] = findViewById(R.id.imageView3);
        mat[0][3] = findViewById(R.id.imageView4);
        mat[1][0] = findViewById(R.id.imageView5);
        mat[1][1] = findViewById(R.id.imageView6);
        mat[1][2] = findViewById(R.id.imageView7);
        mat[1][3] = findViewById(R.id.imageView8);
        mat[2][0] = findViewById(R.id.imageView9);
        mat[2][1] = findViewById(R.id.imageView10);
        mat[2][2] = findViewById(R.id.imageView11);
        mat[2][3] = findViewById(R.id.imageView12);
        mat[3][0] = findViewById(R.id.imageView13);
        mat[3][1] = findViewById(R.id.imageView14);
        mat[3][2] = findViewById(R.id.imageView15);
        mat[3][3] = findViewById(R.id.imageView16);
        mezclarTablero();
    }

    private void mezclarTablero() {
        for (int i = 0; i <= 1000; i++) {
            int x1 = (int) (Math.random() * 4);
            int y1 = (int) (Math.random() * 4);
            int x2 = (int) (Math.random() * 4);
            int y2 = (int) (Math.random() * 4);
            int aux = tablero[x1][y1];
            tablero[x1][y1] = tablero[x2][y2];
            tablero[x2][y2] = aux;
        }
    }

    public void presion(View v) {
        if (activo) {
            nropresion++;
            if (nropresion == 2)
                if (v == mat[primerox][primeroy]) {
                    // es verdadero si presionamos dos veces la misma carta
                    nropresion--;
                    return;
                }
            verificarImagenPresionada(v);
            if (nropresion == 2)
                congelar3Segundos();
        }
    }

    private void congelar3Segundos(){
            nropresion = 0;
            activo = false;
            primerox = -1;
            primeroy = -1;
            manejador.postDelayed(new Runnable() {
                @Override
                public void run() {
                    activo = true;
                    for(int f = 0; f < 4; f++)
                        for(int c = 0; c < 4; c++)
                            if(destapado[f][c])
                                destapar(mat[f][c], tablero[f][c]);
                            else
                                mat[f][c].setImageResource(R.drawable.pregunta);
                }
            },3000);
        }

    private void verificarImagenPresionada(View v) {
        for (int i = 0; i < 4; i++)
            for (int c = 0; c < 4; c++)
                if (mat[i][c] == v) { //es verdadero cuando la carta que presionamos coincide con una de la matriz
                    destapar(mat[i][c], tablero[i][c]); // Mostramos la carta
                    if (nropresion == 1) {
                        primerox = i;
                        primeroy = c;
                        return;
                    } else {
                        if (tablero[i][c] == tablero[primerox][primeroy]) {
                            destapado[i][c] = true; // Imagen que acaba de presionar
                            destapado[primerox][primeroy] = true; // Imagen anterior
                            verificarSiGana();
                            nropresion = 0;
                            return;
                        }
                    }
                }
    }

        private void destapar(ImageView iv, int ima){
            switch (ima){
                case 1:
                    iv.setImageResource(R.drawable.anana);
                    break;
                case 2:
                    iv.setImageResource(R.drawable.banana);
                    break;
                case 3:
                    iv.setImageResource(R.drawable.frutilla);
                    break;
                case 4:
                    iv.setImageResource(R.drawable.manzana);
                    break;
                case 5:
                    iv.setImageResource(R.drawable.melon);
                    break;
                case 6:
                    iv.setImageResource(R.drawable.naranja);
                    break;
                case 7:
                    iv.setImageResource(R.drawable.palta);
                    break;
                case 8:
                    iv.setImageResource(R.drawable.sandia);
                    break;
            }
        }
        
        private void verificarSiGana() {
            int destapadas = 0;
            for (int f=0; f<4; f++)
                for(int c=0; c<4; c++)
                    if(destapado[f][c])
                        destapadas++;
            if(destapadas == 16)
                Toast.makeText(this, "Gano...", Toast.LENGTH_SHORT).show();
        }
}