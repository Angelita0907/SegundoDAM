package tema1.Ejercicio1;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejercicio1 {
	
	private static final Logger logger = LogManager.getLogger(Ejercicio1.class);

	public static void main(String[] args) {
		
		String rutaDirectorio = "C:\\Users\\alumno\\Desktop\\SegundoDAM\\Acceso a Datos";
		File directorio = new File(rutaDirectorio); //tiene que ser un directorio
		
		String[] archivos = directorio.list(); 
		
		if (directorio.exists() && directorio.isDirectory()) {
	          for(File f : directorio.listFiles())//Listamos el contenido del directorio
	          {
	       	   logger.info(f.getName());
	          }
	       } else {
	    	   logger.info("El directorio no existe o no es un directorio.");
	       }

		
	}

}
