package repository;

import models.Sala;
import utils.AbstractDao;

public class SalaRepository extends AbstractDao<Sala>{
	
	public SalaRepository() {
		setClase(Sala.class);
	}

}
