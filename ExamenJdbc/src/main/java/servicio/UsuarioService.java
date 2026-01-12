<<<<<<< HEAD
package servicio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.AppException;
import modelo.PlanActivo;
import modelo.Usuario;
import repositorio.UsuarioRepositorio;


public class UsuarioService {

	private static final Logger logger = LogManager.getLogger(UsuarioService.class);
	
	private UsuarioRepositorio repo;
	
	public UsuarioService() throws AppException {
		super();
		this.repo = new UsuarioRepositorio();
	}

	public UsuarioRepositorio getRepo() {
		return repo;
	}

	public void setRepo(UsuarioRepositorio repo) {
		this.repo = repo;
	}
	
	public List<Usuario> obtenerUsuarios(){
		
		List<Usuario> usuario = new ArrayList<>();
		
		try {
			usuario = repo.obtenerUsuarios();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Usuario buscarUsuarioPorId(String id) {
		
		Usuario u = new Usuario();
		
		try {
			u = repo.buscarUsuarioPorId(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public List<Usuario> getUsuario(PlanActivo plan){
		return repo.getListaUsuarios();
	}
	
	public void registrarUsuario(Usuario usu) {
		
		try {
			
			repo.registrarUsuario(usu);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public int contarNumUsuarioPlan(PlanActivo plan) {
		
		int planes = 0;
		
		try {
			planes = repo.contarNumUsuarioPlan(plan);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return planes;
	}
	
	public int eliminarPorDispositivo(String nombreDispositivo){
		
		int filasEliminadas = 0;
		
		try {
			filasEliminadas = repo.eliminarPorDispositivo(nombreDispositivo);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasEliminadas;
	}
	
}
=======
package servicio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.AppException;
import modelo.PlanActivo;
import modelo.Usuario;
import repositorio.UsuarioRepositorio;


public class UsuarioService {

	private static final Logger logger = LogManager.getLogger(UsuarioService.class);
	
	private UsuarioRepositorio repo;
	
	public UsuarioService() throws AppException {
		super();
		this.repo = new UsuarioRepositorio();
	}

	public UsuarioRepositorio getRepo() {
		return repo;
	}

	public void setRepo(UsuarioRepositorio repo) {
		this.repo = repo;
	}
	
	public List<Usuario> obtenerUsuarios(){
		
		List<Usuario> usuario = new ArrayList<>();
		
		try {
			usuario = repo.obtenerUsuarios();
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Usuario buscarUsuarioPorId(String id) {
		
		Usuario u = new Usuario();
		
		try {
			u = repo.buscarUsuarioPorId(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public List<Usuario> getUsuario(PlanActivo plan){
		return repo.getListaUsuarios();
	}
	
	public void registrarUsuario(Usuario usu) {
		
		try {
			
			repo.registrarUsuario(usu);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public int contarNumUsuarioPlan(PlanActivo plan) {
		
		int planes = 0;
		
		try {
			planes = repo.contarNumUsuarioPlan(plan);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return planes;
	}
	
	public int eliminarPorDispositivo(String nombreDispositivo){
		
		int filasEliminadas = 0;
		
		try {
			filasEliminadas = repo.eliminarPorDispositivo(nombreDispositivo);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasEliminadas;
	}
	
}
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
