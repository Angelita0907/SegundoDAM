package jdbc.controller;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.models.Jugador;
import jdbc.models.Partida;
import jdbc.service.JugadorService;
import jdbc.service.PartidaService;
import jdbc.utiles.MiExcepcion;
import jdbc.utiles.ResultadoPartida;

public class DixitControlador {

	private static final Logger logger = LogManager.getLogger(DixitControlador.class);

	public static void main(String[] args) throws MiExcepcion {

		Jugador jugador1 = new Jugador("Ana García", "ana.garcia@email.com", 12);
		Jugador jugador2 = new Jugador("Carlos Ruiz", "carlos.ruiz@email.com", 23);
		Jugador jugador3 = new Jugador("María López", "maria.lopez@email.com", 18);
		Jugador jugador4 = new Jugador("Pedro Martínez", "pedro.martinez@email.com", 37);

		Partida partida1 = new Partida(3, jugador4, Date.valueOf("2025-12-05"), ResultadoPartida.ALGUNOS);
		Partida partida2 = new Partida(4, jugador2, Date.valueOf("2025-10-17"), ResultadoPartida.NADIE);
		Partida partida3 = new Partida(6, jugador1, Date.valueOf("2025-11-21"), ResultadoPartida.TODOS);

		JugadorService servicioJugador = new JugadorService();
		PartidaService servicioPartida = new PartidaService();

		/*
		 * Añadimos los jugadores */
		/*
		 servicioJugador.addJugador(jugador1);
		 servicioJugador.addJugador(jugador2); 
		 servicioJugador.addJugador(jugador3);
		 servicioJugador.addJugador(jugador4);
		 */
		
		// añadimos las partidas
		/*
		servicioPartida.addPartida(partida1);
		servicioPartida.addPartida(partida2);
		servicioPartida.addPartida(partida3);
		*/
		
		//logger.info(servicioJugador.mostrarJugadorMayorPuntuacion());

		//logger.info("Lista de puntuaciones: " + servicioJugador.mostrarPuntuaciones());

		// probar metedos partidas
		
		logger.info(servicioPartida.mostrarPartidas());

	}

}
