package es.ejemplo.android.litmind;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import es.ejemplo.android.litmind.model.DataManager;
import es.ejemplo.android.litmind.model.Usuario;

/**
 * Pantalla de selección de perfil/rol.
 * Aparece tras el registro para que el usuario elija su rol.
 * Actualiza el rol en el DataManager y va a MainActivity.
 */
public class RoleSelectionActivity extends AppCompatActivity {

    private CardView cardStudent;
    private CardView cardTeacher;
    private CardView cardAdult;
    private CardView cardParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_selection);

        inicializarVistas();
        configurarListeners();
    }

    /** Enlaza los CardView con sus IDs del layout */
    private void inicializarVistas() {
        cardStudent = findViewById(R.id.cardStudent);
        cardTeacher = findViewById(R.id.cardTeacher);
        cardAdult   = findViewById(R.id.cardAdult);
        cardParent  = findViewById(R.id.cardParent);
    }

    /** Cada card selecciona un rol distinto y navega a MainActivity */
    private void configurarListeners() {
        cardStudent.setOnClickListener(v -> seleccionarRol(Usuario.Rol.ESTUDIANTE));
        cardTeacher.setOnClickListener(v -> seleccionarRol(Usuario.Rol.DOCENTE));
        cardAdult.setOnClickListener(v   -> seleccionarRol(Usuario.Rol.ESTUDIANTE)); // adulto = estudiante de momento
        cardParent.setOnClickListener(v  -> seleccionarRol(Usuario.Rol.PADRE));
    }

    /**
     * Actualiza el rol del usuario actual y navega a la pantalla principal.
     * @param rol el rol seleccionado por el usuario
     */
    private void seleccionarRol(Usuario.Rol rol) {
        Usuario usuario = DataManager.getInstance().getUsuarioActual();

        if (usuario == null) {
            // Caso improbable, pero por seguridad
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        // Actualizar el rol del usuario
        usuario.setRol(rol);
        DataManager.getInstance().actualizarUsuario(usuario);

        Toast.makeText(this, "¡Bienvenido a LitMind!", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}