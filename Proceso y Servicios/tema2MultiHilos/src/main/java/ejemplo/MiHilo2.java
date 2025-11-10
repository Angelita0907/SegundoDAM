package ejemplo;

public class MiHilo2 implements Runnable {
	private String nombreHilo;
	
	public MiHilo2(String nombre) {
		super();
	}
	
	// con runnable
	@Override
	public void run() {
		Thread.currentThread().setName(nombreHilo);
		System.out.println("Ejecutando Hilo:"+Thread.currentThread().getName());		
	}
}
