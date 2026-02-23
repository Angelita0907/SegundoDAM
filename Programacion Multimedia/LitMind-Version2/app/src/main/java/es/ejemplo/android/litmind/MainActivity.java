package es.ejemplo.android.litmind;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import es.ejemplo.android.litmind.model.DataManager;
import es.ejemplo.android.litmind.model.Usuario;

/**
 * Actividad principal con navegación inferior (Bottom Navigation).
 * Gestiona la navegación entre Inicio, Biblioteca, Comunidad, Progreso y Perfil.
 * Muestra el nombre del usuario logueado en la cabecera.
 */
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private TextView tvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Si no hay sesión activa, volver al login
        if (DataManager.getInstance().getUsuarioActual() == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        inicializarVistas();
        mostrarNombreUsuario();
        configurarBottomNavigation();
    }

    /** Enlaza las variables con los elementos del layout */
    private void inicializarVistas() {
        bottomNav  = findViewById(R.id.bottomNav);
        tvUserName = findViewById(R.id.tvUserName);
    }

    /**
     * Muestra el nombre del usuario que ha iniciado sesión en la cabecera.
     */
    private void mostrarNombreUsuario() {
        Usuario usuario = DataManager.getInstance().getUsuarioActual();
        if (tvUserName != null && usuario != null) {
            tvUserName.setText(usuario.getNombre().split(" ")[0]); // solo el primer nombre
        }
    }

    /**
     * Configura la barra de navegación inferior.
     * Cada item abre la actividad correspondiente.
     */
    private void configurarBottomNavigation() {
        if (bottomNav == null) return;

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                // Ya estamos en home, no hacer nada
                return true;
            } else if (id == R.id.nav_library) {
                startActivity(new Intent(this, LibraryActivity.class));
                return true;
            } else if (id == R.id.nav_community) {
                startActivity(new Intent(this, CommunityActivity.class));
                return true;
            } else if (id == R.id.nav_stats) {
                startActivity(new Intent(this, StatsActivity.class));
                return true;
            } else if (id == R.id.nav_profile) {
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            }
            return false;
        });
    }
}