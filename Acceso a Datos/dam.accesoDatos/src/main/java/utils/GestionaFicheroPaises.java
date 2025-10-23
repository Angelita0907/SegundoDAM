package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tema1.Paises.Pais;

public class GestionaFicheroPaises {
	
	private static final Logger logger = LogManager.getLogger(PokemonAJson.class);


	public List<Pais> leePaisCsv(String ruta) throws FileNotFoundException {
		List<Pais> listaPaises = new ArrayList<>();

		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(ruta);
			// Se crea el flujo
			in = new Scanner(fichero);
			in.nextLine();
			// lee el fichero
			while (in.hasNextLine()) { // Lectura palabra a palabra
				// Aquí se hará la lectura in.next()
				// creo en cada posicion donde va a ir cada parte del fichero para que el json lea el csv y sepa donde va
				String linea = in.nextLine();
				String[] sinEspacios = linea.split(",");
				
				String nombre= sinEspacios[0];
				String continente = sinEspacios[1];
				int poblacion = Integer.parseInt(sinEspacios[2]);
				String[] idioma = sinEspacios[3].split(";");
				String moneda = sinEspacios[4];
				
				Pais p = new Pais(nombre, continente, poblacion, idioma, moneda);
				listaPaises.add(p);
				
				}
			
		} finally {
			if (in != null) {
				in.close();
			}
		}
		logger.info(listaPaises);
		return listaPaises;
	}
	
	
	public void escribePaisJson(List<Pais> p, String ruta)
	{// Convertir el objeto a JSON
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 String json = gson.toJson(p);
		 FileWriter fichero = null;
		 try {
			fichero = new FileWriter(ruta);
			fichero.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println("Error al escribir pais");
				}			
				
			}		
			
		}	   
		 
	}

}
