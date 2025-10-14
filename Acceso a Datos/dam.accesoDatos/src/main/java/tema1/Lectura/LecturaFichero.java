package tema1.Lectura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LecturaFichero {

	private static final Logger logger = LogManager.getLogger(LecturaFichero.class);

	void muestraContenidoFich(String rutaYNombre) throws FileNotFoundException {
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(rutaYNombre);
			//Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNext()) { //Lectura palabra a palabra
				// Aquí se hará la lectura in.next()
				logger.info(in.nextLine());
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}


}
