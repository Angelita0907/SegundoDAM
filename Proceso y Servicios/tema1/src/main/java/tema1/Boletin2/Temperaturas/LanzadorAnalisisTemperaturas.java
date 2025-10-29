package tema1.Boletin2.Temperaturas;

import java.io.IOException;

//papa
public class LanzadorAnalisisTemperaturas {
	
	private static final String rutaFicheroJava = "src\\main\\java\\tema1\\Boletin2\\Temperaturas\\AnalizadorTemperaturas.java" ;
	private static final String directorioGenerarClases = "target\\classes";
	//private static final String NOMBRE_CLASE_HIJA = "tema1.Boletin2.Temperaturas.AnalizadorTemperaturas";

	public static void main(String[] args) {
		
		LanzadorAnalisisTemperaturas lanzadorTemp = new LanzadorAnalisisTemperaturas();
		
		int[] umbrales = {10, 20, 25, 30, 35};
		String fihceroTemperatutas = "src\\main\\resources\\datos.txt";
		
		lanzadorTemp.compilaProceso();
		
		for (int temp : umbrales) {
			//busque para convertir int a String y poder usarlo en la funcion
			lanzadorTemp.ejecutaProceso(fihceroTemperatutas, String.valueOf(temp));
		}
		
		
	}
	
	public void compilaProceso() {

		String[] comando = { "javac", "-d",directorioGenerarClases ,rutaFicheroJava};
		ProcessBuilder pb = new ProcessBuilder(comando);
		
		try {
			// para la comunicacion entre proceso padre e hijo
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			int exit = p1.waitFor();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ejecutaProceso(String ruta, String palabra) {
	
		String[] comando1 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,ruta, palabra};

		ProcessBuilder pb = new ProcessBuilder(comando1);

		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			/*int exit = p1.waitFor();
			System.out.println(exit);*/
	
		} catch (IOException e) {
			e.printStackTrace();

	}

	}
}
