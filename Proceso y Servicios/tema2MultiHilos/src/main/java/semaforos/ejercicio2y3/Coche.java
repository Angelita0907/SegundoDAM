package semaforos.ejercicio2y3;

public class Coche implements Runnable{

	private final Semaforo semaforo;
	
	
	public Coche(Semaforo semaforo, String nombre) {
		super();
		this.semaforo = semaforo;
	}
	
	public void pagar() {
		System.out.println("Pagando con tarjeta :)");
	}

	@Override
	public void run() {
		pagar();
		semaforo.repostar();
		
	}

}
