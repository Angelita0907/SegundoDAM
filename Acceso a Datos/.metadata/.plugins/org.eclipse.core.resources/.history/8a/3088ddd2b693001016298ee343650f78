package service;

import Repository.UsuarioRepository;
import models.Usuario;

public class UsuarioService {

	UsuarioRepository usuRepo;

	public UsuarioService(UsuarioRepository usuRepo) {
		super();
		this.usuRepo = new UsuarioRepository();
	}
	
	public void altaUsuario(Usuario u) {
		usuRepo.addUsuarios(u);
	}
	
	public void borrarUsuario(Usuario u) {
		usuRepo.delUsuario(u);
	}
	
	public void buscarUsuario(Usuario u) {
		usuRepo.findUser(u);
	}

}
