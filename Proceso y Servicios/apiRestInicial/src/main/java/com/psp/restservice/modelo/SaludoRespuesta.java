package com.psp.restservice.modelo;

  
public class SaludoRespuesta {
	private long identificador;
	private String contenido;
	
	public SaludoRespuesta(long identificador, String contenido) {
		super();   
		this.identificador = identificador;
		this.contenido = contenido;
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "SaludoRespuesta [identificador=" + identificador + ", contenido=" + contenido + "]";
	}

}
