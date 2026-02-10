package repository;

import models.Pelicula;
import utils.AbstractDao;

public class PeliculaRepository extends AbstractDao<Pelicula>{

	public PeliculaRepository() {
		setClase(Pelicula.class);
	}
	
}
