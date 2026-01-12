package simulacro;

import java.util.concurrent.Semaphore;

public class Coche implements Runnable {

	private String nombre;
	private Semaphore mecanico;
	private Semaphore hayCoche;

	public Coche(String nombre, Semaphore hayCoche, Semaphore mecanico) {
		super();
		this.nombre = nombre;
		this.mecanico = mecanico;
		this.hayCoche = hayCoche;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Semaphore getMecanico() {
		return mecanico;
	}

	public void setMecanico(Semaphore mecanico) {
		this.mecanico = mecanico;
	}

	public Semaphore getHayCoche() {
		return hayCoche;
	}

	public void setHayCoche(Semaphore hayCoche) {
		this.hayCoche = hayCoche;
	}

	@Override
	public void run() {
		try {
			System.out.println(nombre + " esperando a ser reparado");
			hayCoche.release();
			mecanico.acquire();
			System.out.println(nombre + " reparando coche");
			Thread.sleep(500);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			System.out.println(nombre +" ha sido reparado");
		}
		
	}

}
