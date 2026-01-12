<<<<<<< HEAD
package controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.AppException;
import modelo.PlanActivo;
import modelo.Preferencias;
import modelo.Usuario;
import servicio.UsuarioService;


public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);

	public static void main(String[] args) throws AppException {
		
		UsuarioService servicioUsuario = new UsuarioService();
		
		// ejercicio 1
		logger.info(servicioUsuario.obtenerUsuarios());
		
		// ejercicio 2
		//logger.info(servicioUsuario.buscarUsuarioPorId("usr020"));
		Preferencias p1 = new Preferencias(false, "ingles", true, false);
		Usuario usu1 = new Usuario("usu1", "pepa", "pepeEmail", PlanActivo.ANUAL, "pepPhone", p1);

		// 4 para añadir usuario
		//servicioUsuario.registrarUsuario(usu1);
		
		List<Usuario> usuarios = servicioUsuario.getRepo().getListaUsuarios();
		
		for (Usuario usuario : usuarios) {
			logger.info(usuario);
		}
		
		// 5
		//logger.info("Total planes :"+ servicioUsuario.contarNumUsuarioPlan(PlanActivo.VIP));
		
		// 6
		
		// 7 eliminar usario
		//logger.info("Filas afectadas: "+ servicioUsuario.eliminarPorDispositivo("android12"));
		
	}

}
=======
package controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.AppException;
import modelo.PlanActivo;
import modelo.Preferencias;
import modelo.Usuario;
import servicio.UsuarioService;


public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);

	public static void main(String[] args) throws AppException {
		
		UsuarioService servicioUsuario = new UsuarioService();
		
		// ejercicio 1
		logger.info(servicioUsuario.obtenerUsuarios());
		
		// ejercicio 2
		//logger.info(servicioUsuario.buscarUsuarioPorId("usr020"));
		Preferencias p1 = new Preferencias(false, "ingles", true, false);
		Usuario usu1 = new Usuario("usu1", "pepa", "pepeEmail", PlanActivo.ANUAL, "pepPhone", p1);

		// 4 para añadir usuario
		//servicioUsuario.registrarUsuario(usu1);
		
		List<Usuario> usuarios = servicioUsuario.getRepo().getListaUsuarios();
		
		for (Usuario usuario : usuarios) {
			logger.info(usuario);
		}
		
		// 5
		//logger.info("Total planes :"+ servicioUsuario.contarNumUsuarioPlan(PlanActivo.VIP));
		
		// 6
		
		// 7 eliminar usario
		//logger.info("Filas afectadas: "+ servicioUsuario.eliminarPorDispositivo("android12"));
		
	}

}
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
