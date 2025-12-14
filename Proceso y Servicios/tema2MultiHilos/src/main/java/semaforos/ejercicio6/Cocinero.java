package semaforos.ejercicio6;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable{
	
	private String nombre;
	private Semaphore menu;
	private Semaphore cliente;
	
	
	public Cocinero(String nombre, Semaphore menu,  Semaphore cliente) {
		super();
		this.setNombre(nombre);
		this.menu = menu;
		this.cliente = cliente;
	}

	@Override
	public void run() {

		while (true) {
			try {
				cliente.acquire();
				System.out.println(nombre+" cocinando");
				Thread.sleep(4000);
				System.out.println(nombre+ " ha dejado de cocinar");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				menu.release();
			}
		}
		
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
	
	

}
