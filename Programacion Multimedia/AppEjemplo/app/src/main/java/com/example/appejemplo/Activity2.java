package com.example.appejemplo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pruebalinearlayout);

       // Bundle b = getIntent().getExtras();

        //Log.i("Datos: ", b.getString("Surname"));

        TextView miTexto= (TextView) findViewById(R.id.texto1);
        miTexto.setText("Nuevo texto para mostrar");

        Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.animaciones);
        miAnimacion.setRepeatMode(Animation.RESTART);
        miAnimacion.setRepeatCount(20);
        miTexto.setAnimation(miAnimacion);
    }

}
