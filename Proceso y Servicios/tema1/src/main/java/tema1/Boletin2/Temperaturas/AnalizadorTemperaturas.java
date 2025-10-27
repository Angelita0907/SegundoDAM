package tema1.Boletin2.Temperaturas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class AnalizadorTemperaturas {
	
	private static final String fichero = "src/main/resources/";

	public static void main(String[] args) throws FileNotFoundException {
		
		String ruta = fichero + args[0];
		int temp = Integer.parseInt(args[1]);
		
		AnalizadorTemperaturas contador = new AnalizadorTemperaturas();
		System.out.println(contador.contarTemperatura(ruta, temp));

	}
	
	public int contarTemperatura(String ruta, int temp) throws FileNotFoundException {
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
				int umbral = Integer.parseInt(linea);
				if(umbral > temp) {
					contador +=1;	
				}
				
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return contador;
	}
	
	public void escribeFichero(String ruta, int temperatura) {
		
		PrintWriter escribir = null;
		try {
			FileWriter ficheroResultado = new FileWriter(ruta);
			escribir = new PrintWriter(ficheroResultado);
			
			escribir.printf("Numero de veces: %d", temperatura);
			
			
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
