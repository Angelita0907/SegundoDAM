package repository;

import modelo.Estudiante;
import utils.AbstractDao;

public class RepositorioEstudiante extends AbstractDao<Estudiante>{

	public RepositorioEstudiante() {
		setClase(Estudiante.class);
	}

	
	
}
