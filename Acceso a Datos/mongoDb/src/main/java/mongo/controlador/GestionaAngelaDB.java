package mongo.controlador;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mongo.config.MongoDBConexion;
import mongo.modelo.Estudiante;
import mongo.repositorio.EstudianteService;

public class GestionaAngelaDB {
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
		
		EstudianteService estudianteS = new EstudianteService(db);
		
		Estudiante e1 = new Estudiante(22, "Maria Pelaéz", 7.78, List.of("leer", "nadar"), 22, "email");
		estudianteS.save(e1);
		
		List<Estudiante> estudintes = estudianteS.read();
		for (Estudiante e : estudintes) {
			System.out.println(e);
		}
	
//TODO Aquí creamos los diferentes servicios a partir del objeto db	
	}


}
