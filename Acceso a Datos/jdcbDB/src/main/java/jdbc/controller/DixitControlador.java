package jdbc.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
		
		JugadorService servicioJugador = new JugadorService();
		PartidaService servicioPartida = new PartidaService();

		Jugador jugador1 = new Jugador("Ana García", "ana.garcia@email.com", 12);
		Jugador jugador2 = new Jugador("Carlos Ruiz", "carlos.ruiz@email.com", 23);
		Jugador jugador3 = new Jugador("María López", "maria.lopez@email.com", 18);
		Jugador jugador4 = new Jugador("Pedro Martínez", "pedro.martinez@email.com", 37);
		
		/*
		 * Añadimos los jugadores
		 */
		/*
		 servicioJugador.addJugador(jugador1); 
		 servicioJugador.addJugador(jugador2);
		 servicioJugador.addJugador(jugador3); 
		 servicioJugador.addJugador(jugador4);
		 */
		
		// para poder leer clases que tengan objeto de otra y añadirlo luego hay que hacer esto
		List<Jugador> jugadores = servicioJugador.getRepoJugador().getListaJugadores();
		
		for (Jugador jugador : jugadores) {
			logger.info(jugador);
		}
		
		// y luego lo relacionamos con el indice dentro de donde pertenece a la lista
		Partida partida1 = new Partida(3, jugadores.get(3), Date.valueOf("2025-12-05"), ResultadoPartida.ALGUNOS);
		Partida partida2 = new Partida(4, jugadores.get(0), Date.valueOf("2025-10-17"), ResultadoPartida.NADIE);
		Partida partida3 = new Partida(6, jugadores.get(1), Date.valueOf("2025-11-21"), ResultadoPartida.TODOS);

		// añadimos las partidas
		
		//servicioPartida.addPartida(partida1); 
		//servicioPartida.addPartida(partida2);
		//servicioPartida.addPartida(partida3);
		 

		List<Partida> partidas = servicioPartida.getRepoPartida().getListaPartidas();
		for (Partida partida : partidas) {
			logger.info(partida);
		}

		logger.info("Jugador con mayor puntuación: "+servicioJugador.mostrarJugadorMayorPuntuacion());
		logger.info("Puntuaciones de Jugadores: "+ servicioJugador.mostrarPuntuaciones());


		// probar metedos partidas
		
		//servicioPartida.actualizarPuntuacionNarrador(4, ResultadoPartida.ALGUNOS);
		
		//servicioPartida.actualizarPuntuacionNOAcertante(3, ResultadoPartida.TODOS);
		
		//servicioPartida.actualizarPuntuacionAcertante(1, ResultadoPartida.NADIE);

		logger.info("Lista de puntuaciones: " +servicioPartida.mostrarPartidas());

	}

}
