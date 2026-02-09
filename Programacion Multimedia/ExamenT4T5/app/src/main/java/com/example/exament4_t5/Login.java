package com.example.exament4_t5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    // del mismo tipo que son en el xml me creo las variables que si no me daba error
    EditText usuario;
    EditText contrasena;
    Button acceso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.Usuario);
        contrasena = findViewById(R.id.Password);
        acceso = findViewById(R.id.BotonAcceso);

        // el boton llama a la funcion
        acceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });
    }

    private void iniciarSesion(){
        String usuario = this.usuario.getText().toString();
        String contrasena = this.contrasena.getText().toString();

        // si coincide te lleva a docente
        if (usuario.equals("docente") && contrasena.equals("docente")) {
            Intent intent = new Intent(this, Docente.class);
            startActivity(intent);
            Toast.makeText(this, "Iniciando Sesión como Docente", Toast.LENGTH_SHORT).show();

        }
        // si coincide te lleva a estudianrte
        else if (usuario.equals("estudiante") && contrasena.equals("estudiante")) {
            Intent intent = new Intent(this, Estudiante.class);
            startActivity(intent);
            Toast.makeText(this, "Iniciando Sesión como Estudiante", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "Lo has escrito mal, Intentalo otra vez anda!", Toast.LENGTH_SHORT).show();
        }
    }

}