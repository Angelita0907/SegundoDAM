package controlador;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Asignacion;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Lectura;
import modelo.Logro;
import modelo.Usuario;
import service.ServicioLitMind;
import utils.Genero;
import utils.Roles;
import utils.TipoUsuario;

public class GestionaUsuarios {

	private static final Logger logger = LogManager.getLogger(GestionaUsuarios.class);

	public static void main(String[] args) {
		ServicioLitMind servicio = new ServicioLitMind();

		// 1. Usuarios (Para vincular a Estudiantes)
		Usuario usu1 = new Usuario("U001", 20, Roles.ESTUDIANTE, 0, TipoUsuario.BASICO, null);

		// 2. Docentes (Independiente en tu modelo actual)
		Docente doc1 = new Docente("Pedro", "26", "Mates");

		// 3. Lecturas
		Lectura lec1 = new Lectura("L001", "El Quijote", Genero.AVENTURA);

		// 4. Logros
		Logro log1 = new Logro("Gran Lector", "Leídas 5 lecturas");

		// 5. Estudiantes (Relación 1:1 con Usuario y N:M con Logros)
		// Usamos un Set para los logros como indica tu clase
		Set<Logro> logrosIniciales = new HashSet<>();
		logrosIniciales.add(log1);

		Estudiante est1 = new Estudiante(1, 500, usu1, logrosIniciales);

		// 6. Asignaciones (Relación 1:N con Docente y 1:N con Lectura)
		Asignacion asig1 = new Asignacion("ASIG001", true, "2A-2026", 25, doc1, lec1);

		// Guardar en orden de jerarquía
		servicio.getRepoUsuario().create(usu1);
		servicio.getRepoDocente().create(doc1);
		servicio.getRepoLectura().create(lec1);
		servicio.getRepoLogro().create(log1);

		// Ahora los dependientes
		servicio.getRepoEstudiante().create(est1);
		servicio.getRepoAsignacion().create(asig1);
	
	// probar consultas y comentar lo anterior para que no de problemas al ejecutar
	
	}

}
