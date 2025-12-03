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
			cocina.release(3);
			System.out.println("Termina de cocinar");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
