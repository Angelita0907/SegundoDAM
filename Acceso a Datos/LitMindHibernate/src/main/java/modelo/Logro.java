package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "logro")
public class Logro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_logro;
	private String nombreLogro;
	private String descripcion;

	@ManyToMany()
	private Set<Estudiante> estudiantes;

	public Logro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Logro(String nombreLogro, String descripcion) {
		super();
		this.nombreLogro = nombreLogro;
		this.descripcion = descripcion;
		this.estudiantes = new HashSet<>();
	}

	public int getId() {
		return id_logro;
	}

	public void setId(int id) {
		this.id_logro = id;
	}

	public String getNombreLogro() {
		return nombreLogro;
	}

	public void setNombreLogro(String nombreLogro) {
		this.nombreLogro = nombreLogro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_logro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logro other = (Logro) obj;
		return Objects.equals(id_logro, other.id_logro);
	}

	@Override
	public String toString() {
		return "Logro [id_logro=" + id_logro + ", nombreLogro=" + nombreLogro + ", descripcion=" + descripcion + "]";
	}
	
	public void addEstudiante(Estudiante e) {
		this.estudiantes.add(e);
		if (!e.getLogros().contains(this)) {
			e.getLogros().add(this);
		}
	}
	
	public void removeEstudiante(Estudiante e) {
		this.estudiantes.remove(e);
		if (e.getLogros().contains(this)) {
			e.getLogros().remove(this);
		}
	}

}
