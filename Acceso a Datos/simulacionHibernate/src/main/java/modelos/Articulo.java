package modelos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "articulo")
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_articulo;
	private String titulo;
	private int numPaginaInicio;
	private int numPaginaFin;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_revista")
	private Revista revista;

	@ManyToMany(cascade = CascadeType.PERSIST)
	private Set<Autor> autores;

	public Articulo() {
		super();
		this.autores = new HashSet<>();
		// TODO Auto-generated constructor stub
	}

	public Articulo(String titulo, int numPaginaInicio, int numPaginaFin) {
		super();
		this.titulo = titulo;
		this.numPaginaInicio = numPaginaInicio;
		this.numPaginaFin = numPaginaFin;
		this.autores = new HashSet<>();
	}

	public int getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumPaginaInicio() {
		return numPaginaInicio;
	}

	public void setNumPaginaInicio(int numPaginaInicio) {
		this.numPaginaInicio = numPaginaInicio;
	}

	public int getNumPaginaFin() {
		return numPaginaFin;
	}

	public void setNumPaginaFin(int numPaginaFin) {
		this.numPaginaFin = numPaginaFin;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_articulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return id_articulo == other.id_articulo;
	}

	@Override
	public String toString() {
		return "Articulo [id_articulo=" + id_articulo + ", titulo=" + titulo + ", numPaginaInicio=" + numPaginaInicio
				+ ", numPaginaFin=" + numPaginaFin + ", revista=" + revista + "]";
	}
	
	public void addAutor(Autor a) {

		this.autores.add(a);

		if (!a.getArticulos().contains(this)) {
			a.getArticulos().add(this);
			
		}

	}

	public void removeAutor(Autor a) {

		this.autores.remove(a);

		if (a.getArticulos().contains(this)) {
			a.getArticulos().remove(this);

		}

	}

}
