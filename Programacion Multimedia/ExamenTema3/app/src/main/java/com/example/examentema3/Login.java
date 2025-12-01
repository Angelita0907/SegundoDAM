package com.example.examentema3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // voy a poner para según el boton que le demos en
        // cliente o peluqieria nos lleve a una actitivty u otra

        RadioButton botonPeluqueria = findViewById(R.id.peluqeria);
        RadioButton botonCliente = findViewById(R.id.cliente);

        // ahora según lo que pulsemos no lleva a uno u otro

        botonPeluqueria.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick( View v){
                Intent IrALapeluqueria = new Intent(Login.this, Peluqueria.class);
                startActivity(IrALapeluqueria);
            }
        });

        botonCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Areacliente = new Intent(Login.this, Cliente.class);
                startActivity(Areacliente);
            }
        });


    }

}
