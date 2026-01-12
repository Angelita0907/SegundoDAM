package semaforos.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class GestionaAccesoServidorWeb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Servidor servidor = new Servidor(12);
		
		// hilo
		int peticiones = 20;
		
		List<Thread> hilos = new ArrayList<>();
		
		for (int i = 0; i < peticiones; i++) {
			hilos.add(new Thread(new PeticionWeb(servidor, "hilo"+(i+1))));
		}
		
		for (Thread hilo : hilos) {
			hilo.start();
		}

	}

}
