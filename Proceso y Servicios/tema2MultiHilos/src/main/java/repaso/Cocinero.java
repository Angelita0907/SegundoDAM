package repaso;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable {

	private String nombre;
	private Semaphore plato;

	public Cocinero(String nombre, Semaphore plato) {
		super();
		this.setNombre(nombre);
		this.plato = plato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Semaphore getPlato() {
		return plato;
	}

	public void setPlato(Semaphore plato) {
		this.plato = plato;
	}

	@Override
	public void run() {
		// libera 3 platos 
		plato.release(3);
		System.out.println("Cocinero acaba de cocinar");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
