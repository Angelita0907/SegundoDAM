package pruebaPracticaEvaluable.modelo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerarFicheroPadre {
	
	//padre
	
	private static final String rutaFicheroJava = "src\\main\\java\\pruebaPracticaEvaluable\\modelo\\LeerVariablesAmbientales.java";
	private static final String directorioGenerarClases = "target\\classes";

	public static void main(String[] args) {
		
		GenerarFicheroPadre lanzadorPadre = new GenerarFicheroPadre();
		
		String[] filtro = { "TEMPERATURA", "HUMEDAD", "PRESION"};
		
		String ficheroPedidoProvincias = "src\\main\\resources\\lecturas.txt";
		
		lanzadorPadre.compilaProceso();

		//int totalPedidos = 0;

		// por cada provincia de la lista lanza un proceso que ejecuta las funciones del
		// hijo
		for (String nombreProv : filtro) {

			lanzadorPadre.ejecutaProceso(ficheroPedidoProvincias, nombreProv);

		}

		//System.out.println("Total pedidos: " + totalPedidos);

	}

	
	public void compilaProceso() {

		String[] comando = { "javac", "-d", directorioGenerarClases, rutaFicheroJava };
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

	public int ejecutaProceso(String ruta, String prov) {

		int numero = 0;
		String[] comando1 = { "java", "-cp", directorioGenerarClases, rutaFicheroJava, ruta, prov };

		ProcessBuilder pb = new ProcessBuilder(comando1);

		try {
			// esto se cambia por el buffer
			/*
			 * pb.redirectErrorStream(true); pb.inheritIO();
			 */
			Process p1 = pb.start();
			/*
			 * int exit = p1.waitFor(); System.out.println(exit);
			 */

			// lee el padre lo que diga el hijo por consola
			BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));

			// porsi ocurre un error en el hijo el padre pueda leerlo
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p1.getErrorStream()));

			String linea = reader.readLine();
			// porsi guarda mas de una linea
			while (linea != null) {
				System.out.println(linea);
				//String[] porpuntos = linea.split(":");
				linea = reader.readLine();
				//coge la posicion donde esta el numero
				//numero = Integer.parseInt(porpuntos[1]);
			}

			// apartado 3 dividir por puntos cogiendo el resultado de cada pronvincia

		} catch (IOException e) {
			e.printStackTrace();

		}
		return numero;

	}

}
