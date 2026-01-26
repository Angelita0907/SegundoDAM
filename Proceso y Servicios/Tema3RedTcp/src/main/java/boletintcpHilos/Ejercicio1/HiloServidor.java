package boletintcpHilos.Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class HiloServidor extends Thread {

	private Socket socket = null;

	public HiloServidor(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

			String mensaje = "";
			while ((mensaje = entrada.readLine()) != null && !mensaje.equalsIgnoreCase("fin")) {
				System.out.println("Cliente dice: " + mensaje);
				salida.println("Servidor responde ECO: " + mensaje.toUpperCase());
			}
			if (mensaje != null && mensaje.equalsIgnoreCase("fin")) {
				salida.println("Cerrando sesión. ¡Hasta pronto!");
			}

			System.out.println("Conexión inicializada en fecha y hora: " + LocalDateTime.now());
			// Thread.sleep(5000);
			System.out.println("Conexión finalizada");

		} catch (java.net.SocketException e) {
			e.printStackTrace();
			System.out.println("El cliente cerró la conexión");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
