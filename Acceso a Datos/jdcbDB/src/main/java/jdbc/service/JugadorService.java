package jdbc.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.models.Jugador;
import jdbc.repository.JugadorRepository;
import jdbc.utiles.MiExcepcion;

public class JugadorService {
	
	private static final Logger logger = LogManager.getLogger(JugadorService.class);
	
	private JugadorRepository repoJugador;
	
	public JugadorService() throws MiExcepcion {
		super();
		this.repoJugador = new JugadorRepository();
	}

	public JugadorRepository getRepoJugador() {
		return repoJugador;
	}

	public void setRepoJugador(JugadorRepository repoJugador) {
		this.repoJugador = repoJugador;
	}
	
	public void addJugador(Jugador jugador) throws MiExcepcion {
		repoJugador.aniadirJugador(jugador);
	}
	
	public Jugador mostrarJugadorMayorPuntuacion() throws MiExcepcion {
		return repoJugador.mostrarJugadorMayorPuntuacion();
	}
	
	public  List<Jugador> mostrarPuntuaciones() throws MiExcepcion {
		return repoJugador.mostrarPuntuaciones();
	}

}
