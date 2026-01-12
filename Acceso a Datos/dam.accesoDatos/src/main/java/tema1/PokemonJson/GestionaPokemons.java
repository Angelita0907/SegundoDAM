package tema1.PokemonJson;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.PokemonAJson;
import utils.EscribirPokemonCsv;

public class GestionaPokemons {

	private static final Logger logger = LogManager.getLogger(GestionaPokemons.class);
	
	public static void main(String[] args) {


		//ManejaPokemons manejaPokemonJson = new ManejaPokemons();
		EscribirPokemonCsv escribirP = new EscribirPokemonCsv();
		PokemonAJson leerPokemon = new PokemonAJson();
		//primer ejercicio leer json
		String ruta = "src\\main\\resources\\pokemon.json";
		
		//para escrbir json a csv
		String rutaCsv = "src\\main\\resources\\pokemon.csv";
		
		//Ejercicio de pasar cvs a json
		String listaCsv = "src\\main\\resources\\listaPokemons.csv";
		String listaJson = "src\\main\\resources\\ListaPokemon.json";
		
		//Pokemon p = manejaPokemonJson.leePokemon(ruta);
		
		//escribirP.escribePokemon(p, rutaCsv);
		
		try {
			List<Pokemon> pokemos = leerPokemon.leePokemoCsv(listaCsv);
			leerPokemon.escribePokemonJson(pokemos, listaJson);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
