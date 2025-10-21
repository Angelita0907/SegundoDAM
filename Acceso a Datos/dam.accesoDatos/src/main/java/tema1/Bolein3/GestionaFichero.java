package tema1.Bolein3;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestionaFichero {

	private static final Logger logger = LogManager.getLogger(LecturaFichero.class);
	
	public static void main(String[] args) {
		
		String archivo ="C:\\Users\\alumno\\Desktop\\SegundoDAM\\Acceso a Datos\\fichero.txt";


		LecturaFichero lectura = new LecturaFichero();
		
		try {
			lectura.muestraContenidoFich(archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("No se encuentra fichero: "+ archivo);
		}
		
		
		
	}

}
