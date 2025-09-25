package dam.accesoDatos.repaso.biblioteca.modelo;

import java.util.Objects;

public class Libro {

	private String isbn;
	private String titulo;
	private String autor;
	private int anioPublicacion;
	private Editorial editorial;
	private int ejemplares_dis;
	private Genero genero;

	public Libro(String isbn, String titulo, String autor, int anioPublicacion, Editorial editorial, int ejemplares_dis,
			Genero genero) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.editorial = editorial;
		this.ejemplares_dis = ejemplares_dis;
		this.genero = genero;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public int getEjemplares_dis() {
		return ejemplares_dis;
	}

	public void setEjemplares_dis(int ejemplares_dis) {
		this.ejemplares_dis = ejemplares_dis;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", anioPublicacion="
				+ anioPublicacion + ", editorial=" + editorial + ", ejemplares_dis=" + ejemplares_dis + "]";
	}

}
