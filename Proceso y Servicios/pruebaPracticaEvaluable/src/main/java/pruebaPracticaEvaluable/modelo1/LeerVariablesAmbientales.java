package pruebaPracticaEvaluable.modelo1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeerVariablesAmbientales {

	// proceso hijo

	private static final String fichero = "src/main/resources/";

	public static void main(String[] args) throws FileNotFoundException {

		//String[] filtro = { "TEMPERATURAS", "HUMEDAD", "PRESION"};

		//String ficheroPedidoProvincias = "src\\main\\resources\\lecturas.txt";
		
		String ficheroPedidoProvincias = args[0];
		String filtro = args[1];
		
		LeerVariablesAmbientales contador = new LeerVariablesAmbientales();
		List<String> resultado = contador.contarVariables(ficheroPedidoProvincias, filtro);
		
		String ficheroResultado = fichero + filtro + ".txt";
		contador.escribeFichero(ficheroResultado, resultado);

	}

	public List<String> contarVariables(String ruta, String filtro) throws FileNotFoundException {

		List<String> listaFiltro = new ArrayList<String>();

		int contador = 0;
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(ruta);
			// Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNextLine()) { // Lectura palabra a palabra
				// Aquí se hará la lectura in.next()
				String linea = in.nextLine().trim();
				String[] partes = linea.split(";");
				

				if(linea.contains(filtro)) {
					listaFiltro.add(linea);
					contador++;
				}
				
			}
			System.out.println(filtro + ":" + contador);

		} finally {
			if (in != null) {
				in.close();
			}
		}
		return listaFiltro;
	}
	
	
	public void escribeFichero(String ruta, List<String> resultado) {

		PrintWriter escribir = null;
		try {
			FileWriter ficheroResultado = new FileWriter(ruta);
			escribir = new PrintWriter(ficheroResultado);
			// para que escriba linea a linea
			
			//escribir.println("Numero de pedidos: " + resultado.size());
			System.out.println("");
			for (String linea : resultado) {
	            escribir.println(linea);
	            
	        }
			
			
		} catch (IOException e) {
				System.out.println("Error, no se ha creado fichero");	
		}
		finally {
			if(escribir!=null) {
				escribir.close();
			}
		}
		
	}

}
