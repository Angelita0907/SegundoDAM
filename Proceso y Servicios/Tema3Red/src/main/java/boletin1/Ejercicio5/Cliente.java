package boletin1.Ejercicio5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		String Host = "localhost"; // host servidor con el que el cliente quiere conectarse
		int Puerto = 6000;// puerto remoto en el servidor que el cliente conoce
		Socket cliente = null;
		
		try {
			cliente = new Socket(Host, Puerto);
			System.out.println("Cliente: conexión establecida");
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			String mensaje = entrada.readLine();
			System.out.println("Cliente dice: " + mensaje);
			
	
			while(true) {
				// para que no cierre la conexión y siga leyendo
				entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
