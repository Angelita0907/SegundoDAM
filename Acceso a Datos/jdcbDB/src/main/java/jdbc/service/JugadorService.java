package jdbc.service;

import java.util.ArrayList;
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

	public void addJugador(Jugador jugador) {
		try {
			repoJugador.aniadirJugador(jugador);
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			logger.error("No se ha podido añadir el jugador: " + e.getMessage());
		}
	}

	public Jugador mostrarJugadorMayorPuntuacion() {

		Jugador j = new Jugador();

		try {
			j = repoJugador.mostrarJugadorMayorPuntuacion();
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			logger.error("No se ha encontrado jugador con mayor puntuación: " + e.getMessage());
		}
		return j;
	}

	public List<Jugador> mostrarPuntuaciones() {

		List<Jugador> listaPuntos = new ArrayList<>();
		try {
			listaPuntos = repoJugador.mostrarPuntuaciones();
		} catch (MiExcepcion e) {
			logger.error("Error al obtener puntuaciones: " + e.getMessage());
		}
		return listaPuntos;

	}

	public void borrarJugador(int id) {
		try {
			repoJugador.borrarJugador(id);
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public float mediaPuntuaciones() {

		return repoJugador.mediaPuntuaciones();

	}

	public float mediaPuntuaciones2() {

		return repoJugador.mediaPuntuaciones2();

	}

}
