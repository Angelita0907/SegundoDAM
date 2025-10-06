package tema1;

import java.io.IOException;

public class Lanzador {
	
	private static final String directorioGenerarClases = "C:\\Users\\alumno\\Desktop\\SegundoDAM\\Proceso y Servicios\\tema1\\target" ;

	private static final String rutaFicheroJava = "C:\\Users\\alumno\\Desktop\\SegundoDAM\\Proceso y Servicios\\tema1\\src\\main\\java";
	private static final String  rutaClase = "C:\\Users\\alumno\\Desktop\\SegundoDAM\\Proceso y Servicios\\tema1\\target\\classes\\tema1\\Gestiona.class" ;
	
	public static void main(String[] args) {
		//Esta clase lanzador hace dos cosas:
		// compilar una clase
		//Ejecutar la clase generada
		
		Lanzador lanzador = new Lanzador();
		lanzador.ejecutaProcesoCompila();
		
		
	}
	
	public void ejecutaProcesoCompila() {

			String[] comando = { "javac", "-d", directorioGenerarClases, 
					rutaFicheroJava + "tema1\\Gestiona.java"};
			ProcessBuilder pb = new ProcessBuilder(comando);
			
			try {
				Process p1 = pb.start();
		
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void ejecutaProcesoCompila2() {

		String[] comando2 = {"java", "-cp", "target/classes", "C:\\Users\\alumno\\Desktop\\SegundoDAM\\Proceso y Servicios\\tema1\\target\\classes\\tema1\\Gestiona.class"};
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
