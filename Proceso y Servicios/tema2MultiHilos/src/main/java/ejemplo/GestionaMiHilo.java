package ejemplo;

public class GestionaMiHilo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*	MiHilo1
	 * MiHilo hilo1 = new MiHilo("Hilo1");
		System.out.println(hilo1.getState());
		hilo1.start();
		
		MiHilo hilo2 = new MiHilo("Hilo2");
		System.out.println(hilo2.getState());
		hilo2.start();
		
		
		System.out.println("Estoy en el padre");
		*/
		
	// Mi Hilo 2
		
		MiHilo2 hilo1 = new MiHilo2("Hilo 1");
		
		MiHilo2 hilo2 = new MiHilo2("Hilo 2");
		System.out.println("Hilo principal terminado");

		
	}

}
