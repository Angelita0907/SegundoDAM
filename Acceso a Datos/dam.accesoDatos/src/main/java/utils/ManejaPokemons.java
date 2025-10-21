package utils;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import tema1.PokemonJson.Pokemon;

public class ManejaPokemons {

private static final Logger logger = LogManager.getLogger(ManejaPokemons.class);
	
	public void leePokemon(String rutaFichero) {
		try {
		  Gson gson = new Gson();
		  FileReader fichero = new FileReader(rutaFichero);
		  // Leer el archivo JSON y convertirlo a un objeto Empleado
		  Pokemon[] pokemonArray = gson.fromJson(fichero,Pokemon[].class);
			List<Pokemon> pokemons = Arrays.asList(pokemonArray);
			logger.info(pokemons);
		} catch (Exception e) {
			logger.debug("Error al leer empleados"+e.getMessage());
		}	}
	
}
