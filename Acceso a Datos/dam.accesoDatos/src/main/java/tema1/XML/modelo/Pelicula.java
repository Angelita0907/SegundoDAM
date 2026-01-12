package tema1.XML.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	
	private String titulo;
	private int fecha;
	private String director;
	private List<String> actores;
		
	public Pelicula(String titulo, int fecha, String director, List<String> actores) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.director = director;
		this.actores = new ArrayList<>();
	}

	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	public List<String> getActores() {
		return actores;
	}

	public void setActores(List<String> actores) {
		this.actores = actores;
	}

	@Override
	public String toString() {
		return "Pelicula titulo=" + titulo + ", fecha=" + fecha + ", director=" + director + ", actores=" + actores;
	}
	
	

}
