package com.example.segundotrimenstre;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
/*
        Spinner listaSpinner = (Spinner) findViewById(R.id.miSpinner);
        final String[] datosSpinner = new String[]{"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5"};
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datosSpinner);
        listaSpinner.setAdapter(adaptadorSpinner);

        // Para obtener información del elemento pulsado:
        listaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Pulsado", "Elemento pulsado: "+position);
                Log.i("Pulsado", "Elemento pulsado: "+(String) parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
*/

        //Adaptadores
        Datos[] datos = new Datos[]{
                new Datos("Linea superior 1", "Linea inferior 1"),
                new Datos("Linea superior 2", "Linea inferior 2"),
                new Datos("Linea superior 3", "Linea inferior 3"),
                new Datos("Linea superior 4", "Linea inferior 4"),
                new Datos("Linea superior 5", "Linea inferior 5")
        };
        ListView listado = (ListView) findViewById(R.id.miLista);
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);




    }
}