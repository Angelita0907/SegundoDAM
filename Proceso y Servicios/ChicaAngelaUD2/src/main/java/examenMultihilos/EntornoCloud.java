package examenMultihilos;

import java.util.concurrent.Semaphore;

public class EntornoCloud implements Runnable {

	private TipoEntorno nombreEntorno;
	private Semaphore aforo;

	public EntornoCloud(TipoEntorno nombreEntorno, Semaphore aforo) {
		super();
		this.nombreEntorno = nombreEntorno;
		this.aforo = aforo;
	}

	public TipoEntorno getNombreEntorno() {
		return nombreEntorno;
	}

	public void setNombreEntorno(TipoEntorno nombreEntorno) {
		this.nombreEntorno = nombreEntorno;
	}

	// recurso sincronizado
	public Semaphore getAforo() {
		return aforo;
	}

	public void setAforo(Semaphore aforo) {
		this.aforo = aforo;
	}


	@Override
	public void run() {
		try {

			if (nombreEntorno.equals(TipoEntorno.ED)) {
				aforo.release(20);
				System.out.println(Thread.currentThread().getName() + " ha iniciado sesión en el entorno ED");

			} 
			else if (nombreEntorno.equals(TipoEntorno.EP)) {
				aforo.release(8);
				System.out.println(Thread.currentThread().getName() + " ha iniciado sesión en el entorno EP");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			aforo.release();
			System.out.println("Liberando turno");
		}

	}

}
