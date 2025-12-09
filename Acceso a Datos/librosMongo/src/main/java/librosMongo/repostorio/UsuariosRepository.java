package librosMongo.repostorio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

import librosMongo.modelo.Asignacion;
import librosMongo.modelo.Lectura;
import librosMongo.modelo.Usuario;
import librosMongo.servicio.UsuarioService;
import utils.Genero;
import utils.Roles;
import utils.TipoUsuario;

public class UsuariosRepository {
	private static final Logger logger = LogManager.getLogger(UsuariosRepository.class);

	private static final String NOMBRE_COLECCION = "usuarios";
	private final MongoCollection<Document> coleccion;
	private List<Usuario> usuarios;

	public UsuariosRepository(MongoDatabase db) {
		this.coleccion = db.getCollection(NOMBRE_COLECCION);
		this.setUsuarios(this.read());
	}

	/*
	 * estuve mirando en internet y por cada metodo se mapeaba de documento a objeto
	 * y me parecia que se repetía mucho codigo asi que mejor jago un metodo que
	 * directamente pase a documento y lo uso en los metodos del crud (creo que asi
	 * no repito tanto)
	 * 
	 * es como el save pero no lo usamos para aññir solo para guardar el usuario en
	 * lo que usamos luego
	 */

	private Document UsuarioADocumento(Usuario u) {
		// Mapeo de LecturaActiva (Documento anidado)
		Document docLecturaActiva = new Document().append("id", u.getLecturaActiva().getId())
				.append("titulo", u.getLecturaActiva().getTitulo()).append("autor", u.getLecturaActiva().getAutor())
				.append("genero", u.getLecturaActiva().getGenero().toString())
				.append("progreso", u.getLecturaActiva().getProgreso());

		// Mapeo de LecturasAsignadas (Array de Documentos)
		List<Document> listDocAsignaciones = new ArrayList<>();
		if (u.getAsignacionesRecibidas() != null) {
			for (Asignacion a : u.getAsignacionesRecibidas()) {
				Document docAsignacion = new Document().append("id", a.getId()).append("idDocente", a.getIdDocente())
						.append("tituloAsignacion", a.getTituloAsignacion())
						.append("esObligatoria", a.isEsObligatoria()).append("codigoClase", a.getCodigoClase())
						.append("totalAlumnos", a.getTotalAlumnos());
				listDocAsignaciones.add(docAsignacion);
			}
		}

		// Creación del Documento principal del Usuario
		Document UsuarioDocumento = new Document("id", u.getId()).append("nombreCompleto", u.getNombreCompleto())
				.append("edad", u.getEdad()).append("esDocente", u.getEsDocente())
				.append("rolPrincipal", u.getRolPrincipal().toString()).append("puntosPorLogro", u.getPuntosPorLogro())
				.append("tipoUsuario", u.getTipoUsuario().toString()).append("lecturaActiva", docLecturaActiva)
				.append("lecturasAsignadas", listDocAsignaciones);

		return UsuarioDocumento;
	}

	// con el metodo anterior podemos o dejar asi el save o simplificarlo
	// ya que la funcion de arriba repite codigp

	public void save(Usuario u) {
		/*
		 * // guardamos en el usuario la lectura que tiene actualmente (clase Lectura)
		 * Document docLecturaActiva = new Document().append("id",
		 * u.getLecturaActiva().getId()) .append("titulo",
		 * u.getLecturaActiva().getTitulo()).append("autor",
		 * u.getLecturaActiva().getAutor()) .append("genero",
		 * u.getLecturaActiva().getGenero().toString()) .append("progreso",
		 * u.getLecturaActiva().getProgreso());
		 * 
		 * // lo mismo con asignaciones pero como es una lista se hace de esta forma (la
		 * // recorremos y agregamos por cada uno) List<Document> listDocAsignaciones =
		 * new ArrayList<>();
		 * 
		 * for (Asignacion a : u.getAsignacionesRecibidas()) { Document docAsignacion =
		 * new Document().append("id", a.getId()).append("idDocente", a.getIdDocente())
		 * .append("tituloAsignacion", a.getTituloAsignacion()).append("esObligatoria",
		 * a.isEsObligatoria()) .append("codigoClase",
		 * a.getCodigoClase()).append("totalAlumnos", a.getTotalAlumnos())
		 * .append("idLecturas", a.getIdLecturasReferencias());
		 * listDocAsignaciones.add(docAsignacion); }
		 * 
		 * // luego de lo anterior creamos el documento para guardar todo en el usuario
		 * Document doc = new Document("id", u.getId()).append("nombreCompleto",
		 * u.getNombreCompleto()) .append("edad", u.getEdad()).append("esDocente",
		 * u.getEsDocente()) .append("rolPrincipal",
		 * u.getRolPrincipal().toString()).append("puntosPorLogro",
		 * u.getPuntosPorLogro()) .append("tipoUsuario",
		 * u.getTipoUsuario().toString()).append("lecturaActiva", docLecturaActiva)
		 * .append("lecturasAsignadas", listDocAsignaciones);
		 * 
		 * // añadimos lo anterior
		 */

		Document doc = UsuarioADocumento(u);
		coleccion.insertOne(doc);
	}

	// ahora para leer lo que tenemos como documento de mongo lo pasamos a objeto
	// para que java lo lea
	public List<Usuario> read() {
		List<Usuario> usuarios = new ArrayList<>();
		FindIterable<Document> documentos = coleccion.find();

		for (Document doc : documentos) {
			Usuario u = new Usuario();

			u.setId(doc.getString("id"));
			u.setNombreCompleto(doc.getString("nombreCompleto"));
			u.setEdad(doc.getInteger("edad"));
			u.setEsDocente(doc.getBoolean("esDocente"));

			u.setRolPrincipal(Roles.valueOf(doc.getString("rolPrincipal")));

			u.setPuntosPorLogro(doc.getInteger("puntosPorLogro"));

			u.setTipoUsuario(TipoUsuario.valueOf(doc.getString("tipoUsuario")));

			Document lecturaActivaDoc = (Document) doc.get("lecturaActiva");
			if (lecturaActivaDoc != null) {
				Lectura lecturaActiva = new Lectura(lecturaActivaDoc.getString("id"),
						lecturaActivaDoc.getString("titulo"), lecturaActivaDoc.getString("autor"),
						Genero.valueOf(lecturaActivaDoc.getString("genero")),
						lecturaActivaDoc.get("progreso",Number.class).doubleValue());
				u.setLecturaActiva(lecturaActiva);
			}

			// para la lista de asignaciones, primero el documento
			// y luego la lista despues de pasar a objeto

			// primero decimos que es un documento
			List<Document> asignacionesDoc = (List<Document>) doc.get("lecturasAsignadas");

			// luego guardamos en la lista cada documento para ponerlo en clase
			List<Asignacion> listasAsignacion = new ArrayList<>();

			for (Document asignacionDoc : asignacionesDoc) {
				if (asignacionDoc != null) {
					Asignacion asignacion = new Asignacion(asignacionDoc.getString("id"),
							asignacionDoc.getString("idDocente"), asignacionDoc.getString("tituloAsignacion"),
							asignacionDoc.getBoolean("esObligatoria"), asignacionDoc.getString("codigoClase"),
							asignacionDoc.getInteger("totalAlumnos"));

					listasAsignacion.add(asignacion);
					u.setAsignacionesRecibidas(listasAsignacion);
				}
			}
			usuarios.add(u);
		}

		return usuarios;
	}

	// pasamos de documento a usuario para poder realizar consultas o filtros por
	// los objetos
	private Usuario DocumentoAUsuario(Document doc) {
		// guardamos en el usuario la lectura que tiene actualmente (clase Lectura)
		Usuario u = new Usuario();

		u.setId(doc.getString("id"));
		u.setNombreCompleto(doc.getString("nombreCompleto"));
		u.setEdad(doc.getInteger("edad"));
		u.setEsDocente(doc.getBoolean("esDocente"));
		u.setRolPrincipal(Roles.valueOf(doc.getString("rolPrincipal")));
		u.setPuntosPorLogro(doc.getInteger("puntosPorLogro"));
		u.setTipoUsuario(TipoUsuario.valueOf(doc.getString("tipoUsuario")));

		Document lecturaActivaDoc = doc.get("lecturaActiva", Document.class);
		if (lecturaActivaDoc != null) {
			Lectura lecturaActiva = new Lectura(lecturaActivaDoc.getString("id"), lecturaActivaDoc.getString("titulo"),
					lecturaActivaDoc.getString("autor"), Genero.valueOf(lecturaActivaDoc.getString("genero")),
					lecturaActivaDoc.get("progreso",Number.class).doubleValue());
			u.setLecturaActiva(lecturaActiva);
		}

		List<Document> asignacionesDoc = doc.getList("lecturasAsignadas", Document.class);
		List<Asignacion> listasAsignacion = new ArrayList<>();

		for (Document aDoc : asignacionesDoc) {
			if (aDoc != null) {
				Asignacion asignacion = new Asignacion(aDoc.getString("id"), aDoc.getString("idDocente"),
						aDoc.getString("tituloAsignacion"), aDoc.getBoolean("esObligatoria"),
						aDoc.getString("codigoClase"), aDoc.getInteger("totalAlumnos"));

				listasAsignacion.add(asignacion);
			}
		}
		u.setAsignacionesRecibidas(listasAsignacion);

		return u;
	}

	// CRUD (añadir, borrar, mostrar uno (get) y actualizar)

	// añadir usuario, como save pero seria más sencillo porque pasamos los datos
	// por el constructor y solo usamos add

	public void aniadirUsuario(Usuario usu) {

		Document usuario = UsuarioADocumento(usu);
		coleccion.insertOne(usuario);
		logger.info("usuario añadido");
	}

	// hacer una funcion de usuario a documento para poder usarlo en las otras
	// funciones que faltan
	// ya que para mostrar hacia falta de documento a usuario

	// borraramos el usuario que le mandemos, así no hay que buscar es más directo
	public void borrarUsuario(Usuario usu) {

		Document usuario = UsuarioADocumento(usu);
		coleccion.deleteOne(usuario);
		logger.info("usuario borrado");

	}

	// para esta funcion sería buscar un usuario por id que creo que es más sencillo
	public Usuario mostrarUsuario(String id) {

		// creamos el objeto usuario para buscar por el filtro luego
		Usuario usuaMostrar = null;

		Document buscarId = new Document("id", id);
		Document buscarSsuario = coleccion.find(buscarId).first();

		usuaMostrar = DocumentoAUsuario(buscarSsuario);
		
		return usuaMostrar;

	}

	// busca el usuario por id y con eso actualizamos lo que filtramos al nuevo
	// usuario
	public void actualizarUsuario(Usuario usu) {
		
		// busca el usuario por id y ya podremos modificar lo que queramos
		Document filtro = new Document("$set", UsuarioADocumento(usu));
		Document usuarioNuevo = new Document("id", usu.getId());
		coleccion.findOneAndUpdate(usuarioNuevo, filtro); 
		
		logger.info("usuario se actualizó");


	}

	// Filtrar y ordenar

	public List<Usuario> filtarEdad(int edad) {

		// como quiero que me devuelva todos los que tengan la misma edad lo tengo que
		// hacer por una lista

		List<Usuario> mismaEdad = new ArrayList<>();

		Document buscarEdad = new Document("edad", edad);

		// ahora la query de mongo
		FindIterable<Document> resltado = coleccion.find(buscarEdad);

		// recorremos la lista y guarde los que cumplan
		for (Document usuDoc : resltado) {

			Usuario usuario = DocumentoAUsuario(usuDoc);
			mismaEdad.add(usuario);

		}

		return mismaEdad;
	}

	// ordenamos por nombre

	public List<Usuario> ordenarNombre() {

		List<Usuario> ordenarNombre = new ArrayList<>();

		// el 1 es para que sea a-z si no sería -1
		Document filtroNombre = new Document("nombreCompleto", 1);

		// Ejecutar la consulta y aplicar el sort()
		FindIterable<Document> documentos = coleccion.find().sort(filtroNombre);

		// Recorrer y mapear a objetos Usuario
		for (Document doc : documentos) {
			Usuario u = DocumentoAUsuario(doc);
			ordenarNombre.add(u);
		}

		return ordenarNombre;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}