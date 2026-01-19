package repaso;

import java.util.concurrent.Semaphore;

public class Gasolinera {
	
	private Semaphore semaforo;

	public Gasolinera(int numRepostar) {
		semaforo = new Semaphore(numRepostar);
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
			System.out.println(Thread.currentThread().getName() + "está repostando");
			
			Thread.sleep(5000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			semaforo.release();
			System.out.println(Thread.currentThread().getName() + "libera surtidor");
		}
	}

}
