package es.ejemplo.android.litmind;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import es.ejemplo.android.litmind.adapter.UsuarioAdapter;
import es.ejemplo.android.litmind.model.DataManager;
import es.ejemplo.android.litmind.model.Usuario;

/**
 * Panel de administración de usuarios.
 * Solo accesible para usuarios con rol ADMIN.
 * Muestra la lista de usuarios con opciones para editar y eliminar.
 * El FAB (+) abre el formulario para crear un usuario nuevo.
 */
public class AdminActivity extends AppCompatActivity implements UsuarioAdapter.OnUsuarioClickListener {

    private RecyclerView recyclerUsuarios;
    private UsuarioAdapter adapter;
    private TextView tvTotalUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // Verificar que quien accede es admin
        Usuario actual = DataManager.getInstance().getUsuarioActual();
        if (actual == null || !actual.esAdmin()) {
            Toast.makeText(this, "Acceso restringido", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        inicializarVistas();
        configurarRecycler();
        configurarFab();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Recargar la lista al volver de editar/crear un usuario
        actualizarLista();
    }

    /** Enlaza las variables con los elementos del layout */
    private void inicializarVistas() {
        recyclerUsuarios = findViewById(R.id.recyclerUsuarios);
        tvTotalUsuarios = findViewById(R.id.tvTotalUsuarios);
    }

    /** Configura el RecyclerView con su adapter y layout manager */
    private void configurarRecycler() {
        recyclerUsuarios.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UsuarioAdapter(this);
        recyclerUsuarios.setAdapter(adapter);
        actualizarLista();
    }

    /** Configura el botón flotante para crear usuarios nuevos */
    private void configurarFab() {
        FloatingActionButton fab = findViewById(R.id.fabNuevoUsuario);
        if (fab != null) {
            fab.setOnClickListener(v -> {
                Intent intent = new Intent(this, UserDetailActivity.class);
                intent.putExtra(UserDetailActivity.EXTRA_MODO, UserDetailActivity.MODO_CREAR);
                startActivity(intent);
            });
        }
    }

    /**
     * Recarga la lista de usuarios del DataManager y actualiza la UI.
     */
    private void actualizarLista() {
        List<Usuario> usuarios = DataManager.getInstance().getUsuariosNoAdmin();
        adapter.setUsuarios(usuarios);

        if (tvTotalUsuarios != null) {
            tvTotalUsuarios.setText(usuarios.size() + " usuarios registrados");
        }
    }

    // ---- Callbacks del adaptador ----

    /**
     * Al pulsar "Editar" en una tarjeta de usuario, abre UserDetailActivity en modo edición.
     */
    @Override
    public void onEditarClick(Usuario usuario) {
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra(UserDetailActivity.EXTRA_MODO, UserDetailActivity.MODO_EDITAR);
        intent.putExtra(UserDetailActivity.EXTRA_USUARIO_ID, usuario.getId());
        startActivity(intent);
    }

    /**
     * Al pulsar "Eliminar", muestra un diálogo de confirmación antes de borrar.
     */
    @Override
    public void onEliminarClick(Usuario usuario) {
        new AlertDialog.Builder(this)
                .setTitle("Eliminar usuario")
                .setMessage("¿Seguro que quieres eliminar a " + usuario.getNombre() + "?")
                .setPositiveButton("Eliminar", (dialog, which) -> {
                    DataManager.getInstance().eliminarUsuario(usuario.getId());
                    actualizarLista();
                    Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }

    // ---- Menú de opciones ----

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_logout) {
            DataManager.getInstance().logout();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
