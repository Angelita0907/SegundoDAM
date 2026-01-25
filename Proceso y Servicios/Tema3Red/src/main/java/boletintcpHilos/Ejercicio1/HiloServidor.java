package boletintcpHilos.Ejercicio1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class HiloServidor extends Thread{

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

			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida = new PrintWriter(socket.getOutputStream(), true);
			
			salida.println("Bienvenido. Escribe algo (o 'fin' para salir):");
			String mensaje;
			while ((mensaje = entrada.readLine()) != null && !mensaje.equalsIgnoreCase("fin")) {
					System.out.println("Cliente"+ Thread.currentThread().getId() + "dice: " + mensaje);
					salida.println("Servidor responde: " + mensaje);
			}
			if (mensaje != null && mensaje.equalsIgnoreCase("fin")) {
				salida.println("Cerrando sesión. ¡Hasta pronto!"); 			
		}


			
			System.out.println("Conexión inicializada en fecha y hora: " + LocalDateTime.now());
			Thread.sleep(5000);
			System.out.println("Conexión finalizada");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
