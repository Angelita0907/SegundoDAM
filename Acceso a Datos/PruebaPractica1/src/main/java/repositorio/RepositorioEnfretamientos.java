package repositorio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.TorneoException;
import modelo.Enfrentamiento;

public class RepositorioEnfretamientos {
	
	private static final Logger logger = LogManager.getLogger(RepositorioEnfretamientos.class);

	List<Enfrentamiento> listaEnfrentamiento;
	
	
	
	

	public RepositorioEnfretamientos() {
		super();
		listaEnfrentamiento = new ArrayList<>();
	}



	public RepositorioEnfretamientos(List<Enfrentamiento> listaEnfrentamiento) {
		super();
		this.listaEnfrentamiento = listaEnfrentamiento;
	}



	public void agregaEnfrentamiento(Enfrentamiento enfrentamiento) throws TorneoException {
		int i = 0;
		boolean encontrado = false;

		while (!encontrado && i < listaEnfrentamiento.size()) {

			if (listaEnfrentamiento.get(i).getEquipoGanador().equals(enfrentamiento.getEquipoGanador())){
				encontrado = true;
				throw new TorneoException("Ya existe un enfrentamiento con un equipo ganador");
			}
			i++;
		}

		if (!encontrado) {
			listaEnfrentamiento.add(enfrentamiento);

		}

	}
	
	
}
