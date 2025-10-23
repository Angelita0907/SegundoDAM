package tema1.Paises;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tema1.PokemonJson.GestionaPokemons;
import utils.GestionaFicheroPaises;

public class GestionaPais {
	
	private static final Logger logger = LogManager.getLogger(GestionaPokemons.class);

	public static void main(String[] args) {
		
		GestionaFicheroPaises paises = new GestionaFicheroPaises();
		
		String rutaCsv = "src\\main\\resources\\paises.csv";
		String rutaJson = "src\\\\main\\\\resources\\\\paises.json";
		
		try {
			List<Pais> listapaises = paises.leePaisCsv(rutaCsv);
			paises.escribePaisJson(listapaises, rutaJson);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
