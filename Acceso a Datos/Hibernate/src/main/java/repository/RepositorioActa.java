package repository;

import modelo.Acta;
import utils.AbstractDao;

public class RepositorioActa extends AbstractDao<Acta>{

	public RepositorioActa() {
		setClase(Acta.class);
	}
	
}
