package jdbc.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.models.Partida;
import jdbc.repository.PartidaRepository;
import jdbc.utiles.MiExcepcion;

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
	
	public List<Partida> mostrarPartidas() throws MiExcepcion{
		return repoPartida.mostrarPartidas();
	}


}
