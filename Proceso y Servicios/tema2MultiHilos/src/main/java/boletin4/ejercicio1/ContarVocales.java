package boletin4.ejercicio1;

public class ContarVocales {
	
	private int vocales = 0;
	private String textoLeer;
	
	public ContarVocales(String textoLeer) {
		super();
		this.textoLeer = textoLeer;
	}

	public int getVocales() {
		return vocales;
	}
	public void setVocales(int vocales) {
		this.vocales = vocales;
	}
	public String getTextoLeer() {
		return textoLeer;
	}
	public void setTextoLeer(String textoLeer) {
		this.textoLeer = textoLeer;
	}
	
	public synchronized void aumentarContador(int cantidad) {
		vocales = vocales+ cantidad;
	}

}
