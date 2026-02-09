package com.example.exament4_t5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Estudiante extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_estudiante, menu);
        return true;
    }

    // con esto podremos usar el menú estudiante
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("menu",item.toString());

        // para poder decirle que si se pulsa cerrar sesión del menú salte un diálogo
        if (item.getItemId() == R.id.cerrar) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Seguro que quieres salir de esta maravillosa app?")
                    .setIcon(R.mipmap.ic_launcher)

                    .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.i("Elegido","Salir");
                        }
                    })
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.i("Elegido","No salir");
                        }
                    });
            // Creamos y mostramos el diálogo
            AlertDialog dialog = builder.create();
            dialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_estudiante);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GridView listaModulos = findViewById(R.id.Modulos);

        String[] modulos = {
                "BBDD-1ºDAM", "LDM-1ºDAM", "PROG-1ºDAM",
                "EED-1ºDAM", "PMDM-2ºDAM", "SIST-1ºDAM" // Añade el sexto según tu lista
        };

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, modulos);

        listaModulos.setAdapter(adaptador);

    }
}