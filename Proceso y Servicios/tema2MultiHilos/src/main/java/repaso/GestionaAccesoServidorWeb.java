package repaso;

import java.util.ArrayList;
import java.util.List;

public class GestionaAccesoServidorWeb {

	public static void main(String[] args) {
		
		Servidor capacidad = new Servidor(12);

		int peticiones = 20;
		
		List<Thread> hiloPeticiones = new ArrayList<>();
		
		for (int i = 0; i < peticiones; i++) {
			hiloPeticiones.add(new Thread(new PeticionWeb(capacidad, "Peticion"+(i+1))));
		}
		
		for (Thread thread : hiloPeticiones) {
			thread.start();
		}
		
	}

}
