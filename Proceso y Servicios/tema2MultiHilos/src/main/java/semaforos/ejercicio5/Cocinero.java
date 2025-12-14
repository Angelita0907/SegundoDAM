package semaforos.ejercicio5;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable{
	
	private String nombre;
	private Semaphore cocina;
	
	
	public Cocinero(String nombre, Semaphore cocina) {
		super();
		this.nombre = nombre;
		this.cocina = cocina;
	}

	@Override
	public void run() {

		try {
			// le damos de comer a 3 comensales, notifica a los comensales
			cocina.release(3);
			System.out.println("Termina de cocinar");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
