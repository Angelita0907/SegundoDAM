package simulacionExamen.servicio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.internal.bulk.UpdateRequest;

import simulacionExamen.modelo.Hotel;
import simulacionExamen.repositorio.HotelesRepository;


public class HotelesServicio {

	private static final Logger logger = LogManager.getLogger(HotelesServicio.class);

	
	private final HotelesRepository repo;


	public HotelesServicio(MongoDatabase db) {
		this.repo = new HotelesRepository(db);
	}
	
	public void save(Hotel h) {
		// Aquí podrías añadir validaciones, reglas de negocio, etc.
		repo.save(h);
	}
	
	public List<Hotel> read() {
		return repo.read();
	}
	
	public void addHotel(Hotel hotelNuevo) {
		repo.aniadirHotel(hotelNuevo);
	}
	
	public void deleteHotel(Hotel delHotel) {
		repo.borrarHotel(delHotel);
	}
	
	public Hotel mostrarHotel(String id) {
		return repo.mostrarHotel(id);
	}
	
	public List<Hotel> filtrarHotelesMadrid(){
		return repo.filtrarHotelesMadrid();
	}
	
	public int filtroHabitaciones() {
		
		return repo.filtroHabitaciones();
		
	}
	
	public void updatecodioPostal(String nuevoCP) {
		
		repo.updatecodioPostal(nuevoCP);
		
	}
	
	public long aniadirPorId(String id) {
		return repo.aniadirPorId(id);
	}
	
	public void deleteHabitaciones(String nombre) {
		 repo.deleteHabitaciones(nombre);
	}
	
}
