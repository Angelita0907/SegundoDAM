package simulacro;


import java.util.concurrent.Semaphore;

public class Mecanico2 implements Runnable {

	private String nombre;
	private Semaphore repara;
	private Semaphore hayCoche;

	public Mecanico2(String nombre, Semaphore repara, Semaphore hayCoche) {
		super();
		this.nombre = nombre;
		this.repara = repara;
		this.hayCoche = hayCoche;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Semaphore getRepara() {
		return repara;
	}

	public void setRepara(Semaphore repara) {
		this.repara = repara;
	}

	@Override
	public void run() {
		
		while(true) {
		
		try {
			hayCoche.acquire();
			System.out.println(nombre +" reparando");
			Thread.sleep(500);
			System.out.println(nombre + " coche reparado");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			repara.release();
		}
		}

	}

	public Semaphore getHayCoche() {
		return hayCoche;
	}

	public void setHayCoche(Semaphore hayCoche) {
		this.hayCoche = hayCoche;
	}

}

