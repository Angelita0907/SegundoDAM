package boletin4.ejercicio1;

public class HiloVocales extends Thread {

	private char vocal;
	private int numVocales;
	private CuentaVocales vocales;

	public HiloVocales(char vocal, int numVocales, CuentaVocales vocales) {
		super();
		this.vocal = vocal;
		this.numVocales = numVocales;
		this.vocales = vocales;
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

}
