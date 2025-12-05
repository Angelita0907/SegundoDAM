package librosMongo.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Lectura {
    
    private String id; 
    private String titulo; 
    private String autor; 
    private int numPalabras; 
    private float puntuacionMedia; 
    private boolean disponible;
    private String tipoContenido; 
    private List<String> tiposPrueba; 
    

    public Lectura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lectura(String id, String titulo, String autor, int numPalabras, float puntuacionMedia, boolean disponible,
			String tipoContenido, List<String> tiposPrueba) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.numPalabras = numPalabras;
		this.puntuacionMedia = puntuacionMedia;
		this.disponible = disponible;
		this.tipoContenido = tipoContenido;
		this.tiposPrueba = new ArrayList<>();
	}

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

    public int getNumPalabras() {
        return numPalabras;
    }

    public void setNumPalabras(int numPalabras) {
        this.numPalabras = numPalabras;
    }

    public float getPuntuacionMedia() {
        return puntuacionMedia;
    }

    public void setPuntuacionMedia(float puntuacionMedia) {
        this.puntuacionMedia = puntuacionMedia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public List<String> getTiposPrueba() {
        return tiposPrueba;
    }

    public void setTiposPrueba(List<String> tiposPrueba) {
        this.tiposPrueba = tiposPrueba;
    }

    
    @Override
    public String toString() {
        return "Lectura [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", tipoContenido=" + tipoContenido + "]";
    }
}