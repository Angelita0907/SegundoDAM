<<<<<<< HEAD
package examenMultihilos;

import java.util.concurrent.Semaphore;

public class Desarrollador implements Runnable {

	private String nombreD;
	private Semaphore hayEntorno;

	public Desarrollador(String nombreD, Semaphore entorno) {
		super();
		this.nombreD = nombreD;
		this.hayEntorno = entorno;
	}

	public String getNombreD() {
		return nombreD;
	}

	public void setNombreD(String nombreD) {
		this.nombreD = nombreD;
	}

	public Semaphore getEntorno() {
		return hayEntorno;
	}

	public void setEntorno(Semaphore entorno) {
		this.hayEntorno = entorno;
	}

	@Override
	public void run() {
		try {

			System.out.println(nombreD + " esperando turno");
			hayEntorno.acquire();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println(nombreD +" ha iniciado sesion en el entorno");
			hayEntorno.release();
		}

	}

}
=======
package examenMultihilos;

import java.util.concurrent.Semaphore;

public class Desarrollador implements Runnable {

	private String nombreD;
	private Semaphore hayEntorno;

	public Desarrollador(String nombreD, Semaphore entorno) {
		super();
		this.nombreD = nombreD;
		this.hayEntorno = entorno;
	}

	public String getNombreD() {
		return nombreD;
	}

	public void setNombreD(String nombreD) {
		this.nombreD = nombreD;
	}

	public Semaphore getEntorno() {
		return hayEntorno;
	}

	public void setEntorno(Semaphore entorno) {
		this.hayEntorno = entorno;
	}

	@Override
	public void run() {
		try {

			System.out.println(nombreD + " esperando turno");
			hayEntorno.acquire();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println(nombreD +" ha iniciado sesion en el entorno");
			hayEntorno.release();
		}

	}

}
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
