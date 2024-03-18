package com.hasar.proyecto067;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Signo> lista = new ArrayList<>();
    private int indice;
    private TextView tvTitulo, tvDescripcion;
    private ImageView iv;
    private SwipeRefreshLayout swipe1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        iv=findViewById(R.id.ivSigno);
        swipe1 = findViewById(R.id.swipe1);
        lista.add(new Signo(R.drawable.acuario, "Acuario (20 de enero - 18 de febrero)", "Acuario es original, independiente y humanitario. Son visionarios que buscan cambios positivos en el mundo y valoran la libertad y la igualdad."));
        lista.add(new Signo(R.drawable.aries, "Aries (21 de marzo - 19 de abril)", "Aries es valiente, enérgico y aventurero. Son líderes naturales que disfrutan de desafíos y no temen tomar riesgos."));
        lista.add(new Signo(R.drawable.cancer, "Cáncer (21 de junio - 22 de julio)", "Cáncer es compasivo, intuitivo y protector. Son leales a su familia y amigos, y a menudo actúan desde el corazón."));
        lista.add(new Signo(R.drawable.capricornio, "Capricornio (22 de diciembre - 19 de enero)", "Capricornio es ambicioso, responsable y disciplinado. Son trabajadores dedicados que tienen una gran determinación para alcanzar sus metas."));
        lista.add(new Signo(R.drawable.escorpio, "Escorpio (23 de octubre - 21 de noviembre)", "Escorpio es apasionado, decidido y enigmático. Son personas profundas y poderosas que están siempre en busca de la verdad y la autenticidad."));
        lista.add(new Signo(R.drawable.geminis, "Géminis (21 de mayo - 20 de junio)", "Géminis es ingenioso, adaptable y sociable. Son comunicadores naturales que disfrutan explorando diferentes perspectivas y manteniendo la vida emocionante."));
        lista.add(new Signo(R.drawable.leo, "Leo (23 de julio - 22 de agosto)", "Leo es carismático, seguro y creativo. Son líderes natos que disfrutan de la atención y buscan el éxito en todo lo que hacen."));
        lista.add(new Signo(R.drawable.libra, "Libra (23 de septiembre - 22 de octubre)", "Libra es equilibrado, encantador y diplomático. Son amantes de la paz que valoran la armonía y las relaciones equitativas."));
        lista.add(new Signo(R.drawable.piscis, "Piscis (19 de febrero - 20 de marzo)", "Piscis es compasivo, sensible e imaginativo. Son soñadores románticos que se conectan profundamente con sus emociones y las de los demás."));
        lista.add(new Signo(R.drawable.sagitario, "Sagitario (22 de noviembre - 21 de diciembre)", "Sagitario es aventurero, optimista y filosófico. Son exploradores del mundo que buscan constantemente nuevos horizontes y experiencias."));
        lista.add(new Signo(R.drawable.tauro, "Tauro (20 de abril - 20 de mayo)", "Tauro es paciente, confiable y determinado. Son conocidos por su amor por el lujo y la estabilidad, así como por su terquedad ocasional."));
        lista.add(new Signo(R.drawable.virgo, "Virgo (23 de agosto - 22 de septiembre)", "Virgo es práctico, analítico y meticuloso. Son perfeccionistas que se esfuerzan por la excelencia en todas las áreas de su vida."));
        actualizar();
        swipe1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(indice<11){
                    indice++;
                }else {
                    indice = 0;
                }
                swipe1.setRefreshing(false);
                actualizar();
            }
        });
    }
    private void actualizar(){
        tvTitulo.setText(lista.get(indice).getTitulo());
        tvDescripcion.setText(lista.get(indice).getDescripcion());
        iv.setImageResource(lista.get(indice).getImagen());
    }
}