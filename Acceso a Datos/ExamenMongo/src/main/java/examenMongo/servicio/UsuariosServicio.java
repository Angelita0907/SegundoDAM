package examenMongo.servicio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import examenMongo.modelo.Usuario;
import examenMongo.repositorio.UsuarioRepositorio;
import examenMongo.utils.PlanActivo;

public class UsuariosServicio {

	private static final Logger logger = LogManager.getLogger(UsuariosServicio.class);
	
	private final UsuarioRepositorio repo;
	
	public UsuariosServicio(MongoDatabase db) {
		this.repo = new UsuarioRepositorio(db);
	}

	public void save(Usuario u) {
		repo.save(u);
	}
	
	public List<Usuario> read() {
		return repo.read();
	}
	
	public void addUsuario(Usuario usu) {
		repo.aniadirUsuario(usu);
	}
	
	public void buscarUsuario(String id) {
		repo.mostrarUsuario(id);
	}
	
	public List<Usuario> ordenarPorPlanEmail(){
		return repo.ordenarPorPlanEmail();
		
	}
	
	public void updateIdiomaEspanol(String idioma) {
		repo.updateIdiomaEspanol(idioma);
	}
	
	public void deletePlanAnual(PlanActivo plan) {
		repo.eliminarPlanAnual(plan);
	}
	
	public void updateDatosMoviles() {
		repo.updateDatosMoviles();
	}
	
	public void aniadirPorid(String id) {
		repo.aniadirPorid(id);
	}
	
}
