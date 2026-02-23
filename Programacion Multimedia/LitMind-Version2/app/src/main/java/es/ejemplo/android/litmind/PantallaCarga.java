package es.ejemplo.android.litmind;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import es.ejemplo.android.litmind.model.DataManager;

/**
 * Pantalla de carga inicial (Splash).
 * Se muestra 2 segundos y luego redirige:
 *  - A MainActivity si ya hay sesión activa.
 *  - A LoginActivity si no hay sesión.
 */
public class PantallaCarga extends AppCompatActivity {

    private static final int SPLASH_DURACION_MS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);

        new Handler(Looper.getMainLooper()).postDelayed(this::navegarSiguientePantalla, SPLASH_DURACION_MS);
    }

    /**
     * Decide a qué pantalla ir al terminar el splash.
     * Si hay sesión activa va a MainActivity, si no al Login.
     */
    private void navegarSiguientePantalla() {
        Intent intent;
        if (DataManager.getInstance().getUsuarioActual() != null) {
            intent = new Intent(this, MainActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
        finish(); // eliminar del back stack para no volver aquí con el botón atrás
    }
}