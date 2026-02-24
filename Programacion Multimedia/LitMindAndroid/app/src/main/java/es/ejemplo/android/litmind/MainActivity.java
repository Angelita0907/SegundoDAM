package es.ejemplo.android.litmind;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.navigation_profile) {
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            } else if (id == R.id.navigation_home) {
                Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.navigation_library) {
                Toast.makeText(this, "Biblioteca", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.navigation_community) {
                Toast.makeText(this, "Comunidad", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.navigation_stats) {
                Toast.makeText(this, "Progreso", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        Button btnStartReading = findViewById(R.id.btnStartReading);
        if (btnStartReading != null) {
            btnStartReading.setOnClickListener(v ->
                Toast.makeText(this, "Abriendo El Principito...", Toast.LENGTH_SHORT).show());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_logout) {
            Toast.makeText(this, "Sesion cerrada", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
            finishAffinity();
            return true;
        } else if (id == R.id.menu_settings) {
            Toast.makeText(this, "Ajustes", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_notifications) {
            Toast.makeText(this, "Sin notificaciones nuevas", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
