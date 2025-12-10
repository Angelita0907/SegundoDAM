package semaforos.ejercicio6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaRestaurante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Semaphore cocina = new Semaphore(3);
		
		// el cocinero coge los 3 espacios y es quien los lbera
		try {
			cocina.acquire(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Thread> hilos = new ArrayList<>();
		
		Cocinero cocinero = new Cocinero("Cocinero", cocina);
		
		Thread Hilococinero = new Thread(cocinero);
		
		hilos.add(Hilococinero);
		
		int comensales = 3; 
		
		for (int i = 0; i < comensales; i++) {
			Comensal comensal = new Comensal(cocina);
			
			Thread hiloComensal = new Thread(comensal);
			
			hilos.add(hiloComensal);
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
