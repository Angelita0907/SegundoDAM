package boletintcpHilos.Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteHilo extends Thread{
	
	@Override
	public void run() {
		String Host = "localhost"; 
		int Puerto = 44444;
		Socket cliente = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			cliente = new Socket(Host, Puerto);
			System.out.println("Cliente: conexión establecida");
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

			String mensaje = entrada.readLine();
			System.out.println("ECO: " + mensaje);
			
	
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
