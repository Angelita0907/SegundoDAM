package simulacionExamen.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ubicacion {
	
	private String calle;
	private int numero;
	private String codigoPostal;
	private Coordenada coordenadas;
	
	
	public Ubicacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Ubicacion(String calle, int numero, String codigoPostal) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
	}

	public Ubicacion(String calle, int numero, String codigoPostal, Coordenada coordenadas) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.coordenadas = coordenadas;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Coordenada getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	
	@Override
	public String toString() {
		return "Ubicacion [calle=" + calle + ", numero=" + numero + ", codigoPostal=" + codigoPostal + ", coordenadas="
				+ coordenadas + "]";
	}
	
	
	
	
}
