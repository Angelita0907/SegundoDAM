package boletintcpHilos.Ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		String Host = "localhost";
		int Puerto = 3245;
		Socket cliente = null;
		Scanner sc = new Scanner(System.in);

		try {
			cliente = new Socket(Host, Puerto);
			System.out.println("Cliente: conexión establecida");

			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			String mensaje = entrada.readLine();
			System.out.println("Servidor dice: " + mensaje);

			boolean jugando = true;
			while (jugando) {
				String segundoMensaje = entrada.readLine();
				System.out.println(segundoMensaje);

				String coordenadas = sc.nextLine();
				// envio las coordenadas
				salida.println(coordenadas);

				if (coordenadas.equals("fin")) {
					jugando = false;
					cliente.close();
				}

				String respuestaIntento = entrada.readLine();
				System.out.println(respuestaIntento);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
