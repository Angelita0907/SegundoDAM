<<<<<<< HEAD
package jdbc.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.models.Partida;
import jdbc.repository.PartidaRepository;
import jdbc.utiles.MiExcepcion;
import jdbc.utiles.ResultadoPartida;

public class PartidaService {
	
	private static final Logger logger = LogManager.getLogger(PartidaService.class);
	
	private PartidaRepository repoPartida;
	
	public PartidaService() throws MiExcepcion {
		super();
		this.repoPartida = new PartidaRepository();
	}

	public PartidaRepository getRepoPartida() {
		return repoPartida;
	}

	public void setRepoPartida(PartidaRepository repoPartida) {
		this.repoPartida = repoPartida;
	}
	
	public void addPartida(Partida partida) throws MiExcepcion {
		repoPartida.aniadirPartida(partida);
	}
	
	public void actualizarPuntuacionNarrador(int idJugador, ResultadoPartida resultado)  {
		try {
			repoPartida.actualizarPuntuacionNarrador(idJugador, resultado);
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizarPuntuacionNOAcertante (int idJugador, ResultadoPartida resultado) throws MiExcepcion {
		repoPartida.actualizarPuntuacionNOAcertante(idJugador, resultado);
	}
	
	public void actualizarPuntuacionAcertante(int idJugador, ResultadoPartida resultado) {
		try {
			repoPartida.actualizarPuntuacionAcertante(idJugador, resultado);
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public List<Partida> mostrarPartidas() throws MiExcepcion{
		return repoPartida.mostrarPartidas();
	}


}
=======
package jdbc.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.models.Partida;
import jdbc.repository.PartidaRepository;
import jdbc.utiles.MiExcepcion;
import jdbc.utiles.ResultadoPartida;

public class PartidaService {
	
	private static final Logger logger = LogManager.getLogger(PartidaService.class);
	
	private PartidaRepository repoPartida;
	
	public PartidaService() throws MiExcepcion {
		super();
		this.repoPartida = new PartidaRepository();
	}

	public PartidaRepository getRepoPartida() {
		return repoPartida;
	}

	public void setRepoPartida(PartidaRepository repoPartida) {
		this.repoPartida = repoPartida;
	}
	
	public void addPartida(Partida partida) throws MiExcepcion {
		repoPartida.aniadirPartida(partida);
	}
	
	public void actualizarPuntuacionNarrador(int idJugador, ResultadoPartida resultado)  {
		try {
			repoPartida.actualizarPuntuacionNarrador(idJugador, resultado);
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizarPuntuacionNOAcertante (int idJugador, ResultadoPartida resultado) throws MiExcepcion {
		repoPartida.actualizarPuntuacionNOAcertante(idJugador, resultado);
	}
	
	public void actualizarPuntuacionAcertante(int idJugador, ResultadoPartida resultado) {
		try {
			repoPartida.actualizarPuntuacionAcertante(idJugador, resultado);
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public List<Partida> mostrarPartidas() throws MiExcepcion{
		return repoPartida.mostrarPartidas();
	}


}
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
