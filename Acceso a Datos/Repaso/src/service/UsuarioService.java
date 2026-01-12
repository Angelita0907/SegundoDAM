package service;

import Repository.UsuarioRepository;
import models.Usuario;

public class UsuarioService {

	UsuarioRepository usuRepo;

	public UsuarioService() {
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

	public UsuarioRepository getUsuRepo() {
		return usuRepo;
	}

	public void setUsuRepo(UsuarioRepository usuRepo) {
		this.usuRepo = usuRepo;
	}

}
