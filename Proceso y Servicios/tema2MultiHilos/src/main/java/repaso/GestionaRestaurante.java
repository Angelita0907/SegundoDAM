package repaso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaRestaurante {
	
	public static void main(String[] args) {
		
		Semaphore cocina = new Semaphore(3);
		
		try {
			
			cocina.acquire(3);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Thread> hilos = new ArrayList<>();
		
		// el cocinero coge los 3 turnos para avisar cuando tenga la comida
		Cocinero cocinero = new Cocinero("Cocinero", cocina);
		
		Thread hiloCocinero = new Thread(cocinero);
		
		hilos.add(hiloCocinero);
		
		int comensales = 3;
		
		for (int i = 0; i < comensales; i++) {
			Cliente cliente = new Cliente(cocina);
			
			Thread hiloCliente = new Thread(cliente);
			
			hilos.add(hiloCliente);
			
		}
		
		for (Thread thread : hilos) {
			thread.start();
		}
		
		for (Thread thread : hilos) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
