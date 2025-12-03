package semaforos.ejercicio2y3;

import java.util.concurrent.Semaphore;

public class Semaforo {
	
	private Semaphore semaforo;

	public Semaforo(int numConexiones) {
		super();
		semaforo = new Semaphore(numConexiones);
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	
	public void repostar() {
		
		try {
			semaforo.acquire();
			System.out.println(Thread.currentThread().getName()+" está repostando");
			
			Thread.sleep(5000);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			semaforo.release();
			System.out.println(Thread.currentThread().getName()+" libera surtidor");
		}
		
	}

}
