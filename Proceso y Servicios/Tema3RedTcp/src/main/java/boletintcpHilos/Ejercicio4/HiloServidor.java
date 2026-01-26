package boletintcpHilos.Ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread {

	private Socket socket = null;
	private Contador contador;
	private Tablero tablero;

	public HiloServidor(Socket socket, Contador contador, Tablero tablero) {
		super();
		this.socket = socket;
		this.contador = contador;
		this.tablero = tablero;
	}

	
	@Override
	public void run() {
		
		// boleano para saber si se sigue jugando
		
		boolean hayJuego = true;
		
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			String mensaje = " ";

			System.out.println("Cliente dice: " + mensaje);
			contador.setNumConexiones(contador.getNumConexiones()+1);
			salida.println("Servidor responde: Cliente conectado -->" + contador.getNumConexiones());
		
			//System.out.println("Conexión inicializada en fecha y hora: " + LocalDateTime.now());

			// mirar si quedan premios
			
			//cliente envia coordenadas
			
			int fila = 0;
			int columna = 0;
			
			while(hayJuego) {
				
			}
			
			System.out.println("Conexión finalizada, Cliente desconectado -->"+ contador.getNumConexiones());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String mensaje = "";
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


	public Tablero getTablero() {
		return tablero;
	}


	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

}
