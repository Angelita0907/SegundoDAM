package Boletin1;

import java.util.ArrayList;
import java.util.List;

public class GestionaMascotas {
	
	public static void main(String[] args) {
		
		Mascota lulu = new Mascota("Lulúc", 0);
		
		/*Thread cuidador1 = new Thread(lulu, "Cuidador1");
		Thread cuidador2 = new Thread(lulu, "Cuidador2");
		Thread cuidador3 = new Thread(lulu, "Cuidador3");
		Thread cuidador4 = new Thread(lulu, "Cuidador4");
		Thread cuidador5 = new Thread(lulu, "Cuidador5");
		
		
		cuidador1.start();
		cuidador2.start();
		cuidador3.start();
		cuidador4.start();
		cuidador5.start();
		
		try {
			cuidador1.join();
			cuidador2.join();
			cuidador3.join();
			cuidador4.join();
			cuidador5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		// para 100 cuidadores
		
		List<Thread> listaCuidadores = new ArrayList<>();
		
		for(int i = 0; i<100; i++) {
			Thread cuidador = new Thread(lulu, "cuidador"+i);
			if(i%2==0) {
				cuidador.setPriority(cuidador.MAX_PRIORITY);
			}
			else {
				cuidador.setPriority(cuidador.MIN_PRIORITY);
			}
			listaCuidadores.add(cuidador);
			cuidador.start();
		}
		
		for (Thread thread : listaCuidadores) {
			
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(lulu.getVecesCome());
		
	}

}
