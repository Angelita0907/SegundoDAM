package boletin1.Ejercicio3;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		// el servidor atiende a los clientes y es él quien da paso

		int puerto = 6000;
		int numCliente = 0;
		ServerSocket servidor =  null;
		
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Servidor: Servidor escuchando en el puerto: "+ puerto);
		
			String mensajeParaCliente = "";
			
			while(numCliente<=2) {
				Socket cliente = servidor.accept();
				
				PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
				mensajeParaCliente = "Cliente "+numCliente + " conectado al servidor";
				// para que muestre el mensaje
				salida.println(mensajeParaCliente);
				
				numCliente ++;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
