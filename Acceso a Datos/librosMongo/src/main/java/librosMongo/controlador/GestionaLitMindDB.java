package librosMongo.controlador;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import librosMongo.config.MongoDBConexion;
import librosMongo.modelo.Asignacion;
import librosMongo.modelo.Lectura;
import librosMongo.modelo.Usuario;
import librosMongo.servicio.UsuarioService;
import utils.Genero;
import utils.Roles;
import utils.TipoUsuario;


public class GestionaLitMindDB {
	
	private static final Logger logger = LogManager.getLogger(UsuarioService.class);
	
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
		
		// instanciamos los objetos
		UsuarioService usuarioService = new UsuarioService(db);
		
		// creamos una lista de asignaciones porsi realizamos varias para el mismo usuario
		List<Asignacion> listaAsignaciones = new ArrayList<>();
		
		Asignacion asig1 = new Asignacion("ASG-001", "DOC-001", "Tarea de Poesía", true, "LIT-101", 30);
		Asignacion asig2 = new Asignacion("ASG-002", "DOC-002", "Tarea de Comprensión", true, "LIT-104", 15);

		listaAsignaciones.add(asig1);
		listaAsignaciones.add(asig2);
		
		// creamos varias lecturas
		
		Lectura lec1 = new Lectura("LEC-100", "Crónicas de un Viajero", "A. Sharma", Genero.CIENCIA_FICCION, 68.5f);
		Lectura lec2 = new Lectura("LEC-101", "Introducción a Java", "M. Torres", Genero.TECNICO, 15.0f);
		Lectura lec3 = new Lectura("LEC-102", "El Jardín Secreto", "F. Hodgson", Genero.AVENTURA, 99.0f);

		// varios usuarios y les puse las mismas pruebas para acortar código
		
		Usuario u1 = new Usuario("USR-001", "Roberto Gómez", 17, false, Roles.ESTUDIANTE, 50, TipoUsuario.AVANZADO, lec1, listaAsignaciones);		
		Usuario u2 = new Usuario("USR-002", "Ana Martínez", 22, false, Roles.PADRES, 10, TipoUsuario.BASICO, lec2, listaAsignaciones);
		Usuario u3 = new Usuario("USR-003", "Carlos Pérez", 17, true, Roles.PROFESOR, 200, TipoUsuario.AVANZADO, lec3, listaAsignaciones);
		
		
		// añadimos usuarios 
		/*
		usuarioService.addUsuario(u1);
		usuarioService.addUsuario(u2);
		usuarioService.addUsuario(u3);
		*/
		
		// borrar usuario --> borramos usuario dos (Ana)
		//usuarioService.deleteUsuario(u2);
		
		// mostrar usuario
		// logger.info(usuarioService.mostrarUsuario("USR-001"));
		
		// actualiza usuario --> elegimos que cambiar el que mostramos antes
		// creamos los valores nuevos y luego lo cambiamos por el usuario con el id --> USR-1001
		
		/*u3.setNombreCompleto("Pedro Pérez");
		usuarioService.updateUsuario(u3);*/
		
		// filtramos por edad
		// logger.info(usuarioService.filtrarPorEdad(17));
		
		// ordenamos por nombre
		// logger.info(usuarioService.ordenarPorNombre());
		
		// filtramos tipo usuario
		// logger.info(usuarioService.filtrarTipoUsuario(TipoUsuario.AVANZADO));
		
		// ordenamos por puntos descendente
		// logger.info(usuarioService.ordenaPuntosLogros());
	
	}


}
