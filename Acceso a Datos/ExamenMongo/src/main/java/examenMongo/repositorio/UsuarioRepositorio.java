package examenMongo.repositorio;

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
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import examenMongo.modelo.Evento;
import examenMongo.modelo.Preferencias;
import examenMongo.modelo.Usuario;
import examenMongo.utils.PlanActivo;

public class UsuarioRepositorio {

	private static final Logger logger = LogManager.getLogger(UsuarioRepositorio.class);

	private static final String NOMBRE_COLECCION = "usuarios";
	private final MongoCollection<Document> coleccion;
	private List<Usuario> usuarios;

	public UsuarioRepositorio(MongoDatabase db) {
		this.coleccion = db.getCollection(NOMBRE_COLECCION);
	}

	// pasamos de objeto a documento

	private Document UsuarioADocumento(Usuario u) {

		// documento preferencias

		Document docPreferencias = new Document().append(("tema_oscuro"), u.getPreferencias().isTema_oscuro())
				.append("idioma", u.getPreferencias().getIdioma())
				.append("notificaciones_push", u.getPreferencias().isNotificaciones_push())
				.append("limite_datos_moviles", u.getPreferencias().isLimite_datos_moviles());

		// lista de logs eventos

		List<Document> listaEventos = new ArrayList<>();

		if (u.getLogs_eventos() != null) {

			for (Evento e : u.getLogs_eventos()) {

				Document docEventos = new Document().append("id_evento", e.getId_evento()).append("tag", e.getTag())
						.append("mensaje", e.getMensaje()).append("timestamp", e.getTimestamp());

				listaEventos.add(docEventos);

			}

		}

		// documento usuarios

		Document usuarioDocumento = new Document().append("id", u.getId()).append("username", u.getUsername())
				.append("email", u.getEmail()).append("plan_activo", u.getPlan_activo())
				.append("dispositivo", u.getDispositivo()).append("preferencias", docPreferencias)
				.append("eventosLogs", listaEventos);
		return usuarioDocumento;

	}

	private Usuario DocumentoAUsuario(Document doc) {

		Usuario u = new Usuario();

		u.setId(doc.getString("id"));
		u.setUsername(doc.getString("username"));
		u.setEmail(doc.getString("email"));
		u.setPlan_activo(PlanActivo.valueOf(doc.getString("plan_activo")));
		u.setDispositivo(doc.getString("dispositivo"));

		Document preferencias = doc.get("prefencias", Document.class);
		if (preferencias != null) {
			Preferencias preferencia = new Preferencias(preferencias.getBoolean("tema_oscuro"),
					preferencias.getString("idioma"), preferencias.getBoolean("notificaciones_push"),
					preferencias.getBoolean("notificaciones_push"));
			u.setPreferencias(preferencia);
		}

		List<Document> eventosDoc = doc.getList("eventosLogs", Document.class);
		List<Evento> listaeventos = new ArrayList<>();

		for (Document edoc : eventosDoc) {

			Evento evento = new Evento(edoc.getString("id_evento"), edoc.getString("tag"), edoc.getString("mensaje"),
					edoc.getString("timestamp"));

			listaeventos.add(evento);

		}
		u.setLogs_eventos(listaeventos);

		return u;

	}

	public void save(Usuario u) {
		Document doc = UsuarioADocumento(u);
		coleccion.insertOne(doc);
	}

	public List<Usuario> read() {

		List<Usuario> listaUsuarios = new ArrayList<>();
		FindIterable<Document> documentos = coleccion.find();

		for (Document document : documentos) {
			Usuario u = DocumentoAUsuario(document);
			listaUsuarios.add(u);
		}

		return listaUsuarios;

	}

	// mostrar documentos ordenador por plan activo descenciente y email ascendente
	
	public List<Usuario> ordenarPorPlanEmail(){
		
		List<Usuario> usuariosOrdenados = new ArrayList<>();
		
		Document fltroPlan = new Document("plan_activo", -1);
		Document fltroEmail = new Document("email", 1);
		
		Document filtroCompleto = new Document("$and", List.of(fltroPlan, fltroEmail));
		
		FindIterable<Document> documentos = coleccion.find(filtroCompleto);
		
		for (Document document : documentos) {
			Usuario u = DocumentoAUsuario(document);
			usuariosOrdenados.add(u);
		}
		
		logger.debug("Lista ordenada: "+usuariosOrdenados);
		
		return usuariosOrdenados;
		
	}

	// añadir por objeto usuario

	public void aniadirUsuario(Usuario usu) {

		Document usuario = UsuarioADocumento(usu);
		InsertOneResult resultado = coleccion.insertOne(usuario);
		// fatlta execpcion
		logger.debug("usuario añadido" + resultado);
	}

	// busqueda por id

	public Usuario mostrarUsuario(String id) {

		// creamos el objeto usuario para buscar por el filtro luego
		Usuario usuaMostrar = null;

		Document buscarId = new Document("id", id);
		Document buscarUsuario = coleccion.find(buscarId).first();

		usuaMostrar = DocumentoAUsuario(buscarUsuario);

		logger.info(usuaMostrar);

		return usuaMostrar;

	}

	// actulizar idioma Es a ESP

	public void updateIdiomaEspanol(String idioma) {
		Document filtroIdioma = new Document("preferencias.idioma", "ES");

		Document actualizarIdoma = new Document("$set", new Document("preferencias.idioma", idioma));

		UpdateResult resultadoActu = coleccion.updateMany(filtroIdioma, actualizarIdoma);

		logger.debug("Se han actualizado: " + resultadoActu);
	}

	// elimiinar registros del plan anual
	public void eliminarPlanAnual(PlanActivo plan) {

		// no lo boora
		
		UpdateResult resultado = coleccion.updateOne(
				Filters.eq("plan_activo", PlanActivo.ANUAL.toString()),
				Updates.pull("usuarios", Filters.gt("plan_activo", plan)));
				

		
		/*Document filtroPlan = new Document("plan_activo", plan);
		 
		Document eliminarPlan = new Document("$set", new Document("plan_activo",filtroPlan)); 
		 
		DeleteResult resultado = coleccion.deleteMany(eliminarPlan);
		 */

		logger.debug("Se han borrado los planes: " + resultado);

	}

	// recupera los 3 primeros co las siguientes condiciones
	
	

	// usuarios vip, modifica campo_limite a true

	public void updateDatosMoviles() {
		
		Document filtroPlan = new Document("plan_activo", "VIP");
		
		Document actualizarDatos = new Document("$set", 
				new Document("preferencias.limite_datos_moviles", true));
		// cambiar
		UpdateResult resultado = coleccion.updateMany(filtroPlan, actualizarDatos);
		
		logger.debug("Se han actualizado los datos moviles: " + resultado);
	}
	
	
	// añadir nuevo eventto al usuario usr008
	
	public void aniadirPorid(String id) {
		
		Document buscarUsu = new Document("id", id);
		
		Document nuevoEvento = new Document("eventosLogs.id_evento", "ev_121")
				.append("eventosLogs.tag", "GPS")
				.append("eventosLogs.mensaje", "Señal de GPS adquirida")
				.append("eventosLogs.timestamp", "2024-02-12T08:21:00Z");
		
		Document aniadir = new Document("$push", 
				new Document("eventosLogs", nuevoEvento));
		
		UpdateResult resultado = coleccion.updateOne(buscarUsu, aniadir);
		
		logger.debug("Se ha añadido: "+ resultado);
		
	}
	

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
