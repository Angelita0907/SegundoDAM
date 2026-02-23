package LitMindSpring.LitMindSpring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import LitMindSpring.LitMindSpring.models.Usuario;
import LitMindSpring.LitMindSpring.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario usuario = usuarioRepository.findByNombre(username);
       
       
       if (usuario == null) {
           throw new UsernameNotFoundException("Usuario no encontrado: " + username);
       }
       return new org.springframework.security.core.userdetails.User(usuario.getNombre(), usuario.getClave(), new ArrayList<>());
   }
	@Override
	public boolean existsByNombre(String nombre) {
		return usuarioRepository.existsByNombre(nombre);
	}
	public void saveUsuario(Usuario u) {
	    usuarioRepository.save(u);
	}
}
