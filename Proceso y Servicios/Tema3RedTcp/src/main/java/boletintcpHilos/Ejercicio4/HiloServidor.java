package boletintcpHilos.Ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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

	public boolean hayPremio() {
		
		boolean hayPremio = true;
		int contador = 0;
		for (String[] filas : tablero.getTablero()) {
			for (String elementoFila : filas) {
				if(elementoFila == null) {
					contador++;
				}
			}
		}
		
		// es 12 si todo es nulo y no hay ningun premio
		if(contador == 12) {
			hayPremio = false;
		}
		
		return hayPremio;
	}
	
	public synchronized String aciertoPremio(String coordenas) {
		
		String intento =  null;
		
		// cambio las coordedas de string a int
		String [] partes = coordenas.split(",");
		
		int fila = Integer.parseInt(partes[0].trim());
		int columna = Integer.parseInt(partes[1].trim());

		String resultadoIntento = tablero.getTablero()[fila][columna];
		if(resultadoIntento != null) {
			intento = "Felicidades has ganado: " + resultadoIntento;
			// para borrar el intento si acierta
			tablero.getTablero()[fila][columna] = null;
		}
		else {
			intento = "Pringao no has ganado nada";
		}
		
		return intento;
	}
	
	@Override
	public void run() {
		
		// boleano para saber si se sigue jugando
		
		boolean hayJuego = hayPremio();
		Scanner sc = new Scanner(System.in);
		
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			String mensaje = " ";

			contador.setNumConexiones(contador.getNumConexiones()+1);
			salida.println("Servidor responde: Cliente conectado -->" + contador.getNumConexiones());
			
			// mirar si quedan premios
			while (hayJuego) {
				mensaje = "Dime las coordenadas para poder jugar (f,c)";
				salida.println(mensaje);
				
				// recupero lo que dice el cliente
				String coordendasCliente = entrada.readLine();
				//cliente envia coordenadas
				if(!coordendasCliente.equals("fin")) {
					String premio = aciertoPremio(coordendasCliente);
					salida.println(premio);
				}
			}
		
			//System.out.println("Conexión inicializada en fecha y hora: " + LocalDateTime.now());
	
			
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
