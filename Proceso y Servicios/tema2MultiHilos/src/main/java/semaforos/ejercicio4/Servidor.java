package semaforos.ejercicio4;

import java.util.concurrent.Semaphore;

public class Servidor {
	
	private Semaphore semaservidor;

	public Servidor(int numConexiones) {
		super();
		semaservidor = new Semaphore(numConexiones);
	}

	public Semaphore getSemaforo() {
		return semaservidor;
	}

	public void setSemaforo(Semaphore semaforo) {
		this.semaservidor = semaforo;
	}
	
	public void realizaRequest() {
		
		try {
			semaservidor.acquire();
			System.out.println(Thread.currentThread().getName() +" usando servidor");
			
			Thread.sleep(2000);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			semaservidor.release();
			System.out.println(Thread.currentThread().getName()+" liberando petición");
		}
		
	}

}
