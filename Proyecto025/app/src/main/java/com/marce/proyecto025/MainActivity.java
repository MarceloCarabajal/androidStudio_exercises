package com.marce.proyecto025;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarPopup(View v){
        ImageView iv1 = findViewById(R.id.iv1);
        PopupMenu pm = new PopupMenu(this, iv1);
        pm.getMenuInflater().inflate(R.menu.menupopup, pm.getMenu());
        pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.ayuda1){
                    Toast.makeText(MainActivity.this, "Ayuda 1", Toast.LENGTH_SHORT).show();
                    return true;
                } else if(item.getItemId() == R.id.ayuda2){
                    Toast.makeText(MainActivity.this, "Ayuda 2", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    return false;
                }
            }
        });
        pm.show();
    }
}