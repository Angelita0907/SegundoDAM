package es.ejemplo.android.litmind;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnCreateUser = findViewById(R.id.btnCreateUser);
        Button btnViewUsers  = findViewById(R.id.btnViewUsers);
        Button btnViewStats  = findViewById(R.id.btnViewStats);

        btnCreateUser.setOnClickListener(v -> showCreateUserDialog());

        btnViewUsers.setOnClickListener(v -> {
            Toast.makeText(this, "Cargando lista de usuarios...", Toast.LENGTH_SHORT).show();
        });

        btnViewStats.setOnClickListener(v -> {
            Toast.makeText(this, "Cargando estadisticas del sistema...", Toast.LENGTH_SHORT).show();
        });
    }

    private void showCreateUserDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Crear nuevo usuario");

        android.view.View dialogView = getLayoutInflater().inflate(R.layout.dialog_create_user, null);
        builder.setView(dialogView);

        builder.setPositiveButton("Crear", (dialog, which) -> {
            EditText etName  = dialogView.findViewById(R.id.etDialogName);
            EditText etEmail = dialogView.findViewById(R.id.etDialogEmail);
            String name  = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Usuario '" + name + "' creado correctamente!", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("Cancelar", null);
        builder.show();
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
            Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
