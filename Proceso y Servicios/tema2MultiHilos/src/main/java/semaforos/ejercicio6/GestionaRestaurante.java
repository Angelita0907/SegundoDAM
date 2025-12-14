package semaforos.ejercicio6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaRestaurante {
	public static void main(String[] args) {
	List<Thread> hilos = new ArrayList<>();
	Semaphore semaforoMenu = new Semaphore(3);
	Semaphore semaforoClientes = new Semaphore(1);
	try {
		semaforoClientes.acquire(1);
		semaforoMenu.acquire(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Cocinero cocinero = new Cocinero("Cocinero", semaforoMenu,semaforoClientes);
	Thread cocineroHilo = new Thread(cocinero);
	
	hilos.add(cocineroHilo);
	for (int i = 1; i <= 6; i++) {
		Comensal comensal = new Comensal("Comensal"+i, semaforoClientes,semaforoMenu);
		Thread comensalHilo = new Thread(comensal);
		hilos.add(comensalHilo);
	}
	
	for (Thread h : hilos) {
		h.start();
	}
	
	for (Thread h : hilos) {
		try {
			h.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
}