package boletin3.ejercicio3;

public class MultiplosCooperativos {
/*
	private int numero;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public MultiplosCooperativos(int numero) {
		super();
		this.numero = numero;
	}
*/
	// sacamos los 10 multiplos de el numero que le pasemos 
	public void multiplicar(int numero) {
	
		for(int i = 0; i < 10; i++) {
			System.out.println(i*numero);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}



}
