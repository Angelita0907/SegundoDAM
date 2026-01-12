package mongo.controlador;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mongo.config.MongoDBConexion;
import mongo.modelo.Direccion;
import mongo.modelo.Estudiante;
import mongo.modelo.Score;
import mongo.servicio.EstudianteService;

public class GestionaAngelaDB {
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
		
		Direccion d1 = new Direccion("Sevilla", 41220, "Calle A", 5);
		
		List<Score> listacores = new ArrayList<>();
		
		Score s1 = new Score(6.5, "examen");
		listacores.add(s1);
		
		EstudianteService estudianteS = new EstudianteService(db);
		
		/*Estudiante e1 = new Estudiante(22, "Maria Pelaéz", null, null, 7.78, List.of("leer", "nadar"), 22, "email");
		estudianteS.save(e1);*/
		
		Estudiante e2 = new Estudiante(15, "Felipe Felipez", d1,listacores , 7.78, List.of("leer", "fumar"));
		estudianteS.save(e2);
		
		// para tener la lista de estudiantes
		List<Estudiante> estudiantes = estudianteS.getRepo().getEstudiantes();
		
		
		List<Estudiante> estudintes = estudianteS.read();
		for (Estudiante e : estudintes) {
			System.out.println(e);
		}
	
//TODO Aquí creamos los diferentes servicios a partir del objeto db	
	}


}
