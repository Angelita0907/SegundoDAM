package es.ejemplo.android.litmind;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.ejemplo.android.litmind.model.DataManager;
import es.ejemplo.android.litmind.model.Usuario;

/**
 * Formulario para crear o editar un usuario (solo admin).
 * Recibe por Intent el modo (CREAR o EDITAR) y, en modo edición, el ID del usuario.
 */
public class UserDetailActivity extends AppCompatActivity {

    // Constantes para los extras del Intent
    public static final String EXTRA_MODO       = "modo";
    public static final String EXTRA_USUARIO_ID = "usuario_id";
    public static final int    MODO_CREAR        = 0;
    public static final int    MODO_EDITAR       = 1;

    private EditText etNombre;
    private EditText etEmail;
    private EditText etPassword;
    private Spinner  spinnerRol;
    private Spinner  spinnerNivel;
    private Button   btnGuardar;

    private int modo;
    private String usuarioId;
    private Usuario usuarioAEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        modo      = getIntent().getIntExtra(EXTRA_MODO, MODO_CREAR);
        usuarioId = getIntent().getStringExtra(EXTRA_USUARIO_ID);

        inicializarVistas();
        configurarSpinners();

        if (modo == MODO_EDITAR) {
            cargarDatosUsuario();
        }

        btnGuardar.setOnClickListener(v -> guardarUsuario());
    }

    /** Enlaza las variables con los elementos del layout */
    private void inicializarVistas() {
        etNombre      = findViewById(R.id.etNombre);
        etEmail       = findViewById(R.id.etEmail);
        etPassword    = findViewById(R.id.etPassword);
        spinnerRol    = findViewById(R.id.spinnerRol);
        spinnerNivel  = findViewById(R.id.spinnerNivel);
        btnGuardar    = findViewById(R.id.btnGuardar);

        // Cambiar el título según el modo
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(modo == MODO_CREAR ? "Nuevo usuario" : "Editar usuario");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /** Rellena los Spinner con las opciones de rol y nivel */
    private void configurarSpinners() {
        String[] roles = {"Estudiante", "Docente", "Padre/Madre"};
        ArrayAdapter<String> adapterRol = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, roles);
        adapterRol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRol.setAdapter(adapterRol);

        String[] niveles = {"Principiante", "Intermedio", "Avanzado"};
        ArrayAdapter<String> adapterNivel = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, niveles);
        adapterNivel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNivel.setAdapter(adapterNivel);
    }

    /**
     * En modo edición, carga los datos del usuario en los campos del formulario.
     */
    private void cargarDatosUsuario() {
        usuarioAEditar = DataManager.getInstance().getUsuarioPorId(usuarioId);
        if (usuarioAEditar == null) {
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        etNombre.setText(usuarioAEditar.getNombre());
        etEmail.setText(usuarioAEditar.getEmail());
        etPassword.setText(usuarioAEditar.getPassword());

        // Seleccionar el rol actual en el spinner
        switch (usuarioAEditar.getRol()) {
            case DOCENTE: spinnerRol.setSelection(1); break;
            case PADRE:   spinnerRol.setSelection(2); break;
            default:      spinnerRol.setSelection(0); break;
        }

        // Seleccionar el nivel actual en el spinner
        switch (usuarioAEditar.getNivel()) {
            case INTERMEDIO: spinnerNivel.setSelection(1); break;
            case AVANZADO:   spinnerNivel.setSelection(2); break;
            default:         spinnerNivel.setSelection(0); break;
        }
    }

    /**
     * Valida los campos y guarda el usuario (creando o actualizando según el modo).
     */
    private void guardarUsuario() {
        String nombre   = etNombre.getText().toString().trim();
        String email    = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();

        // Validaciones
        if (TextUtils.isEmpty(nombre)) {
            etNombre.setError("Campo obligatorio"); etNombre.requestFocus(); return;
        }
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Campo obligatorio"); etEmail.requestFocus(); return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Campo obligatorio"); etPassword.requestFocus(); return;
        }

        // Convertir la selección del spinner al enum de Rol
        Usuario.Rol rol;
        switch (spinnerRol.getSelectedItemPosition()) {
            case 1:  rol = Usuario.Rol.DOCENTE; break;
            case 2:  rol = Usuario.Rol.PADRE;   break;
            default: rol = Usuario.Rol.ESTUDIANTE; break;
        }

        // Convertir la selección del spinner al enum de Nivel
        Usuario.Nivel nivel;
        switch (spinnerNivel.getSelectedItemPosition()) {
            case 1:  nivel = Usuario.Nivel.INTERMEDIO; break;
            case 2:  nivel = Usuario.Nivel.AVANZADO;   break;
            default: nivel = Usuario.Nivel.PRINCIPIANTE; break;
        }

        if (modo == MODO_CREAR) {
            // Verificar que el email no está ya en uso
            if (DataManager.getInstance().emailYaRegistrado(email)) {
                etEmail.setError("Email ya registrado");
                etEmail.requestFocus();
                return;
            }
            Usuario nuevo = new Usuario(nombre, email, password, rol, nivel);
            DataManager.getInstance().crearUsuario(nuevo);
            Toast.makeText(this, "Usuario creado", Toast.LENGTH_SHORT).show();

        } else {
            // Actualizar el usuario existente
            usuarioAEditar.setNombre(nombre);
            usuarioAEditar.setEmail(email);
            usuarioAEditar.setPassword(password);
            usuarioAEditar.setRol(rol);
            usuarioAEditar.setNivel(nivel);
            DataManager.getInstance().actualizarUsuario(usuarioAEditar);
            Toast.makeText(this, "Usuario actualizado", Toast.LENGTH_SHORT).show();
        }

        finish(); // volver al listado
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
