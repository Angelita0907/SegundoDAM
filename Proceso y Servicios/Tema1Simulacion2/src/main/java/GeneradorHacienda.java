import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GeneradorHacienda {

	// padre

	private static final String hijo1 = "src/main/java/SepararPorAN.java";
	private static final String hijo2 = "src/main/java/SepararPorDNI.java";
	private static final String directorioGenerarClases = "target/classes";

	public static void main(String[] args) {

		GeneradorHacienda lanzadorGestion = new GeneradorHacienda();

		String fihceroDatos = "src/main/resources/datos.txt";

		// segun el ejercicio he creado dos clases para cada proceso hijo y que no
		// hubiese confusion

		lanzadorGestion.compilaProceso(hijo1);
		lanzadorGestion.compilaProceso(hijo2);

		int dnisTratados = lanzadorGestion.ejecutaProceso("SepararPorDNI", fihceroDatos);
		System.out.println("DNIs: " + dnisTratados);

		int nssTratados = lanzadorGestion.ejecutaProceso("SepararPorAN", fihceroDatos);
		System.out.println("NSS: " + nssTratados);
		
		lanzadorGestion.escribirResumen(dnisTratados, nssTratados);
		
		
	}

	public void compilaProceso(String ruta) {

		String[] comando1 = { "javac", "-d", directorioGenerarClases, ruta };

		ProcessBuilder pb = new ProcessBuilder(comando1);

		try {
			// para la comunicacion entre proceso padre e hijo
			pb.redirectErrorStream(true);
			pb.inheritIO();

			Process p1 = pb.start();

			// int exit = p1.waitFor();
			p1.waitFor();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int ejecutaProceso(String clase, String ruta) {

		int contador = 0;
		String[] comando1 = { "java", "-cp", directorioGenerarClases, clase, ruta };
		ProcessBuilder pb = new ProcessBuilder(comando1);

		try {
			Process p = pb.start();

			// Capturamos el contador que el hijo debe imprimir
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String linea = reader.readLine();
			//lee la linea del total de dni y nss
			while (linea != null) {
				System.out.println(linea);
				String[] porpuntos = linea.split(":");
				linea = reader.readLine();
				//coge la posicion donde esta el numero
				contador = Integer.parseInt(porpuntos[1]);
			}
			
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();

		}
		return contador;

	}

	public void escribirResumen(int dni, int nss) {
		PrintWriter escribir = null;
		try {
			FileWriter ficheroResultado = new FileWriter("src/main/resources/resumen.txt");
			escribir = new PrintWriter(ficheroResultado);
			// para que escriba linea a linea

				escribir.println("Número total de contribuyentes tratados: ");
				escribir.println("Dnis: "+ dni);
				escribir.println("NSSs: "+ nss);
	

		} catch (IOException e) {
			System.out.println("Error, no se ha creado fichero");
		} finally {
			if (escribir != null) {
				escribir.close();
			}
		}
	}

}
