package es.ejemplo.android.litmind;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.ejemplo.android.litmind.model.DataManager;
import es.ejemplo.android.litmind.model.Usuario;

/**
 * Pantalla de registro de nuevo usuario.
 * Valida los campos, comprueba que el email no esté en uso,
 * crea el usuario y redirige a la selección de rol.
 */
public class RegisterActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etUser;
    private EditText etPhone;
    private EditText etPassword;
    private EditText etConfirmar;
    private Button btnRegistrar;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inicializarVistas();
        configurarListeners();
    }

    /** Enlaza las variables con los elementos del layout */
    private void inicializarVistas() {
        etEmail = findViewById(R.id.etEmail);
        etUser = findViewById(R.id.etUser);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        etConfirmar = findViewById(R.id.etConfirmar);
        btnRegistrar = findViewById(R.id.btnLogin); // reutiliza el ID del botón del layout
        tvLogin = findViewById(R.id.tvLoginLink);
    }

    /** Asigna los listeners de click */
    private void configurarListeners() {
        btnRegistrar.setOnClickListener(v -> intentarRegistro());

        if (tvLogin != null) {
            tvLogin.setOnClickListener(v -> {
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            });
        }
    }

    /**
     * Recoge y valida todos los campos del formulario.
     * Si todo es correcto, crea el usuario y va a la selección de rol.
     */
    private void intentarRegistro() {
        String email = etEmail.getText().toString().trim();
        String nombre = etUser.getText().toString().trim();
        String password = etPassword.getText().toString();
        String confirmar = etConfirmar.getText().toString();

        // Validaciones básicas
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Introduce tu correo"); etEmail.requestFocus(); return;
        }
        if (TextUtils.isEmpty(nombre)) {
            etUser.setError("Introduce tu nombre"); etUser.requestFocus(); return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Introduce una contraseña"); etPassword.requestFocus(); return;
        }
        if (password.length() < 4) {
            etPassword.setError("Mínimo 4 caracteres"); etPassword.requestFocus(); return;
        }
        if (!password.equals(confirmar)) {
            etConfirmar.setError("Las contraseñas no coinciden"); etConfirmar.requestFocus(); return;
        }

        // Comprobar que el email no está ya registrado
        if (DataManager.getInstance().emailYaRegistrado(email)) {
            etEmail.setError("Este correo ya está registrado");
            etEmail.requestFocus();
            return;
        }

        // Crear el usuario con rol ESTUDIANTE por defecto (se cambia en RoleSelectionActivity)
        Usuario nuevo = new Usuario(nombre, email, password, Usuario.Rol.ESTUDIANTE, Usuario.Nivel.PRINCIPIANTE);
        DataManager.getInstance().crearUsuario(nuevo);
        DataManager.getInstance().setUsuarioActual(nuevo);

        Toast.makeText(this, "¡Cuenta creada! Elige tu perfil", Toast.LENGTH_SHORT).show();

        // Ir a la selección de rol
        startActivity(new Intent(this, RoleSelectionActivity.class));
        finish();
    }
}