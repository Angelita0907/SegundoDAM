package repasoExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HiloServidor extends Thread {

	private Socket socket = null;
	private Contador contador;
	private MapaCompartido mapaVuelos;

	public HiloServidor(Socket socket, Contador contador, MapaCompartido mapaVuelos) {
		super();
		this.socket = socket;
		this.contador = contador;
		this.mapaVuelos = mapaVuelos;
	}

	@Override
	public void run() {

		Scanner sc = new Scanner(System.in);

		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			String mensaje = " ";

			contador.setNumConexiones(contador.getNumConexiones() + 1);
			salida.println("Servidor responde: Cliente conectado -->" + contador.getNumConexiones());

			mensaje = "Indique número reserva y nombre (r y n)";
			salida.println(mensaje);

			String reservaCliente = entrada.readLine();

			String reserva = mapaVuelos.hacerReserva(reservaCliente);
			salida.println(reserva);

			System.out.println("Conexión finalizada, Cliente desconectado -->" + contador.getNumConexiones());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}

	public MapaCompartido getMapaVuelos() {
		return mapaVuelos;
	}

	public void setMapaVuelos(MapaCompartido mapaVuelos) {
		this.mapaVuelos = mapaVuelos;
	}

}
