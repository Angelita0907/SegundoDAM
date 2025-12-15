package jdbc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.models.Jugador;
import jdbc.models.Partida;
import jdbc.service.JugadorService;
import jdbc.service.PartidaService;
import jdbc.utiles.MiExcepcion;

public class DixitControlador {

	private static final Logger logger = LogManager.getLogger(DixitControlador.class);
	
	public static void main(String[] args) throws MiExcepcion {
		
		Jugador jugador1 = new Jugador(0, "Ana García", "ana.garcia@email.com", 12);
		Jugador jugador2 = new Jugador(0, "Carlos Ruiz", "carlos.ruiz@email.com", 23);
		Jugador jugador3 = new Jugador(0, "María López", "maria.lopez@email.com", 18);
		Jugador jugador4 = new Jugador(0, "Pedro Martínez", "pedro.martinez@email.com", 37);
		
		Partida partida1 = new Partida(0, 0, jugador4, null, null);
		Partida partida2 = new Partida(0, 0, jugador2, null, null);
		Partida partida3 = new Partida(0, 0, jugador1, null, null);
		
		JugadorService servicioJugador = new JugadorService();
		PartidaService servicioPartida = new PartidaService();
		
		/* Añadimos los jugadores
		servicioJugador.addJugador(jugador1);
		servicioJugador.addJugador(jugador2);
		servicioJugador.addJugador(jugador3);
		servicioJugador.addJugador(jugador4);
		*/
		
		logger.info(servicioJugador.mostrarJugadorMayorPuntuacion());
		
		try {
			
		    logger.info("Lista de puntuaciones: " + servicioJugador.mostrarPuntuaciones());
		} catch (MiExcepcion e) {
		    logger.error("Error al obtener puntuaciones: " + e.getMessage());
		}
		
		logger.info(servicioPartida.mostrarPartidas());

	}

}
