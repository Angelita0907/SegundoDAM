<<<<<<< HEAD
package boletin1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		String Host = "localhost"; // host servidor con el que el cliente quiere conectarse
		int Puerto = 4000;// puerto remoto en el servidor que el cliente conoce
		Socket cliente = null;

	
		
		try {
			cliente = new Socket(Host, Puerto);
			System.out.println("Cliente: conexión establecida");
			Scanner sc = new Scanner(System.in);

			// 3. Configurar flujo para enviar y recibir datos
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

			System.out.println("Dime el  mensaje:");
			String mensajeParaServidor = sc.nextLine();
					
			
			while(mensajeParaServidor!= null && !mensajeParaServidor.equals("fin")) {
				
				//4. Enviamos mensaje al servidor
				salida.println(mensajeParaServidor);
				System.out.println("Escribe un mensaje para el servidor: ");
				mensajeParaServidor = sc.nextLine();
				
				
			}

			
			
			
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
=======
package boletin1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		String Host = "localhost"; // host servidor con el que el cliente quiere conectarse
		int Puerto = 4000;// puerto remoto en el servidor que el cliente conoce
		Socket cliente = null;

	
		
		try {
			cliente = new Socket(Host, Puerto);
			System.out.println("Cliente: conexión establecida");
			Scanner sc = new Scanner(System.in);

			// 3. Configurar flujo para enviar y recibir datos
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

			System.out.println("Dime el  mensaje:");
			String mensajeParaServidor = sc.nextLine();
					
			
			while(mensajeParaServidor!= null && !mensajeParaServidor.equals("fin")) {
				
				//4. Enviamos mensaje al servidor
				salida.println(mensajeParaServidor);
				System.out.println("Escribe un mensaje para el servidor: ");
				mensajeParaServidor = sc.nextLine();
				
				
			}

			
			
			
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
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
