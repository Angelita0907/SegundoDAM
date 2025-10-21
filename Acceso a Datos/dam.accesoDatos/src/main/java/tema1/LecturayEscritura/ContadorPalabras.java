package tema1.LecturayEscritura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class ContadorPalabras {
	
	private static final Logger logger = LogManager.getLogger(ContadorPalabras.class);
	
	public int contarPalabras(String palabra, String ruta) throws FileNotFoundException {
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
				String linea = in.nextLine();
				String[] sinEspacios = linea.split(" ");
				for(String letra : sinEspacios) {
					String palabraES = palabra.substring(0,1).toUpperCase();
					if(letra.equalsIgnoreCase(palabra)) {
						contador +=1;
					}
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return contador;
	}
	
	public void escribeFichero(String ruta, int numero) {
		
		PrintWriter escribir = null;
		try {
			FileWriter ficheroResultado = new FileWriter(ruta);
			escribir = new PrintWriter(ficheroResultado);
			
			escribir.printf("Numero de veces: %d", numero);
			
			
		} catch (IOException e) {
				System.out.println("Error, no se ha creado fichero");	
		}
		finally {
			if(escribir!=null) {
				escribir.close();
			}
		}
		
	}
	
	/*
	public List<String> cargafichero(String ruta) {
		String[] cadenas = ruta.split(" ");
		List<String> lista = new ArrayList<String>();
		for (int i = 1; i < cadenas.length; i++) {
			lista.add(cadenas[i]);
		}
		return lista;

	}
*/
}
