package es.ejemplo.android.litmind.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestor de datos local (en memoria).
 * Actúa como repositorio temporal mientras no hay base de datos real.
 * En el futuro se sustituirá por llamadas a Retrofit/API REST.
 *
 * Patrón Singleton: solo existe una instancia durante la vida de la app.
 */
public class DataManager {

    private static DataManager instancia;

    private List<Usuario> usuarios;
    private Usuario usuarioActual; // usuario que ha iniciado sesión

    // Constructor privado: no se puede crear desde fuera
    private DataManager() {
        usuarios = new ArrayList<>();
        cargarUsuariosDePrueba();
    }

    /**
     * Devuelve la instancia única del DataManager (Singleton).
     */
    public static DataManager getInstance() {
        if (instancia == null) {
            instancia = new DataManager();
        }
        return instancia;
    }

    // ---- Usuarios de prueba ----

    /**
     * Carga los usuarios iniciales hardcodeados.
     * Estos datos simulan lo que vendría de la base de datos.
     */
    private void cargarUsuariosDePrueba() {
        usuarios.add(new Usuario(
                "1", "Admin LitMind", "admin@litmind.app", "admin123",
                Usuario.Rol.ADMIN, Usuario.Nivel.AVANZADO, 0, 0, 0));

        usuarios.add(new Usuario(
                "2", "Angela Chica", "angela@litmind.app", "1234",
                Usuario.Rol.ESTUDIANTE, Usuario.Nivel.PRINCIPIANTE, 12, 7, 3));

        usuarios.add(new Usuario(
                "3", "Diego Garcia", "diego@litmind.app", "1234",
                Usuario.Rol.ESTUDIANTE, Usuario.Nivel.INTERMEDIO, 25, 14, 8));

        usuarios.add(new Usuario(
                "4", "Laura Sanchez", "laura@litmind.app", "1234",
                Usuario.Rol.DOCENTE, Usuario.Nivel.AVANZADO, 40, 30, 15));

        usuarios.add(new Usuario(
                "5", "Ana Martinez", "ana@litmind.app", "1234",
                Usuario.Rol.PADRE, Usuario.Nivel.INTERMEDIO, 8, 3, 2));

        usuarios.add(new Usuario(
                "6", "Carlos Ruiz", "carlos@litmind.app", "1234",
                Usuario.Rol.ESTUDIANTE, Usuario.Nivel.PRINCIPIANTE, 5, 2, 1));
    }

    // ---- Autenticación ----

    /**
     * Intenta hacer login con email y contraseña.
     * @return el Usuario si las credenciales son correctas, null si no.
     */
    public Usuario login(String email, String password) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email.trim())
                    && u.getPassword().equals(password)) {
                usuarioActual = u;
                return u;
            }
        }
        return null;
    }

    /**
     * Cierra la sesión del usuario actual.
     */
    public void logout() {
        usuarioActual = null;
    }

    /**
     * Devuelve el usuario que tiene sesión abierta actualmente.
     */
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * Establece el usuario activo (útil tras registro).
     */
    public void setUsuarioActual(Usuario u) {
        this.usuarioActual = u;
    }

    // ---- CRUD de Usuarios (solo para admin) ----

    /**
     * Devuelve todos los usuarios del sistema.
     */
    public List<Usuario> getTodosUsuarios() {
        return new ArrayList<>(usuarios);
    }

    /**
     * Devuelve todos los usuarios excluyendo el admin.
     */
    public List<Usuario> getUsuariosNoAdmin() {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (!u.esAdmin()) resultado.add(u);
        }
        return resultado;
    }

    /**
     * Busca un usuario por su ID.
     * @return el Usuario o null si no existe.
     */
    public Usuario getUsuarioPorId(String id) {
        for (Usuario u : usuarios) {
            if (u.getId() != null && u.getId().equals(id)) return u;
        }
        return null;
    }

    /**
     * Añade un nuevo usuario a la lista.
     * Genera el ID automáticamente.
     */
    public void crearUsuario(Usuario nuevo) {
        nuevo.setId(String.valueOf(System.currentTimeMillis()));
        usuarios.add(nuevo);
    }

    /**
     * Actualiza los datos de un usuario existente buscándolo por ID.
     */
    public boolean actualizarUsuario(Usuario actualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() != null &&
                    usuarios.get(i).getId().equals(actualizado.getId())) {
                usuarios.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina el usuario con el ID indicado.
     * @return true si se eliminó correctamente.
     */
    public boolean eliminarUsuario(String id) {
        return usuarios.removeIf(u -> u.getId() != null && u.getId().equals(id));
    }

    /**
     * Comprueba si un email ya está registrado.
     * Útil para validar el formulario de registro.
     */
    public boolean emailYaRegistrado(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email.trim())) return true;
        }
        return false;
    }
}
