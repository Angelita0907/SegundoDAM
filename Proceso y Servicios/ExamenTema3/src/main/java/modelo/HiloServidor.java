package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HiloServidor extends Thread {

	private Socket socket = null;
	private HashMap<String, String> mapaVotos;

	public HiloServidor(Socket socket, HashMap<String, String> mapaVotos) {
		super();
		this.socket = socket;
		this.mapaVotos = new HashMap<>();
	}

	@Override
	public void run() {

		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			String mensaje = " ";

			// servidor pide voto

			// int conexiones = 10;

			mensaje = "Servidor --> Indique su voto: (dni:::voto)";
			salida.println(mensaje);
			String votoCliente = entrada.readLine();

			String voto = votar(votoCliente);
			salida.println(voto);

			String resumen = resumenVotos();
			salida.println(resumen);

			String votosCliente = totalVotos();
			salida.println(votosCliente);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public String votar(String mensaje) {
		String voto = "";

		String[] partes = mensaje.split(":::");

		String dni = partes[0].trim();
		String votado = partes[1].trim();

		mapaVotos.put(dni, votado);

		voto = "Voto registrado";

		return voto;
	}

	public synchronized String resumenVotos() {
		String resumen = "";

		for (Map.Entry<String, String> elementoMapa : mapaVotos.entrySet()) {
			String dni = elementoMapa.getKey();
			String nombreCandidato = elementoMapa.getValue();

			System.out.println("Dni Cliente: " + dni.toString() + " a votado a : " + nombreCandidato);
		}

		return resumen;
	}

	// sincronizo este método para que cuando se sumen los votos se tenga en cuenta quien va entrando y no se sobreescriba
	public synchronized String totalVotos() {

		String votos = "";
		int contador = 0;

		for (Map.Entry<String, String> elementoMapa : mapaVotos.entrySet()) {

			String candidato = elementoMapa.getValue();
			
			
			contador ++;

			votos = "Candidato/a " + candidato + " tiene: ";

		}

		return votos;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public HashMap<String, String> getMapaVotos() {
		return mapaVotos;
	}

	public void setMapaVotos(HashMap<String, String> mapaVotos) {
		this.mapaVotos = mapaVotos;
	}

}
