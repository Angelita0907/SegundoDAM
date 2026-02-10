package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cine")
public class Cine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCine;
	private String nombre;
	private String ubicacion;
	
	@OneToMany(mappedBy = "cine", cascade = CascadeType.ALL)
	private List<Sala> salas;

	public void addSala(Sala s) {

		if (!this.salas.contains(s)) {
			this.salas.add(s);
		}
		s.setCine(this);
	}
	
	public Cine() {
		super();
		this.salas = new ArrayList<Sala>();
	}

	public Cine(String nombre, String ubicacion) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.salas = new ArrayList<Sala>();
	}

	public int getIdCine() {
		return idCine;
	}

	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCine);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return idCine == other.idCine;
	}

	@Override
	public String toString() {
		return "Cine [idCine=" + idCine + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", salas=" + salas + "]";
	}
	
	
}
