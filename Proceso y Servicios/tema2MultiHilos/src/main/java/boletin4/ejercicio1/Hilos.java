package boletin4.ejercicio1;

import java.util.Iterator;

public class Hilos implements Runnable {

	// aqui creamos lo que hace el hilo cuando luego lo llama el padre
	// basicamente contar una sola vocal y como son 5 pues en el padre llamamos 5
	// veces
	// y con la otra clase contador podremos sincronizar el metodo

	private ContarVocales contador;
	private char vocal;

	public Hilos(ContarVocales contador, char vocal) {
		super();
		this.contador = contador;
		this.vocal = vocal;
	}

	public ContarVocales getContador() {
		return contador;
	}

	public void setContador(ContarVocales contador) {
		this.contador = contador;
	}

	public char getVocal() {
		return vocal;
	}

	public void setVocal(char vocal) {
		this.vocal = vocal;
	}

	@Override
	public void run() {
		
		int vocales = 0;
		String texto = contador.getTextoLeer();
		
		for (int i = 0; i < texto.length(); i++) {
			if(texto.charAt(i) == vocal) {
				vocales++;
			}
		}
		
		contador.aumentarContador(vocales);
		
		System.out.println(Thread.currentThread());

	}

}
