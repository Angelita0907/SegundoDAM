package tema1;

import java.io.IOException;

public class Lanzador {
	
	private static final String directorioGenerarClases = "target\\classes" ;

	private static final String rutaFicheroJava = "src\\main\\java\\tema1\\";
	private static final String  rutaClase = "target\\classes\\tema1" ;
	
	public static void main(String[] args) {
		//Esta clase lanzador hace dos cosas:
		// compilar una clase
		//Ejecutar la clase generada
		
		Lanzador lanzador = new Lanzador();
		lanzador.ejecutaProcesoCompila();
		lanzador.ejecutaProceso();
		
	}
	
	public void ejecutaProcesoCompila() {

			String[] comando = { "javac", "-d", directorioGenerarClases, 
					rutaFicheroJava + "Gestiona.java"};
			ProcessBuilder pb = new ProcessBuilder(comando);
			
			try {
				// para la comunicacion entre proceso padre e hijo
				pb.redirectErrorStream(true);
				pb.inheritIO();
				Process p1 = pb.start();
		
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void ejecutaProceso() {

		String[] comando2 = {"java", "-cp", directorioGenerarClases, "tema1.Gestiona"};
		ProcessBuilder pb = new ProcessBuilder(comando2);
		
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			int exit = p1.waitFor();
			System.out.println(exit);
	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	
}
