package semaforos;

public class Impresora {

	public void imprime(String nombreHilo) {
		System.out.println(nombreHilo + " está imprimiendo");
		
		try {
			// simulamos la operacion de acceso que lleva algo de tiempo
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(nombreHilo+" ha terminado de imprimir");
		
	}
	
}
