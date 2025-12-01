package com.example.examentema3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class Cliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cliente);

        // para enviar si tenemos los datos nuestro y solo queremos pedir una cita
        // intenté alguna manera pero el programa me pedía poner eso para que no me dé error el botón
        @SuppressLint("WrongViewCast") RadioButton botonCita = findViewById(R.id.cita);

        botonCita.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick( View v){
                Intent IrAPedirCita = new Intent(Cliente.this, Cita.class);
                startActivity(IrAPedirCita);
            }
        });

    }
}
