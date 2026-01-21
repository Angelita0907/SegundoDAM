package repository;

import modelo.Persona;
import utils.AbstractDao;

public class RepositorioPersona extends AbstractDao<Persona>{

	public RepositorioPersona() {
		setClase(Persona.class);
	}
	
	

}
