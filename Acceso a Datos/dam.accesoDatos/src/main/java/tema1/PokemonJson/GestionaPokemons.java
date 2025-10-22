package tema1.PokemonJson;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tema1.Json.Ejemplo.GestionaEmpleadoJson;
import utils.ManejaPokemons;
import utils.UtilidadPokemonCsv;

public class GestionaPokemons {

	private static final Logger logger = LogManager.getLogger(GestionaEmpleadoJson.class);
	
	public static void main(String[] args) {

		List<Pokemon> listaPokemons = new ArrayList<Pokemon>();
		
		ManejaPokemons pokemons = new ManejaPokemons();
		UtilidadPokemonCsv escribirP = new UtilidadPokemonCsv();

		String ruta = "src\\main\\resources\\pokemon.json";
		
		pokemons.leePokemon(ruta);
		//terminar
		escribirP.escribePokemon(null, ruta);
		
		
	}

}
