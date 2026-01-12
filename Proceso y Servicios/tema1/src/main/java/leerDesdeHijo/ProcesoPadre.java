package leerDesdeHijo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcesoPadre {
	// en vez de pasarle un fichero le pasamos la clase como tal
	private static final String rutaFicheroJava = "src\\main\\java\\leerDesdeHijo\\ProcesoHijo.java" ;
	private static final String directorioGenerarClases = "target\\classes";
	

	public static void main(String[] args) {
		ProcesoPadre padre = new ProcesoPadre();
		ProcesoHijo hijo = new ProcesoHijo();
		
		padre.compilaProceso();
		padre.ejecutaProceso();

	}
	
	public void compilaProceso() {

		String[] comando = { "javac", "-d",directorioGenerarClases ,rutaFicheroJava};
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
	
		String[] comando1 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava};
		ProcessBuilder pb = new ProcessBuilder(comando1);
		
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			
			int exit = p1.waitFor();
			System.out.println(exit);
			
			if(exit != 0) {
				BufferedReader errorReader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
				String errorLinea = errorReader.readLine();
				
				while(errorLinea != null) {
					System.out.println("Error padrte: "+ errorLinea);
					errorLinea = errorReader.readLine();
				}
				
			}
			
			else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
				String linea = reader.readLine();
				
				while(linea != null) {
					System.out.println("Padre: "+linea);
					linea = reader.readLine();
					// lee la siguiente linea
				}
					
			}
			
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
