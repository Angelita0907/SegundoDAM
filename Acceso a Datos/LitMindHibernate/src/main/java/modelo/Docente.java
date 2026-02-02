package modelo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "docente")
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_docente;
	private String nombre;
	private String edad;
	private String especialidad;


	public Docente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Docente(String nombre, String edad, String especialidad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.especialidad = especialidad;
	}

	public int getId_docente() {
		return id_docente;
	}

	public void setId_docente(int id_docente) {
		this.id_docente = id_docente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_docente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Docente other = (Docente) obj;
		return id_docente == other.id_docente;
	}

	@Override
	public String toString() {
		return "Docente [id_docente=" + id_docente + ", nombre=" + nombre + ", edad=" + edad + ", especialidad="
				+ especialidad + ", usuario=" + "]";
	}

}
