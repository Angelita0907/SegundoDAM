package tema1.Ejercicio3;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejercicio3 {
	
	private static final Logger logger = LogManager.getLogger(Ejercicio3.class);

	
	public static void main(String[] args) {
		
		String rutaDirectorio = "C:\\Users\\Usuario\\OneDrive\\Desktop\\SegundoDAM\\Acceso a Datos";
		File directorio = new File(rutaDirectorio);
		
		File carpeta = new File(rutaDirectorio, "miDirectorio");

			try {
				boolean secreo = carpeta.mkdir();
				
				File fichero1 = new File(carpeta, "fichero1Ejercicio2.txt");
				File fichero2 = new File(carpeta, "fichero2Ejercicio2.txt");
				
				boolean creado = fichero1.createNewFile();
				boolean lectura = fichero1.setReadOnly();
				
				boolean creado2 = fichero2.createNewFile();
				
				logger.info(fichero1.canRead());
				logger.info(fichero1.canWrite());
				
				//fichero2.delete();
				
			} catch (IOException e) {

				logger.error("Error al crear fichero:" + e.getMessage());
			} 

		
	}
	
}
