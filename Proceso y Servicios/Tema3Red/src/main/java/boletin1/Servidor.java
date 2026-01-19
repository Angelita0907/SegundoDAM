
package boletin1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
	
		// 1. Definimos el puerto de la aplicación
		int puerto = 4000;
		ServerSocket servidor = null;
		
		//2. Crear serverScoket para escuvhar las peticiones
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Servidor: Servidor escuchando en el puerto: "+ puerto);
			
			Socket cliente = servidor.accept();
		
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

			String mensaje = entrada.readLine();
			System.out.println("Servidor: Cliente dice: " + mensaje);
			
			while(mensaje!= null) {
				mensaje = entrada.readLine();
				System.out.println("Servidor: Cliente dice: " + mensaje);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
