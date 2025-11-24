package boletin4.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class GestionaVocales {

	public static void main(String[] args) {
		
		String texto = "Esto es un ejemplo de texto para el ejercicio de Programacion Multihilo con Java.";

		char [] vocales = {'a','e','i','o','u'};
		
		ContarVocales contador = new ContarVocales(texto);
		
		List<Thread> hilos = new ArrayList<>();
		
		for (char vocal : vocales) {
			Hilos contarVocal = new Hilos(contador, vocal);
			
			Thread hilo = new Thread(contarVocal, texto);
			hilos.add(hilo);
			
		}
		
		for (Thread hilo : hilos) {
			hilo.start();
		}
		
		for (Thread hilo : hilos) {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Vocales toal: "+ contador.getVocales());
		
	}

}
