package librosMongo.servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import librosMongo.modelo.Usuario;
import librosMongo.repostorio.UsuariosRepository;
import utils.TipoUsuario;

public class UsuarioService {

	private static final Logger logger = LogManager.getLogger(UsuarioService.class);

	// instanciamos el repositorio
	private final UsuariosRepository repo;

	public UsuarioService(MongoDatabase db) {
		this.repo = new UsuariosRepository(db);
	}

	// Guarda un estudiante en la base de datos
	public void save(Usuario e) {
		// Aquí podrías añadir validaciones, reglas de negocio, etc.
		repo.save(e);
	}

	// Lista todos los estudiantes
	public List<Usuario> read() {
		return repo.read();
	}

	// llamamos a las funciones (crud)

	public void addUsuario(Usuario usuNuevo) {
		repo.aniadirUsuario(usuNuevo);
	}

	public void deleteUsuario(Usuario usuBorrar) {
		repo.borrarUsuario(usuBorrar);
	}

	public Usuario mostrarUsuario(String id) {
		return repo.mostrarUsuario(id);
	}

	public void updateUsuario(Usuario usuNuevo) {
		repo.actualizarUsuario(usuNuevo);
	}

	// ordenar y filtrar del resosiorio

	public List<Usuario> filtrarPorEdad(int edad) {
		return repo.filtarEdad(edad);
	}

	public List<Usuario> ordenarPorNombre() {
		return repo.ordenarNombre();
	}

	// ordenar y filtrar del servicio

	public List<Usuario> filtrarTipoUsuario(TipoUsuario tipo) {

		List<Usuario> listaUsuarios = repo.read();
		
		List<Usuario> tiposUsuarios = new ArrayList<>();

		for (Usuario usuario : listaUsuarios) {
			if (usuario.getTipoUsuario().equals(tipo)) {
				tiposUsuarios.add(usuario);
			}
		}

		return tiposUsuarios;
	}

	// en el modelo usuario he implementado comparable para poder ordenar un
	// criterio en concreto
	public List<Usuario> ordenaPuntosLogros() {

		// primero vemos los usuarios
		List<Usuario> usuarios = repo.read();

		Collections.sort(usuarios, Collections.reverseOrder());

		return usuarios;

	}

	// get del repositorio
	public UsuariosRepository getRepo() {
		return repo;
	}

}