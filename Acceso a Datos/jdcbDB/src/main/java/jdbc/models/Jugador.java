package jdbc.models;

import java.util.Objects;

public class Jugador {

	private int id;
	private String nombre;
	private String email;
	private int puntosTotales;

	public Jugador() {
	}

	public Jugador( String nombre, String email, int puntosTotales) {
	
		this.nombre = nombre;
		this.email = email;
		this.puntosTotales = puntosTotales;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPuntosTotales() {
		return puntosTotales;
	}

	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}

	@Override
	public String toString() {
		return "Jugador{" + "id=" + id + ", nombre='" + nombre + '\'' + ", email='" + email + '\'' + ", puntosTotales="
				+ puntosTotales + '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return id == other.id;
	}
	
	
}