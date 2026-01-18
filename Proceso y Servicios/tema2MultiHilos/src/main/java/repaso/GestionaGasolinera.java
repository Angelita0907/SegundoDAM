package repaso;

import java.util.ArrayList;
import java.util.List;

public class GestionaGasolinera {

	public static void main(String[] args) {
		
		Gasolinera surtidor = new Gasolinera(3);

		int coches = 8;
		
		List<Thread> hiloCoches = new ArrayList<>();
		
		for (int i = 0; i < coches; i++) {
			hiloCoches.add(new Thread(new Coche(surtidor, "Coche"+(i+1))));
		}
		
		for (Thread thread : hiloCoches) {
			thread.start();
		}
		
	}

}
