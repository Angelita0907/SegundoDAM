package semaforos;

public class HiloSemaforoBinario implements Runnable {

	private final SemaforoBinario semaforo;
	private final Impresora impresora;
	private final String nombre;

	public HiloSemaforoBinario (SemaforoBinario semaforo, Impresora impresora, String nombre) {
	       this.semaforo = semaforo;
	       this.impresora = impresora;
	       this.nombre = nombre;
	   }


	@Override
	public void run() {
		try {
			semaforo.adquirir();
			System.out.println(nombre + " ha adquirido el semáforo.");
			impresora.imprime(nombre);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.liberar();
			System.out.println(nombre + " ha liberado el semáforo.");
		}
	}

}
