package es.ejemplo.android.litmind;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.ejemplo.android.litmind.model.DataManager;
import es.ejemplo.android.litmind.model.Usuario;

/**
 * Pantalla de inicio de sesión.
 * Valida las credenciales contra el DataManager (datos locales por ahora).
 * Si el usuario es ADMIN redirige al panel de administración.
 * Si es cualquier otro rol, va a MainActivity.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializarVistas();
        configurarListeners();
    }

    /** Enlaza las variables con los elementos del layout */
    private void inicializarVistas() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
    }

    /** Asigna los listeners de click a los botones */
    private void configurarListeners() {
        btnLogin.setOnClickListener(v -> intentarLogin());

        // Navegar a la pantalla de registro
        tvRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }

    /**
     * Recoge los campos, los valida y llama al DataManager para autenticar.
     * Según el rol, redirige a una pantalla u otra.
     */
    private void intentarLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();

        // Validar que los campos no están vacíos
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Introduce tu correo electrónico");
            etEmail.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Introduce tu contraseña");
            etPassword.requestFocus();
            return;
        }

        // Intentar login contra los datos locales
        Usuario usuario = DataManager.getInstance().login(email, password);

        if (usuario == null) {
            // Credenciales incorrectas
            Toast.makeText(this, "Email o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            etPassword.setText("");
            return;
        }

        // Login correcto -> redirigir según el rol
        if (usuario.esAdmin()) {
            startActivity(new Intent(this, AdminActivity.class));
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
        finish(); // quitar Login del back stack
    }
}