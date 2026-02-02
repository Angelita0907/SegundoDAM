package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Servidor {

	public static void main(String[] args) {
		HashMap<String, String> mapaVotos = new HashMap<>();
		int puerto = 5555;

		try (ServerSocket servidor = new ServerSocket(puerto)) {

			System.out.println("CONEXIÓN ESTABLECIDA: " + puerto);
			int numCliente = 0;
			while (numCliente <= 10) {

				Socket socketCliente = servidor.accept();
				System.out.println("Nuevo cliente conectado: " + socketCliente.getInetAddress());

				/*
				 * Apartado 1 
				 * while(true) { BufferedReader entrada = new BufferedReader(new
				 * InputStreamReader(socketCliente.getInputStream())); PrintWriter salida = new
				 * PrintWriter(socketCliente.getOutputStream(), true); String mensaje = "";
				 * 
				 * //servidor pide voto 
				 * mensaje = "Servidor --> Indique su voto: (dni:::voto)";
				 * salida.println(mensaje);
				 * 
				 * String votoCliente = entrada.readLine(); Servidor s = new Servidor(); String
				 * voto = s.votar(votoCliente); salida.println("Cliente dice:"+voto); }
				 */

				new HiloServidor(socketCliente, mapaVotos).start();

				numCliente++;
				
			}
		} catch (Exception e) {
			System.err.println("Error en el servidor: " + e.getMessage());
		}

	}

	public String votar(String mensaje) {

		HashMap<String, String> mapaVotos = new HashMap<>();
		String voto = "";

		String[] partes = mensaje.split(":::");

		String dni = partes[0].trim();
		String votado = partes[1].trim();

		mapaVotos.put(dni, votado);

		voto = "Voto registrado";

		return voto;
	}

}
