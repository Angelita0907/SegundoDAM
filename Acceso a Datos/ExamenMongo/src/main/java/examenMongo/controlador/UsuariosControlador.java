package examenMongo.controlador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import examenMongo.config.MongoDBConexion;
import examenMongo.modelo.Usuario;
import examenMongo.servicio.UsuariosServicio;
import examenMongo.utils.PlanActivo;

public class UsuariosControlador {
	
	private static final Logger logger = LogManager.getLogger(UsuariosControlador.class);

	public static void main(String[] args) {
		
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
		
		UsuariosServicio servicioUsuarios = new UsuariosServicio(db);
		
		servicioUsuarios.read();
		
		// 1. ordenar (no funciona del todo bien)
		servicioUsuarios.ordenarPorPlanEmail();
		
		// 2. aladir usu
		
		Usuario usu1 = new Usuario(null, null, null, null, null, null, null);
		servicioUsuarios.addUsuario(usu1);
		
		// 3. buscar usuario
		servicioUsuarios.buscarUsuario("usr002");	
		
		// 4. actualizar idioma
		servicioUsuarios.updateIdiomaEspanol("ESP");
		
		// 5. eliminar documento segun plan (no consigo que borre)
		servicioUsuarios.deletePlanAnual(PlanActivo.ANUAL);
		
		// 6
		
		// 7. mofidicar campos movil
		servicioUsuarios.updateDatosMoviles();

		// 8. añadir evento por id
		servicioUsuarios.aniadirPorid("usr008");
		
	}

}
