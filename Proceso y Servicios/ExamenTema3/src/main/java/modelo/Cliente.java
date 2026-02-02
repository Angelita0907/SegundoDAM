package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Cliente {
	
	public static void main(String[] args) {
		Random r = new Random(100);
		String Host = "localhost";
		int Puerto = 5555;
		Socket cliente = null;
		String dni = "Dni"+r;
		
		try {
			
			cliente = new Socket(Host, Puerto);
			System.out.println("Cliente: conexión establecida");

			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			String mensaje = entrada.readLine();
			System.out.println("Servidor dice: " + mensaje);
			
			//cliente envía voto
			Cliente c = new Cliente();
			String votoCliente =dni+":::"+c.generaVoto();
			salida.println("Cliente: "+votoCliente);
			
			String respuestaServidor = entrada.readLine();
			System.out.println(respuestaServidor);
			
			
			cliente.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public String generaVoto() {
		Random random = new Random();
		Candidato [] valores = Candidato.values();
		int pos = random.nextInt(valores.length);
		return valores[pos].name();
	}
	
	

}
