package repasoExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente{
	
	public static void main(String[] args) {
	
		String Host = "localhost";
		int Puerto = 6000;
		Socket cliente = null;
		Scanner sc = new Scanner(System.in);

		try {
			cliente = new Socket(Host, Puerto);
			System.out.println("Cliente: conexión establecida");

			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			String mensaje = entrada.readLine();
			System.out.println("Servidor dice: " + mensaje);

			String segundoMensaje = entrada.readLine();
			System.out.println("Servidor dice: "+segundoMensaje);
			
			//cliente envia reserva
			String reserva = sc.nextLine();
			salida.println(reserva);
			
			//respuesta a la pregunta de la reserva
			String respuestaReserva = entrada.readLine();
			System.out.println(respuestaReserva);
			cliente.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
