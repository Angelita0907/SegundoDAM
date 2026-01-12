package semaforos.ejercicio6;

import java.util.concurrent.Semaphore;

public class Comensal implements Runnable {

	private String nombre;
	private Semaphore cliente;
	private Semaphore menu;

	public Comensal(String nombre, Semaphore cliente, Semaphore menu) {
		super();
		this.nombre = nombre;
		this.cliente = cliente;
		this.menu = menu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Semaphore getCliente() {
		return cliente;
	}

	public void setCliente(Semaphore cliente) {
		this.cliente = cliente;
	}

	public Semaphore getMenu() {
		return menu;
	}

	public void setMenu(Semaphore menu) {
		this.menu = menu;
	}

	@Override
	public void run() {
		try {
			System.out.println(nombre+" tiene hambre");
			cliente.release();
			menu.acquire();
			System.out.println(nombre + " comiendo");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println(nombre+" ha dejado de comer");
		}
		
	}

}
