package contador;

import java.io.IOException;

public class LanzadorContadorPalabras {
	//padre 
	private static final String rutaFicheroJava = "src\\main\\java\\contador\\ContadorPalabras.java" ;
	private static final String directorioGenerarClases = "target\\classes";
	
	public static void main(String[] args) {
		
		// asi comunicamos con el proceso hijo (contador palabras) para crear
		// procesos en el padre
		
		LanzadorContadorPalabras lanzarPalabras = new LanzadorContadorPalabras();
		
		lanzarPalabras.ejecutaProceso("fichero.txt", "es");
		lanzarPalabras.ejecutaProceso("fichero.txt", "Java");
		lanzarPalabras.ejecutaProceso("fichero.txt", "y");

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

	public void ejecutaProceso(String ruta, String palabra) {
	
		String[] comando1 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,ruta, palabra};

		//cambiar para hacerlo llamando al jar
		ProcessBuilder pb = new ProcessBuilder(comando1);

		
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			int exit = p1.waitFor();
			
			/*int exit = p1.waitFor();
			System.out.println(exit);*/
	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
