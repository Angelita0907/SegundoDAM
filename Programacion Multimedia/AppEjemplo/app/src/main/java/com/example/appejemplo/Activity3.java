package com.example.appejemplo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity{

    TextView miTexto1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tema3actividades);

        miTexto1 = findViewById(R.id.texto1);
        miTexto1.setText("Teclados");
/*

        Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.animaciones);
        miAnimacion.setRepeatMode(Animation.RESTART);
        miAnimacion.setRepeatCount(20);
        miTexto1.setAnimation(miAnimacion);


        Button miBoton1 = (Button) findViewById(R.id.miBoton1);
        miBoton1.setOnClickListener(this);
        Button miBoton2 = (Button) findViewById(R.id.miBoton2);
        miBoton2.setOnClickListener(this);


        EditText teclado = (EditText) findViewById(R.id.miTexto);
        String cadena = teclado.getText().toString();
*/
        RadioButton boton1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton boton2 = (RadioButton) findViewById(R.id.radio2);
        RadioButton boton3 = (RadioButton) findViewById(R.id.radio3);
        RadioButton boton4 = (RadioButton) findViewById(R.id.radio4);

        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                miTexto1.setText("Botones");
            }
        });
        boton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                miTexto1.setText("Botones2");
            }
        });
        boton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                miTexto1.setText("Botones3");
            }
        });
        boton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                miTexto1.setText("Botones4");
            }
        });

    }
/*
    public void cambiaColor(View view){

        int id = view.getId();

        if (id == R.id.miBoton1) {
            // Botón 1 cambia el texto a ROJO
            miTexto1.setTextColor(Color.RED);

        } else if (id == R.id.miBoton2) {
            // Botón 2 cambia el texto a VERDE
            miTexto1.setTextColor(Color.GREEN);

        }

    }
*/

    public void cambiaTexto(View view){

    }

}
