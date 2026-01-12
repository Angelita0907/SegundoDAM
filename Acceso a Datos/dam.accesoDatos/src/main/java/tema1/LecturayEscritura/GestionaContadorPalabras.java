package tema1.LecturayEscritura;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tema1.Bolein3.GestionaPersonas;

public class GestionaContadorPalabras {
	
	private static final Logger logger = LogManager.getLogger(GestionaPersonas.class);

	public static void main(String[] args) {
		
		ContadorPalabras contar = new ContadorPalabras();
		String palabra = "es";
		String fichero =  "src\\main\\resources\\fichero.txt";
		String ruta = "src\\main\\resources\\";
		
		try {
			
			logger.info("Número de veces: "+ contar.contarPalabras(palabra, fichero));
			// tengo que poner la ruta y el nombre del fichero para crearlo
			contar.escribeFichero(ruta+"es.txt", contar.contarPalabras(palabra, fichero));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("Error");
		}

	}

}
