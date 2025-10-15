package tema1.Boletin2.Ejercicio10;

import java.io.IOException;

public class LanzadorPython {

	private static final String rutaFicheroJava = "C:\\Users\\alumno\\Desktop\\SegundoDAM\\Proceso y Servicios\\tema1\\src\\main\\resources\\fichero.py";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LanzadorPython lanzador = new LanzadorPython();
		lanzador.ejecutaProceso();

	}

	public void ejecutaProceso() {

		String[] comando = {"python", rutaFicheroJava};
		ProcessBuilder pb = new ProcessBuilder(comando);
		
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			/*int exit = p1.waitFor();
			System.out.println(exit);*/
	
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	
}
