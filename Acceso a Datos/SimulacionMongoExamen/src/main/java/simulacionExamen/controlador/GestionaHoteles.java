package simulacionExamen.controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;

import simulacionExamen.config.MongoDBConexion;
import simulacionExamen.modelo.Hotel;
import simulacionExamen.servicio.HotelesServicio;

public class GestionaHoteles {

	private static final Logger logger = LogManager.getLogger(GestionaHoteles.class);
	
	public static void main(String[] args) {
		
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
		
		HotelesServicio servicioHotel = new HotelesServicio(db);
		
		List<Hotel> listaHoteles = servicioHotel.read();
		
		for (Hotel hotel : listaHoteles) {
			logger.info(hotel);
		}
		
		//logger.info(servicioHotel.mostrarHotel("h105"));
		
		//logger.info(servicioHotel.filtrarHotelesMadrid());
		
		servicioHotel.filtroHabitaciones();
		
		servicioHotel.updatecodioPostal("41015");
		
		servicioHotel.deleteHabitaciones("Gran hotel central");
		
	}
	
}
