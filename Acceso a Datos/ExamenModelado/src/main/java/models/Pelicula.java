package models;

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
@Table(name = "pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPelicula;
	private String titulo;
	private String genero;
	private int duracion;
	
	@ManyToMany(mappedBy = "peliculas")
	private Set<Sala> salas;

	public Pelicula() {
		super();
		this.salas = new HashSet<Sala>();
	}

	public Pelicula(String titulo, String genero, int duracion) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.salas = new HashSet<Sala>();
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Set<Sala> getSalas() {
		return salas;
	}

	public void setSalas(Set<Sala> salas) {
		this.salas = salas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPelicula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return idPelicula == other.idPelicula;
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", titulo=" + titulo + ", genero=" + genero + ", duracion="
				+ duracion + ", salas=" + salas + "]";
	}
	
	public void addSala(Sala s) {
		this.salas.add(s);
		if (!s.getPeliculas().contains(this)) {
			s.getPeliculas().add(this);
		}
	}
	
}
