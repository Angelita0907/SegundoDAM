package simulacro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaTaller {

	public static void main(String[] args) {
		List<Thread> hilos = new ArrayList<>();
		Semaphore semaforoMecanico = new Semaphore(1);
		Semaphore semaforoCoche = new Semaphore(20);
		
		long t_comienzo = System.currentTimeMillis();
		
		try {
			semaforoMecanico.acquire(1);
			semaforoCoche.acquire(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Mecanico mecanico = new Mecanico("Mecanico", semaforoMecanico, semaforoCoche);
		Mecanico2 mecanico2 = new Mecanico2("Mecanico2", semaforoMecanico, semaforoCoche);
		Thread hiloMecanico = new Thread(mecanico);
		Thread hiloMecanico2 = new Thread(mecanico2);

		for (int i = 0; i <= 20; i++) {

			Coche coche = new Coche("Coche"+i, semaforoCoche, semaforoMecanico);
			Thread hiloCoche = new Thread(coche);

			hilos.add(hiloCoche);

		}

		hiloMecanico.start();
		hiloMecanico2.start();
		
		for (Thread h : hilos) {
			h.start();
		}

		
		for (Thread h : hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		long t_fin = System.currentTimeMillis();
		long tiempototal = t_fin - t_comienzo;
		System.out.println("El proceso total ha tardado = " + tiempototal + "mseg");

	}

}
