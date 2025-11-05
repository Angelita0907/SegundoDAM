package pruebaPracticaEvaluable.modelo2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeerVariablesAmbientales2 {

	// proceso hijo

	private static final String fichero = "src/main/resources/";

	public static void main(String[] args) throws FileNotFoundException {

		//String[] filtro = { "TEMPERATURAS", "HUMEDAD", "PRESION"};

		//String ficheroPedidoProvincias = "src\\main\\resources\\lecturas.txt";
		
		String ficheroPedidoProvincias = args[0];
		String filtro = args[1];
		
		LeerVariablesAmbientales2 contador = new LeerVariablesAmbientales2();
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

			float media = 0;
			int total = listaFiltro.size();
			int num = 0;
			for (String string : listaFiltro) {
				String [] partes2 = string.split(":");
				num = Integer.parseInt(partes2[1]) + num;
				media = num/total;
			}
		
			
			System.out.println(filtro + ": Num. Registros: " + contador + " Media: "+ media);

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
