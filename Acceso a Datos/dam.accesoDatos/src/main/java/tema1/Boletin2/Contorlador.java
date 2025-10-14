package tema1.Boletin2;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Contorlador {
	
	private static final Logger logger = LogManager.getLogger(Contorlador.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ruta1 ="C:\\Users\\alumno\\Desktop\\SegundoDAM\\Acceso a Datos\\boletin2\\carpeta1";
		String ruta2 ="C:\\Users\\alumno\\Desktop\\SegundoDAM\\Acceso a Datos\\boletin2\\carpeta2";

		File directorio1 = new File(ruta1);
		File directorio2 = new File(ruta2);
		
		
		
	}

}
