package boletintcpHilos.Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		String host = "localhost";
		int puerto = 44445;
		Socket cliente = null;

		try {
			cliente = new Socket(host, puerto);
			System.out.println("Cliente: conexión establecida");

			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			Scanner sc = new Scanner(System.in);
			String mensaje = " ";

			while (mensaje != null && !mensaje.equals("fin")) {
				System.out.println("Escribe un mensaje para el servidor: ");
				mensaje = sc.nextLine();
				// se envía al servidor
				salida.println(mensaje);

				// lee lo que mande el servidor
				String respuesta = entrada.readLine();
				System.out.println("Respuesta del servidor: " + respuesta);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
