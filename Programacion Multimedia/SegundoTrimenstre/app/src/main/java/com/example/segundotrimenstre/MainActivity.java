package com.example.segundotrimenstre;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // los menú se ponen siempre al principio
    // para los menú se hace con inflatters basicamente
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    // ahora lo mismo pero que podamos usar ese menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("menus",item.toString());
        return super.onOptionsItemSelected(item);
    }

    // para el segundo menú pulsando

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuelemento, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Log.i("menus",item.toString());
        return super.onContextItemSelected(item);
    }


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

        //spinner
        /*
        Spinner listaSpinner = (Spinner) findViewById(R.id.miSpinner);
        final String[] datosSpinner = new String[]{"Cien años de soledad",
                "1984",
                "Don Quijote",
                "El principito",
                "Crónica de una muerte",
                "Fahrenheit 451",
                "El amor en tiempos de cólera",
                "La sombra del viento"};
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datosSpinner);
        listaSpinner.setAdapter(adaptadorSpinner);

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


        // grid view
        /*
        GridView listado = (GridView) findViewById(R.id.miGrid);
        final String[] datos = new String[]{"Perfil",
                "Notificaciones",
                "Seguridad",
                "Privacidad",
                "Idioma",
                "Ayuda",
                "Cerrar Sesión"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Pulsado", "Elemento pulsado: "+position);
                Log.i("Pulsado", "Elemento pulsado: "+(String) parent.getItemAtPosition(position));
            }
        });
*/

        // list View
        /*
        ListView listado = (ListView) findViewById(R.id.miLista);
        final String[] datos = new String[]{"Comprar café",
                "Llamar al médico",
                "Estudiar Java",
                "Ir al gimnasio",
                "Configurar notificaciones",
                "Actualizar Android Studio"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Pulsado", "Elemento pulsado: "+position);
                Log.i("Pulsado", "Elemento pulsado: "+(String) parent.getItemAtPosition(position));
            }
        });
        */

        // barra de progreso
        /*
        SeekBar miControl = (SeekBar) findViewById(R.id.miSeekBar);
        miControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Bar","Valor progreso:"+ seekBar.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("Bar","Valor final de:"+ seekBar.getProgress());
            }
        });
*/

        // estrellitas
        /*
        RatingBar controlRating =  (RatingBar) findViewById(R.id.myRating);
        controlRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.i("Rating","Valor de rating: "+rating);
            }
        });
         */

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
                new Datos("Soporte Técnico", "Tu pedido ha sido enviado con éxito"),
                // El primer String es el remitente, el segundo el mensaje
                new Datos("Seguridad Google", "Nuevo inicio de sesión detectado"),
                new Datos("Amazon", "Oferta relámpago: 50% en tecnología"),
                new Datos("WhatsApp", "Tienes 5 mensajes nuevos de " + "Mamá"),
                new Datos("Banco", "Tu estado de cuenta está disponible")
        };
        ListView listado = (ListView) findViewById(R.id.miLista);
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);


        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Pulsado", "Elemento pulsado: "+position);
                Log.i("Pulsado", "Elemento pulsado: "+(Datos) parent.getItemAtPosition(position));
            }
        });


        // para el menu ponemos el elemento que hace de menu en el oncreate
        TextView elemento = (TextView) findViewById(R.id.texto);
        registerForContextMenu(elemento);

    }
}