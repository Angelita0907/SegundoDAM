package es.ejemplo.android.litmind.model;

/**
 * Modelo de datos que representa un usuario de la aplicación.
 * Por ahora los datos son locales (hardcodeados en DataManager).
 * En el futuro se sustituirá por llamadas a la API REST.
 */
public class Usuario {

    public enum Rol {
        ADMIN,
        ESTUDIANTE,
        DOCENTE,
        PADRE
    }

    public enum Nivel {
        PRINCIPIANTE,
        INTERMEDIO,
        AVANZADO
    }

    private String id;
    private String nombre;
    private String email;
    private String password;
    private Rol rol;
    private Nivel nivel;
    private int lecturasCompletadas;
    private int rachaDias;
    private int logros;
    private String avatarSeed; // semilla para generar el avatar (nombre usado como base)

    // Constructor completo
    public Usuario(String id, String nombre, String email, String password,
                   Rol rol, Nivel nivel, int lecturasCompletadas, int rachaDias, int logros) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.nivel = nivel;
        this.lecturasCompletadas = lecturasCompletadas;
        this.rachaDias = rachaDias;
        this.logros = logros;
        this.avatarSeed = nombre;
    }

    // Constructor simplificado para crear nuevos usuarios
    public Usuario(String nombre, String email, String password, Rol rol, Nivel nivel) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.nivel = nivel;
        this.lecturasCompletadas = 0;
        this.rachaDias = 0;
        this.logros = 0;
        this.avatarSeed = nombre;
    }

    // ---- Getters y Setters ----

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public Nivel getNivel() { return nivel; }
    public void setNivel(Nivel nivel) { this.nivel = nivel; }

    public int getLecturasCompletadas() { return lecturasCompletadas; }
    public void setLecturasCompletadas(int lecturasCompletadas) { this.lecturasCompletadas = lecturasCompletadas; }

    public int getRachaDias() { return rachaDias; }
    public void setRachaDias(int rachaDias) { this.rachaDias = rachaDias; }

    public int getLogros() { return logros; }
    public void setLogros(int logros) { this.logros = logros; }

    public String getAvatarSeed() { return avatarSeed != null ? avatarSeed : nombre; }

    /**
     * Devuelve las iniciales del nombre para usarlas como avatar de texto.
     * Ej: "Angela Chica" -> "AC"
     */
    public String getIniciales() {
        if (nombre == null || nombre.isEmpty()) return "?";
        String[] partes = nombre.trim().split("\\s+");
        if (partes.length == 1) return String.valueOf(partes[0].charAt(0)).toUpperCase();
        return (String.valueOf(partes[0].charAt(0)) + String.valueOf(partes[1].charAt(0))).toUpperCase();
    }

    /**
     * Devuelve el label legible del rol
     */
    public String getRolLabel() {
        switch (rol) {
            case ADMIN: return "Administrador";
            case DOCENTE: return "Docente";
            case PADRE: return "Padre/Madre";
            default: return "Estudiante";
        }
    }

    /**
     * Devuelve el label legible del nivel
     */
    public String getNivelLabel() {
        switch (nivel) {
            case INTERMEDIO: return "Intermedio";
            case AVANZADO: return "Avanzado";
            default: return "Principiante";
        }
    }

    /**
     * Indica si este usuario tiene permisos de administrador
     */
    public boolean esAdmin() {
        return rol == Rol.ADMIN;
    }
}
