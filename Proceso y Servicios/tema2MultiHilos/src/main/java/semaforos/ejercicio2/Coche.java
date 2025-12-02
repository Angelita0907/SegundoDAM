package semaforos.ejercicio2;

public class Coche extends Thread{

	private final Semaforo semaforo;
	
	
	public Coche(Semaforo semaforo, String nombre) {
		super();
		this.semaforo = semaforo;
	}



	@Override
	public void run() {
		semaforo.conexion();
		
	}

}
