package servicio;

import java.util.HashSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.TorneoException;
import modelo.Enfrentamiento;
import modelo.Equipo;
import repositorio.RepositorioEnfretamientos;
import repositorio.RepositorioEquipos;

public class TorneoService {

	private static final Logger logger = LogManager.getLogger(TorneoService.class);

	// implementamos los dos repositorios

	RepositorioEquipos repoEquipos;
	RepositorioEnfretamientos repoEnfrentamiento;
	
	

	public TorneoService() {
		super();
		repoEquipos = new RepositorioEquipos();
		repoEnfrentamiento = new RepositorioEnfretamientos();
	}

	public TorneoService(List<Equipo> equipos, List<Enfrentamiento> enfrentamiento) {
		super();
		repoEquipos = new RepositorioEquipos(equipos);
		repoEnfrentamiento = new RepositorioEnfretamientos(enfrentamiento);
	}

	public void agregarListaEquipo(List<Equipo> equipos) {

		for (Equipo equipo : equipos) {
			try {
				repoEquipos.agregaEquipo(equipo);
			} catch (TorneoException e) {
				// TODO Auto-generated catch block
				logger.error("Equipo ya existe, contuniamos agregando");
			}
		}

	}

	public List<Enfrentamiento> agregarListaEnfretamiento(List<Enfrentamiento> listaEnfrentamiento) {

		for (Enfrentamiento enfrentamiento : listaEnfrentamiento) {
			try {
				repoEnfrentamiento.agregaEnfrentamiento(enfrentamiento);
			} catch (TorneoException e) {
				// TODO Auto-generated catch block
				logger.error("Enfrentamiento ya existe, contuniamos agregando");
			}
		}
		return listaEnfrentamiento;

	}
	
	//Lista Ordenada
	/*
	public HashSet<Enfrentamiento> obtenerEnfrentamientosEquipo(String codigo){
		
		HashSet<Enfrentamiento> listaOrdenada = new HashSet<>();
		
		int i = 0;
		boolean encontrado = false;

		while (!encontrado && i < repoEnfrentamiento.) {

			if (listaEnfrentamiento.get(i).getEquipoGanador().equals(enfrentamiento.getEquipoGanador())){
				encontrado = true;
				throw new TorneoException("Ya existe un enfrentamiento con un equipo ganador");
			}
			i++;
		}
		
		return null;
		
	}*/

}
