package semaforos.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class GestionaGasolinera {

	public static void main(String[] args) {
	
		Semaforo semaforo = new Semaforo(3);
		
		// hilo
		int coches = 8;
		
		List<Thread> hilos = new ArrayList<>();
		
		for (int i = 0; i < coches; i++) {
			hilos.add(new Coche(semaforo, "hilo"+(i+1)));
		}
		
		for (Thread hilo : hilos) {
			hilo.start();
		}
		
	}
}
