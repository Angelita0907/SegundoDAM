package librosMongo.modelo;

import utils.Genero;

public class Lectura {

	private String id;
	private String titulo;
	private String autor;
	private Genero genero; 
	private float progreso;

	public Lectura() {
		super();
	}

	public Lectura(String id, String titulo, String autor, Genero genero, float progreso) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.progreso = progreso;
	}

	// Getters y Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public float getProgreso() {
		return progreso;
	}

	public void setProgreso(float progreso) {
		this.progreso = progreso;
	}

}