package utils;

import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import tema1.PokemonJson.Pokemon;

public class UtilidadPokemonCsv {
	
	public void escribePokemon(Pokemon pokemon, String ruta)
	{// Convertir el objeto a JSON
		 Gson gson = new Gson();
		 String json = gson.toJson(pokemon);
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
					System.out.println("Error al escribir pokemon");
				}			
			}		
		}	  
	}


}
