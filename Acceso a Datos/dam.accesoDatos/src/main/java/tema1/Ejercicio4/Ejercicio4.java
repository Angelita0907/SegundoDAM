package tema1.Ejercicio4;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tema1.Ejercicio3.Ejercicio3;

public class Ejercicio4 {
	
	private static final Logger logger = LogManager.getLogger(Ejercicio3.class);

	public static void main(String[] args) {
		
		Ejercicio4 e4 = new Ejercicio4();
		File archivo = new File("C:\\Users\\alumno\\Desktop\\SegundoDAM\\Acceso a Datos\\fichero.txt");
		e4.getProRecursive(archivo);
		
	}
	/*mira un fichero y lista lo que haya vuelve a mirar 
	el siguiente fichero que hay dentro del mismo y muestra el contenido*/
	public void getProRecursive(File padre) {
		boolean existe = padre.exists();
		if(existe && padre.isDirectory()) {
			File [] listaFicheros = padre.listFiles();
			for (File f : listaFicheros) {
				if(f.isFile()){
					logger.info(f.getName());
				}
				else {
					this.getProRecursive(f);
				}
			}
		}
		else {
			logger.info(padre.getName());
		}
		
	}
	
}
