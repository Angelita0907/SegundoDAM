package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import utils.Roles;
import utils.TipoUsuario;

@Entity
@Table(name = "usuario")
public class Usuario implements Comparable<Usuario> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	private String nombreCompleto;
	private int edad;
	@Enumerated(EnumType.STRING)
	private Roles rolPrincipal; // (Estudiante, Docente, Familia)
	private int puntosPorLogro;
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;

	@OneToOne(optional = true)
	private Estudiante estudiante;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombreCompleto, int edad, Roles rolPrincipal, int puntosPorLogro,
			TipoUsuario tipoUsuario, Estudiante estudiante) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.rolPrincipal = rolPrincipal;
		this.puntosPorLogro = puntosPorLogro;
		this.tipoUsuario = tipoUsuario;
		this.estudiante = estudiante;
	}

	public int getId() {
		return id_usuario;
	}

	public void setId(int id_usuario) {
		this.id_usuario = id_usuario;
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

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id_usuario + ", nombreCompleto=" + nombreCompleto + ", edad=" + edad + ", esDocente="
				+ ", rolPrincipal=" + rolPrincipal + ", puntosPorLogro=" + puntosPorLogro + ", tipoUsuario="
				+ tipoUsuario + ", lecturasAsignadas=" + "]";
	}

	// aquí implemento comparable para usarlo en el servicio

	@Override
	public int compareTo(Usuario usu) {
		// TODO Auto-generated method stub
		return Integer.compare(this.puntosPorLogro, usu.puntosPorLogro);
	}

}