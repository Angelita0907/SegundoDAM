package contador;

import java.io.IOException;

public class LanzadorContadorPalabras {
	
	private static final String rutaFicheroJava = "src\\main\\java\\contador\\ContadorPalabras.java" ;
	private static final String directorioGenerarClases = "target\\classes";
	
	public static void main(String[] args) {
		
		// asi comunicamos con el proceso hijo (contador palabras) para crear
		// procesos en el padre
		
		LanzadorContadorPalabras lanzarPalabras = new LanzadorContadorPalabras();
		
		lanzarPalabras.ejecutaProceso();

	}
	
	public void compilaProceso() {

		String[] comando = { "javac", "-d", rutaFicheroJava, "ContadorPalabras.java"};
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
	
		String[] comando1 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,"fichero.txt" ,"es"};
		String[] comando2 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,"fichero.txt" ,"Java"};
		String[] comando3 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,"fichero.txt" ,"y"};
		//cambiar para hacerlo llamando al jar
		ProcessBuilder pb = new ProcessBuilder(comando1);
		ProcessBuilder pb2 = new ProcessBuilder(comando2);
		ProcessBuilder pb3 = new ProcessBuilder(comando3);
		
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			p1 = pb.start();
			Process p2 = pb2.start();
			p2 = pb2.start();
			Process p3 = pb.start();
			p3 = pb3.start();
			
			/*int exit = p1.waitFor();
			System.out.println(exit);*/
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
