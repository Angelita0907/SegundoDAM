package es.ejemplo.android.litmind;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegister = findViewById(R.id.btnLogin);

        btnRegister.setOnClickListener(v -> {
            EditText etEmail    = findViewById(R.id.etEmail);
            EditText etUser     = findViewById(R.id.etUser);
            EditText etPassword = findViewById(R.id.etPassword);
            EditText etConfirm  = findViewById(R.id.etConfirmar);

            String email   = etEmail.getText().toString().trim();
            String user    = etUser.getText().toString().trim();
            String pass    = etPassword.getText().toString().trim();
            String confirm = etConfirm.getText().toString().trim();

            if (email.isEmpty() || user.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!pass.equals(confirm)) {
                Toast.makeText(this, "Las contrasenas no coinciden", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Cuenta creada correctamente! Bienvenido, " + user, Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
