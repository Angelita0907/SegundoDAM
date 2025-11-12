package repositorio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.TorneoException;
import modelo.Equipo;

public class RepositorioEquipos {

	private static final Logger logger = LogManager.getLogger(RepositorioEquipos.class);

	List<Equipo> listaEquipo ;
	

	public RepositorioEquipos() {
		super();
		listaEquipo= new ArrayList<>();
	}

	public RepositorioEquipos(List<Equipo> listaEquipo) {
		super();
		this.listaEquipo = listaEquipo;
	}

	public Equipo getEquipo(String codigo) {
		int i = 0;
		boolean encontrado = false;
		Equipo centro = null;
		while (!encontrado && i < listaEquipo.size()) {

			if (listaEquipo.get(i).getCodigo().equals(codigo)) {
				encontrado = true;
				centro = listaEquipo.get(i);
			}
			i++;
		}
		return centro;

	}

	public void agregaEquipo(Equipo equipo) throws TorneoException {
		int i = 0;
		boolean encontrado = false;

		while (!encontrado && i < listaEquipo.size()) {

			if (listaEquipo.get(i).equals(equipo.getCodigo())) {
				encontrado = true;
				throw new TorneoException("Ya existe un equipo con el mismo código");
			}
			i++;
		}

		if (!encontrado) {
			listaEquipo.add(equipo);

		}

	}

}
