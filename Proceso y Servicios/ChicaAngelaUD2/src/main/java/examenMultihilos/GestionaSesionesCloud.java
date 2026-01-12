<<<<<<< HEAD
package examenMultihilos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaSesionesCloud {

	// me he liado con todo no se que me ha pasado (no está bien acabado)
	
	public static void main(String[] args) {
		
		List<Thread> hilos = new ArrayList<>();
		Semaphore semaforoEd = new Semaphore(20);
		Semaphore semaforroEp  = new Semaphore(8);
		
		try {
			semaforoEd.acquire(20);
			semaforroEp.acquire(8);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EntornoCloud entornoED = new EntornoCloud(TipoEntorno.ED, semaforoEd);
		EntornoCloud entornoEP = new EntornoCloud(TipoEntorno.EP, semaforoEd);
		
		Thread hiloEntornoEd = new Thread(entornoED);
		Thread hiloEntornoEP = new Thread(entornoEP);
		
		
		for (int i = 0; i <= 35; i++) {
			
			Desarrollador desarolladorED = new Desarrollador("Desarollador"+i, semaforoEd);
			Thread hiloEd = new Thread(desarolladorED);
			
			Desarrollador desarrolladorEP = new Desarrollador("Desarollador"+i, semaforroEp);
			Thread hiloEp = new Thread(desarrolladorEP);
			
			hilos.add(hiloEp);
			hilos.add(hiloEd);
		}
		
		hiloEntornoEd.start();
		hiloEntornoEP.start();
		
		for (Thread thread : hilos) {
			thread.start();
		}
		
		try {
			hiloEntornoEd.join();
			hiloEntornoEP.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
=======
package examenMultihilos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaSesionesCloud {

	// me he liado con todo no se que me ha pasado (no está bien acabado)
	
	public static void main(String[] args) {
		
		List<Thread> hilos = new ArrayList<>();
		Semaphore semaforoEd = new Semaphore(20);
		Semaphore semaforroEp  = new Semaphore(8);
		
		try {
			semaforoEd.acquire(20);
			semaforroEp.acquire(8);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EntornoCloud entornoED = new EntornoCloud(TipoEntorno.ED, semaforoEd);
		EntornoCloud entornoEP = new EntornoCloud(TipoEntorno.EP, semaforoEd);
		
		Thread hiloEntornoEd = new Thread(entornoED);
		Thread hiloEntornoEP = new Thread(entornoEP);
		
		
		for (int i = 0; i <= 35; i++) {
			
			Desarrollador desarolladorED = new Desarrollador("Desarollador"+i, semaforoEd);
			Thread hiloEd = new Thread(desarolladorED);
			
			Desarrollador desarrolladorEP = new Desarrollador("Desarollador"+i, semaforroEp);
			Thread hiloEp = new Thread(desarrolladorEP);
			
			hilos.add(hiloEp);
			hilos.add(hiloEd);
		}
		
		hiloEntornoEd.start();
		hiloEntornoEP.start();
		
		for (Thread thread : hilos) {
			thread.start();
		}
		
		try {
			hiloEntornoEd.join();
			hiloEntornoEP.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
