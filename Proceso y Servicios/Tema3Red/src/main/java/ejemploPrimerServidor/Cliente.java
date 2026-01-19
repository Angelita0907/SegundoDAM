package ejemploPrimerServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {

		String Host = "localhost"; // host servidor con el que el cliente quiere conectarse
		int Puerto = 6000;// puerto remoto en el servidor que el cliente conoce
		Socket cliente = null;

		try {
			cliente = new Socket(Host, Puerto);
			System.out.println("Cliente: conexión establecida");

			// 3. Configurar flujo para enviar y recibir datos
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

			System.out.println("Escribe un mensaje para el servidor: ");
			String mensajeParaServidor = "Hola soy un cliente";
			
			//4. Enviamos mensaje al servidor
			salida.println(mensajeParaServidor);
			
			// 5. Leer la repuesta del servidor
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // conecta

	}

}
