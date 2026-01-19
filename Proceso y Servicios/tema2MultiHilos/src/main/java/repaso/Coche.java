package repaso;

public class Coche implements Runnable {

	private Gasolinera semaforo;
	
	public Coche(Gasolinera semaforo, String nombre) {
		super();
		this.semaforo = semaforo;
	}

	public void pago() {
		System.out.println("Pagando con tarjeta ");
	}

	@Override
	public void run() {
		pago();
		semaforo.repostar();
		
	}

}
