package com.example.appejemplo;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pruebalinearlayout);

        TextView miTexto= (TextView) findViewById(R.id.texto1);
        miTexto.setText("Nuevo texto para mostrar");


    }

}
