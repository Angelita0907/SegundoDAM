package tema1.Ejemplos;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Ejemplo {
	
	private static final Logger logger = LogManager.getLogger(Ejemplo.class);

	public static void main(String[] args) {
		
		String rutaDirectorio = "C:\\Users\\alumno\\Desktop\\SegundoDAM\\Acceso a Datos";
		File directorio = new File(rutaDirectorio);
		// Referencio a un fichero dentro del directorio soraya
		File fichero = new File(directorio, "fichero1.txt");
		//File fichero = new File(directorio, "pepe");
		try {
			boolean creado = fichero.createNewFile(); // Aquí Sí creo fichero
			//boolean creado = fichero.mkdir();
		} catch (IOException e) {

			logger.error("Error al crear fichero:" + e.getMessage());
		}


	}

}
