package modelo;

import java.util.Objects;

public class Piloto {
	
	private int identificadorPiloto;
	private String nombre;
	private int puntos;
	private int identificadorEquipo;
	private String pais;
	
	public Piloto(int identificadorPiloto, String nombre, int puntos, int identificadorEquipo, String pais) {
		super();
		this.identificadorPiloto = identificadorPiloto;
		this.nombre = nombre;
		this.puntos = puntos;
		this.identificadorEquipo = identificadorEquipo;
		this.pais = pais;
	}
	
	public Piloto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdentificadorPiloto() {
		return identificadorPiloto;
	}
	public void setIdentificadorPiloto(int identificadorPiloto) {
		this.identificadorPiloto = identificadorPiloto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getIdentificadorEquipo() {
		return identificadorEquipo;
	}
	public void setIdentificadorEquipo(int identificadorEquipo) {
		this.identificadorEquipo = identificadorEquipo;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificadorPiloto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piloto other = (Piloto) obj;
		return identificadorPiloto == other.identificadorPiloto;
	}

	@Override
	public String toString() {
		return "Piloto [identificadorPiloto=" + identificadorPiloto + ", nombre=" + nombre + ", puntos=" + puntos
				+ ", identificadorEquipo=" + identificadorEquipo + ", pais=" + pais + "]";
	}
	
	
	
	
}
