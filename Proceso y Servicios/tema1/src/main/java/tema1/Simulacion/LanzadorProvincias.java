package tema1.Simulacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzadorProvincias {

	//Ejercicio logistica pedidos amazon --> papa
	
	private static final String rutaFicheroJava = "src\\main\\java\\tema1\\Simulacion\\PedidosProvincia.java" ;
	private static final String directorioGenerarClases = "target\\classes";
	
	public static void main(String[] args) {
		
		LanzadorProvincias lanzadorProv = new LanzadorProvincias();
		
		String[] provincias = {"Sevilla", "Huelva", "Cádiz", 
				"Málaga", "Córdoba", "Granada", "Jaén", "Almería"};
		
		String ficheroPedidoProvincias = "src\\main\\resources\\pedidos.txt";
		
		lanzadorProv.compilaProceso();
		
		int totalPedidos = 0;
		
		for (String nombreProv : provincias) {
			
			totalPedidos = totalPedidos + lanzadorProv.ejecutaProceso(ficheroPedidoProvincias, nombreProv);
		
		}
		
		System.out.println("Total pedidos: "+totalPedidos);

	}
	
	public void compilaProceso() {

		String[] comando = { "javac", "-d",directorioGenerarClases ,rutaFicheroJava};
		ProcessBuilder pb = new ProcessBuilder(comando);
		
		try {
			// para la comunicacion entre proceso padre e hijo
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			int exit = p1.waitFor();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int ejecutaProceso(String ruta, String prov) {
		
		int numero = 0;
		String[] comando1 = {"java", "-cp", directorioGenerarClases,rutaFicheroJava,ruta, prov};

		ProcessBuilder pb = new ProcessBuilder(comando1);

		try {
			// esto se cambia por el buffer
			/*pb.redirectErrorStream(true);
			pb.inheritIO();*/
			Process p1 = pb.start();
			/*int exit = p1.waitFor();
			System.out.println(exit);*/
			
			//lee el padre lo que diga el hijo por consola
			BufferedReader reader= new BufferedReader(new InputStreamReader(p1.getInputStream()));
			
			//porsi ocurre un error en el hijo el padre pueda leerlo
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p1.getErrorStream()));
			
			String linea = reader.readLine();
			//porsi guarda mas de una linea
	           while (linea != null) {
	        	 // String[] porPuntos = linea.split(":");
	        	  
	              System.out.println(linea);

		   	      linea = reader.readLine();   
	               
		   	   // numero = Integer.parseInt(porPuntos[1]);
	           }
	         
	        // apartado 3 dividir por puntos cogiendo el resultado de cada pronvincia
	       
			
	
		} catch (IOException e) {
			e.printStackTrace();

	}
		return numero;

	}

}
