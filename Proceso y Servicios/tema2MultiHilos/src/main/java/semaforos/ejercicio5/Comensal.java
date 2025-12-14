package semaforos.ejercicio5;

import java.util.concurrent.Semaphore;

public class Comensal implements Runnable {
	
	
	private Semaphore comida;
	
	public Comensal(Semaphore comida) {
		super();
		this.comida = comida;
	}


	@Override
	public void run() {
		
		try {
			// toman el turno para esprear la comida
			// cuando el consicenro hace release 
			// sueltan el testigo para que lo coja el siguiente
			comida.acquire();
			System.out.println("Empieza a comer");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
