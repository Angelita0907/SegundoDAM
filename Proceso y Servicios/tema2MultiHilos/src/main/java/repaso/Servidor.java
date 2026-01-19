package repaso;

import java.util.concurrent.Semaphore;

public class Servidor {

	private Semaphore semaforo;

	public Servidor(int peticiones) {
		semaforo = new Semaphore(peticiones);
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	
	public void realizaRequest() {
		
		try {
			semaforo.acquire();
			System.out.println(Thread.currentThread().getName() + " entra al servidor");
			
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaforo.release();
			System.out.println(Thread.currentThread().getName() + " sale del servidor");
		}
	}
	
}
