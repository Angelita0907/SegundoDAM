package repository;

import modelo.Usuario;
import utils.AbstractDao;

public class RepositorioUsuario extends AbstractDao<Usuario>{

	public RepositorioUsuario() {
		setClase(Usuario.class);
	}

	
	
}
