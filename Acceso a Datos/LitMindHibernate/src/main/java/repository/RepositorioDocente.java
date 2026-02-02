package repository;

import modelo.Docente;
import utils.AbstractDao;

public class RepositorioDocente extends AbstractDao<Docente>{

	public RepositorioDocente() {
		setClase(Docente.class);
	}
	
	

}
