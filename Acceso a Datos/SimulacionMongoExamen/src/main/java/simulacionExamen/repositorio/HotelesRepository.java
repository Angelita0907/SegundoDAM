
package simulacionExamen.repositorio;

import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import simulacionExamen.modelo.Habitacion;
import simulacionExamen.modelo.Hotel;
import simulacionExamen.modelo.Ubicacion;
import simulacionExamen.utils.Tipo;

public class HotelesRepository {

	private static final Logger logger = LogManager.getLogger(HotelesRepository.class);

	private static final String NOMBRE_COLECCION = "hoteles";
	private final MongoCollection<Document> coleccion;
	private List<Hotel> hotel;

	public HotelesRepository(MongoDatabase db) {
		this.coleccion = db.getCollection(NOMBRE_COLECCION);
	}

	private Document HotelADocumento(Hotel h) {

		// mapeo objeto coordenadas
		Document docCoordenadas = new Document().append("lan", h.getUbicacion().getCoordenadas().getLat()).append("lon",
				h.getUbicacion().getCoordenadas().getLon());

		// Mapeo de Ubicacion (Documento anidado)
		Document docUbicacion = new Document().append("calle", h.getUbicacion().getCalle())
				.append("numero", h.getUbicacion().getNumero())
				.append("codigoPostal", h.getUbicacion().getCodigoPostal()).append("coordenas", docCoordenadas);

		// Mapeo de LecturasAsignadas (Array de Documentos)
		List<Document> listaHabitaciones = new ArrayList<>();
		if (h.getHabitaciones() != null) {
			for (Habitacion a : h.getHabitaciones()) {
				Document docHabitaciones = new Document().append("tipo", h.getHabitaciones().toString())
						.append("precio", a.getPrecio()).append("capacidad", a.getCapacidad())
						.append("disponible", a.isDisponible());
				listaHabitaciones.add(docHabitaciones);
			}
		}

		// Creación del Documento principal del Usuario
		Document UsuarioDocumento = new Document("idHotel", h.getIdHotel()).append("nombre", h.getNombre())
				.append("estrellas", h.getEstrellas()).append("admiteMascotas", h.isAdmiteMascotas())
				.append("fechaApertura", h.getFechaApertura()).append("ubicacion", docUbicacion)
				.append("habitaciones", listaHabitaciones);

		return UsuarioDocumento;
	}

	private Hotel DocumentoAHotel(Document doc) {

		Hotel h = new Hotel();

		h.setIdHotel(doc.getString("idHotel"));
		h.setNombre(doc.getString("nombre"));
		h.setEstrellas(doc.getInteger("estrellas"));
		h.setAdmiteMascotas(doc.getBoolean("admiteMascotas"));
		h.setFechaApertura(doc.getString("fechaApertura"));

		/*
		 * Document coordenadas = doc.get("coordenadas", Document.class); if(coordenadas
		 * != null) { Coordenada coordenada = new
		 * Coordenada(coordenadas.get("lat",Number.class).doubleValue()
		 * ,coordenadas.get("lon", Number.class).doubleValue());
		 * h.getUbicacion().setCoordenadas(coordenada); }
		 */

		// ahora es ubicación
		Document ubicaciones = doc.get("ubicacion", Document.class);
		if (ubicaciones != null) {
			Ubicacion ubicacion = new Ubicacion(ubicaciones.getString("calle"), ubicaciones.getInteger("numero"),
					ubicaciones.getString("codigoPostal"));
			h.setUbicacion(ubicacion);
		}

		List<Document> habitacionesDoc = doc.getList("habitaciones", Document.class);
		List<Habitacion> listaHabitaciones = new ArrayList<>();

		for (Document hDoc : habitacionesDoc) {
			Habitacion habitacion = new Habitacion(Tipo.valueOf(hDoc.getString("tipo")),
					hDoc.get("precio", Number.class).doubleValue(), hDoc.getInteger("capacidad"),
					hDoc.getBoolean("disponible"));

			listaHabitaciones.add(habitacion);
		}

		h.setHabitaciones(listaHabitaciones);

		return h;
	}

	public void save(Hotel h) {

		Document doc = HotelADocumento(h);
		coleccion.insertOne(doc);

	}

	// lo mismo que pasar de documento a objeto
	public List<Hotel> read() {

		List<Hotel> hoteles = new ArrayList<>();
		FindIterable<Document> documentos = coleccion.find();

		for (Document document : documentos) {
			Hotel h = DocumentoAHotel(document);
			hoteles.add(h);
		}
		return hoteles;

	}

	// operaciones crud

	public void aniadirHotel(Hotel h) {

		Document hotel = HotelADocumento(h);
		InsertOneResult resultado = coleccion.insertOne(hotel);
		if (resultado.getInsertedId() != null)
			logger.debug("hotel añadido:", resultado.getInsertedId());

	}

	public void borrarHotel(Hotel h) {
		Document hotel = HotelADocumento(h);

		coleccion.deleteOne(hotel);
		logger.debug("hotel borrado");
	}

	public Hotel mostrarHotel(String id) {

		// creamos el objeto usuario para buscar por el filtro luego
		Hotel hotelMostrar = null;

		Document buscarId = new Document("idHotel", id);
		Document buscarHotel = coleccion.find(buscarId).first();

		hotelMostrar = DocumentoAHotel(buscarHotel);

		return hotelMostrar;

	}

	// hptpñes de 5 estrellas o con mascotas pero si o si en madrid

	public List<Hotel> filtrarHotelesMadrid() {

		List<Hotel> hoteles = new ArrayList<>();

		// Filtro: (estrellas = 5 OR admiteMascotas = true) AND ciudad = "Madrid"
		Document filtroHotel = new Document(
				new Document("$or", List.of(new Document("estrellas", 5), new Document("admiteMascotas", true))));

		Document hotelMadrid = new Document("ubicacion.calle", "Paseo del Río");

		Document filtro = new Document("$and", List.of(filtroHotel, hotelMadrid));

		FindIterable<Document> documentos = coleccion.find(filtro);

		for (Document document : documentos) {
			Hotel h = DocumentoAHotel(document);
			hoteles.add(h);
		}

		logger.debug("Hoteles encontrados: " + hoteles.size());
		return hoteles;
	}

	// hoteles minimo una habitacion suite junior

	public int filtroHabitaciones() {

		Document filtroHabitacion = new Document("habitaciones.tipo", "SUITEJUNIOR");

		int totalHoteles = (int) coleccion.countDocuments(filtroHabitacion);

		logger.info("El total de hoteles es: " + totalHoteles);

		return totalHoteles;
	}

	// dar id hotel añade nueva habitacion
	
	public long aniadirPorId(String id) {
		// 1. DEFINIR EL FILTRO (Quién queremos actualizar)
        // Buscamos el hotel por su ID. Asumimos que el campo clave se llama "id".
        Document filtro = new Document("idHotel", id);
     // 2. DEFINIR EL NUEVO OBJETO (Qué vamos a añadir)
        // Creamos el documento que representa la nueva habitación Penthouse.
        Document nuevaHabitacion = new Document("tipo", "Penthouse")
                                    .append("precio", 500.00)
                                    .append("capacidad", 4)
                                    .append("disponible", true);

     // 3. DEFINIR LA ACTUALIZACIÓN (Cómo lo vamos a añadir)
        // Usamos el operador $push para añadir 'nuevaHabitacion' al array 'habitaciones'.
        Document actualizacion = new Document("$push", 
            new Document("habitaciones", nuevaHabitacion)
        );

     // 4. EJECUTAR LA OPERACIÓN
        // Llamamos a updateOne() con el filtro y la actualización.
        UpdateResult resultado = coleccion.updateOne(filtro, actualizacion);

        return resultado.getModifiedCount();
	} 

	// actualizar codigo postal de la calle "gran via"
	
	public void updatecodioPostal(String nuevoCP) {
		
		Document filtroCalle = new Document("ubicacion.calle", "Avenida del Mar");
		
		// necesitamos el set para poder cambiar los datos
		Document updateCP = new Document("$set", 
		        new Document("ubicacion.codigoPostal", nuevoCP)
		    );
		
		UpdateResult resultado = coleccion.updateMany(filtroCalle, updateCP);
		
		logger.debug("Se ha cambiado el codigo: "+resultado);
		
	}

	// localiza hotel "h101" update precio indiviual a 90
	
	public void updatePrecioIndividual() {
		
		Document filtroPrecio = new Document("idHotel", "h101")
				.append("habitaciones.tipo", Tipo.INDIVIDUAL.toString());
		
		Document actualizacion = new Document("$set", 
		        new Document("habitaciones.$.precio", 90) // Aquí se usa 90.00
		    );
		
		coleccion.updateOne(filtroPrecio, actualizacion);
		
	}
	
	
	// elimina de habitaciones mayor 300 en hotel "Gran hotel central"
	
	public void deleteHabitaciones(String nombre) {
		UpdateResult resultado = coleccion.updateOne(
	            Filters.eq("nombre", nombre),
	            Updates.pull("habitaciones", Filters.gt("precio", 300.00))
	    );
		
		logger.debug("Se ha borrado la habitación: "+ resultado);

	}


	// media de estrellas en barcelona
	
	

}
