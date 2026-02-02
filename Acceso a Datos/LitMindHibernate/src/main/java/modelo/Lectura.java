package modelo;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import utils.Genero;

@Entity
@Table(name = "lectura")
public class Lectura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_lectura;
	private String titulo;
	private String autor;
	private Genero genero;
	
	// lado inverso
	@OneToMany(mappedBy = "lectura") 
    private List<Asignacion> asignaciones;

	public Lectura() {
		super();
	}

	public Lectura(String titulo, String autor, Genero genero) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
	}

	// Getters y Setters
	public int getId() {
		return id_lectura;
	}

	public void setId(int id) {
		this.id_lectura = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_lectura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lectura other = (Lectura) obj;
		return Objects.equals(id_lectura, other.id_lectura);
	}

	@Override
	public String toString() {
		return "Lectura [id=" + id_lectura + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero
				+ "]";
	}

}