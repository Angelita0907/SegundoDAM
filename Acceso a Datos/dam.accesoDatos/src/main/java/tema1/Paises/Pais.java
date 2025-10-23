package tema1.Paises;

import java.util.Arrays;

public class Pais {
	
	private String nombre, continente, moneda;
	private String [] idioma;
	private int poblacion;
	
	public Pais(String nombre, String continente, int poblacion, String[] idioma, String moneda) {
		super();
		this.nombre = nombre;
		this.continente = continente;
		this.moneda = moneda;
		this.idioma = idioma;
		this.poblacion = poblacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public String[] getIdioma() {
		return idioma;
	}
	public void setIdioma(String[] idioma) {
		this.idioma = idioma;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public int getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", continente=" + continente + ", moneda=" + moneda + ", idioma="
				+ Arrays.toString(idioma) + ", poblacion=" + poblacion + "]";
	}
	
	

}
