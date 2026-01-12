package librosMongo.modelo;

import java.util.ArrayList;
import java.util.List;

import utils.Roles;
import utils.TipoUsuario;

public class Usuario implements Comparable<Usuario> {

    private String id; 
    private String nombreCompleto;
    private int edad; 
    private boolean esDocente; 
    private Roles rolPrincipal; // (Estudiante, Docente, Familia)
    private int puntosPorLogro; 
    private TipoUsuario tipoUsuario; 
    private Lectura lecturaActiva; 
    private List<Asignacion> lecturasAsignadas; 


	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String id, String nombreCompleto, int edad, boolean esDocente, Roles rolPrincipal,
			int puntosPorLogro, TipoUsuario tipoUsuario, Lectura lecturaActiva,
			List<Asignacion> asignacionesRecibidas) {
		super();
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.esDocente = esDocente;
		this.rolPrincipal = rolPrincipal;
		this.puntosPorLogro = puntosPorLogro;
		this.tipoUsuario = tipoUsuario;
		this.lecturaActiva = lecturaActiva;
		this.lecturasAsignadas = new ArrayList<>();
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getEsDocente() {
        return esDocente;
    }

    public void setEsDocente(Boolean esDocente) {
        this.esDocente = esDocente;
    }

    public Roles getRolPrincipal() {
        return rolPrincipal;
    }

    public void setRolPrincipal(Roles rolPrincipal) {
        this.rolPrincipal = rolPrincipal;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getPuntosPorLogro() {
        return puntosPorLogro;
    }

    public void setPuntosPorLogro(int puntosPorLogro) {
        this.puntosPorLogro = puntosPorLogro;
    }
    
    public Lectura getLecturaActiva() {
		return lecturaActiva;
	}

	public void setLecturaActiva(Lectura lecturaActiva) {
		this.lecturaActiva = lecturaActiva;
	}

	public List<Asignacion> getAsignacionesRecibidas() {
		return lecturasAsignadas;
	}

	public void setAsignacionesRecibidas(List<Asignacion> asignacionesRecibidas) {
		this.lecturasAsignadas = asignacionesRecibidas;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreCompleto=" + nombreCompleto + ", edad=" + edad + ", esDocente="
				+ esDocente + ", rolPrincipal=" + rolPrincipal + ", puntosPorLogro=" + puntosPorLogro + ", tipoUsuario="
				+ tipoUsuario + ", lecturaActiva=" + lecturaActiva + ", lecturasAsignadas=" + lecturasAsignadas + "]";
	}


	// aquí implemento comparable para usarlo en el servicio
	
	@Override
	public int compareTo(Usuario usu) {
		// TODO Auto-generated method stub
		return Integer.compare(this.puntosPorLogro, usu.puntosPorLogro);
	}
	
	
	
}