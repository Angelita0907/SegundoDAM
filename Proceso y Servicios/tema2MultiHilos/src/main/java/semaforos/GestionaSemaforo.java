package semaforos;

public class GestionaSemaforo {
	public static void main(String[] args) {
		SemaforoBinario semaforo = new SemaforoBinario();
		Impresora impresora = new Impresora();
		System.out.println("E");
		// Creamos varios usuarios que intentarán acceder al recurso compartido
		Thread usuario1 = new Thread(new HiloSemaforoBinario(semaforo, impresora, "Usuario 1"));
		Thread usuario2 = new Thread(new HiloSemaforoBinario(semaforo, impresora, "Usuario 2"));
		Thread usuario3 = new Thread(new HiloSemaforoBinario(semaforo, impresora, "Usuario 3"));
		
		usuario1.setPriority(Thread.MAX_PRIORITY);
		
		usuario2.setPriority(Thread.MAX_PRIORITY);

		usuario3.setPriority(Thread.MAX_PRIORITY);

		// Iniciamos los hilos
		usuario1.start();
		usuario2.start();
		usuario3.start();
	}

}
