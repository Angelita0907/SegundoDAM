package com.example.appejemplo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pruebalinearlayout);

        Bundle b = getIntent().getExtras();

        Log.i("Datos: ", b.getString("Surname"));
    }

}
