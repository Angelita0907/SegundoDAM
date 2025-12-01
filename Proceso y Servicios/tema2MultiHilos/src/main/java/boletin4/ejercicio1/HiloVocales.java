package boletin4.ejercicio1;

public class HiloVocales extends Thread {

	private char vocal;
	private int numVocales;
	private CuentaVocales vocales;
	private String texto;

	

	public HiloVocales(char vocal,CuentaVocales vocales, String texto) {
		super();
		this.vocal = vocal;
		this.vocales = vocales;
		this.texto = texto;
	}

	public char getVocal() {
		return vocal;
	}

	public void setVocal(char vocal) {
		this.vocal = vocal;
	}

	public int getNumVocales() {
		return numVocales;
	}

	public void setNumVocales(int numVocales) {
		this.numVocales = numVocales;
	}

	public CuentaVocales getVocales() {
		return vocales;
	}

	public void setVocales(CuentaVocales vocales) {
		this.vocales = vocales;
	}
	
	
	public void cuentaVocales(char vocal, String texto) {
		
		
		
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public int contar() {
		
		int contador = 0;
		
		return contador;
	}

}
