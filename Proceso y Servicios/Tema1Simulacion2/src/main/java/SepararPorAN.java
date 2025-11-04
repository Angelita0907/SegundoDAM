import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SepararPorAN {

	private static final String fichero = "src/main/resources/";

	public static void main(String[] args) throws FileNotFoundException {

		String ruta = args[0];

		SepararPorAN contador = new SepararPorAN();
		//List<String> resultado = contador.contarNSS(fichero+"/datos.txt");
		List<String> resultado = contador.contarNSS(ruta);
		

		// este es el nombre del fichero
		//String ficheroResultado = fichero + ".txt";
		//directamente le paso el nombr de como quiero que se llame con su lista de elemntos
		String ficheroResultado = fichero + "NSSs.txt";
		contador.escribeFichero(ficheroResultado, resultado);

	}

	public List<String> contarNSS(String ruta) throws FileNotFoundException {

		List<String> totalNSS = new ArrayList<String>();

		int contador = 0;
		Scanner in = null;
		try {
			// abre el fichero
			FileReader fichero = new FileReader(ruta);
			// Se crea el flujo
			in = new Scanner(fichero);
			// lee el fichero
			while (in.hasNextLine()) { // Lectura palabra a palabra
				// Aquí se hará la lectura in.next()
				String linea = in.nextLine().trim();
				String[] partes = linea.split(",");
				// como pone en el enunciado solo nos interesa los que empiecen así
				if (linea.startsWith("AN")) {
					totalNSS.add(linea);
					contador++;
				}

			}
			System.out.println("NSSs:"+contador);

		} finally {
			if (in != null) {
				in.close();
			}
		}
		return totalNSS;
	}

	// para escribir los fichro normalmente es siempre igual
	public void escribeFichero(String ruta, List<String> resultado) {

		PrintWriter escribir = null;
		try {
			FileWriter ficheroResultado = new FileWriter(ruta);
			escribir = new PrintWriter(ficheroResultado);
			// para que escriba linea a linea

			for (String linea : resultado) {
				escribir.println(linea);
			}

		} catch (IOException e) {
			System.out.println("Error, no se ha creado fichero");
		} finally {
			if (escribir != null) {
				escribir.close();
			}
		}

	}

}
