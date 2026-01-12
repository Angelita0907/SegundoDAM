package Repository;

import java.util.ArrayList;
import java.util.List;

import models.Usuario;

public class UsuarioRepository {
	
	private List<Usuario> usuarios;
	
	public UsuarioRepository() {
		super();
		this.usuarios = new ArrayList<Usuario>();
	}

	public void addUsuarios (Usuario u){
		usuarios.add(u);
	}
	
	public void delUsuario (Usuario u) {
		usuarios.remove(u);
	}
	
	public Usuario findUser (Usuario u) {
		Usuario found = null;
		
		if(usuarios.contains(u)) {
			found = u;
		}
		
		return found;
		
	}

}
