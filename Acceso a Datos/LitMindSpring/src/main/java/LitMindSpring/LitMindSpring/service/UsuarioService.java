package LitMindSpring.LitMindSpring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import LitMindSpring.LitMindSpring.models.Usuario;

public interface UsuarioService {
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	public boolean existsByNombre(String nombre);
	public void saveUsuario(Usuario u);
}

