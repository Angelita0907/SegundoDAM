package repository;

import modelo.Sala;
import utils.AbstractDao;

public class RepositorioSala extends AbstractDao<Sala>{

	/*
	 * Al crear el repositorio llamamos con lo siguiente a la clase
	 * abstracta y con ello llamamos a los metodos de alli sin escribirlo dos veces
	 * y con la clase que le indiquemos
	 * */
	public RepositorioSala() {
		setClase(Sala.class);
	}

}
