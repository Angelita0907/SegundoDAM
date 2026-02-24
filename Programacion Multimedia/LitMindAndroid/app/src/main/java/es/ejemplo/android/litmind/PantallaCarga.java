package es.ejemplo.android.litmind;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaCarga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(PantallaCarga.this, LoginActivity.class));
            finish();
        }, 2000);
    }
}