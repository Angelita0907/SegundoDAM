package tema1.Simulacion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidosProvincia {

	//Ejercicio logistica pedidos amazon --> hijo
	
	private static final String fichero = "src/main/resources/";

	public static void main(String[] args) throws FileNotFoundException {
		
		String ruta = args[0];
		String prov = args[1];
		
		PedidosProvincia contador = new PedidosProvincia();
		List<String> resultado = contador.contarProvincia(ruta, prov);

		String ficheroResultado = fichero + prov + ".txt";
		contador.escribeFichero(ficheroResultado, resultado);
		
	}
	
	public List<String> contarProvincia(String ruta, String prov) throws FileNotFoundException {
		
		List<String> pedidosProvincia = new ArrayList<String>();
		
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
				String[] partes = linea.split("#");
				if(partes.length > 5) {
			
					String provincia = partes[5].trim();
					if(provincia.equalsIgnoreCase(prov)) {
						pedidosProvincia.add(linea);
						contador ++;
					}
					
				}
				

			}
			System.out.println(prov + ":"+ contador);
			
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return pedidosProvincia;
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
