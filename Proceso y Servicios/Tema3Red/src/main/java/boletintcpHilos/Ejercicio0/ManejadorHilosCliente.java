package boletintcpHilos.Ejercicio0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorHilosCliente extends Thread {

	private Socket socket = null;

	public ManejadorHilosCliente(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			salida.println("Bienvenido. Escribe algo (o 'fin' para salir):");
			String mensaje;
			while ((mensaje = entrada.readLine()) != null && !mensaje.equalsIgnoreCase("fin")) {
				System.out.println("Cliente dice: " + mensaje);
				salida.println("Servidor responde: " + mensaje.toUpperCase());
			}
			if (mensaje != null && mensaje.equalsIgnoreCase("fin")) {
				salida.println("Cerrando sesión. ¡Hasta pronto!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
