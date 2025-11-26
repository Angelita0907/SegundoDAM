package mongo.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import mongo.modelo.Direccion;
import mongo.modelo.Estudiante;
import mongo.modelo.Score;

public class EstudianteRepositorio {

	private static final String NOMBRE_COLECCION = "estudiantes";
	private final MongoCollection<Document> coleccion;
	private List<Estudiante> estudiantes;

	public EstudianteRepositorio(MongoDatabase db) {
		this.coleccion = db.getCollection(NOMBRE_COLECCION);
		this.setEstudiantes(this.read());
	}

	// asi se escribe un objeto estudiante de la base de datos (documento = filas)
	public void save(Estudiante e) {
		Document docAddress = new Document().append("city", e.getAddress().getCity())
				.append("zip", e.getAddress().getZip()).append("street", e.getAddress().getStreet())
				.append("number", e.getAddress().getNumber());

		List<Document> listDocum = new ArrayList<>();
		for (Score s : e.getScore()) {
			Document docScore = new Document().append("score", s.getScore()).append("type", s.getType());
			listDocum.add(docScore);
		}

		Document doc = new Document("id", e.getId()).append("name", e.getName()).append("notaMedia", e.getNotaMedia())
				.append("aficiones", e.getCursos()).append("address", docAddress).append("scores", listDocum);
		coleccion.insertOne(doc);

		// ahora creamos un nuevo documento para recorrer las direcciones y las
		// puntuaciones

	}

	public List<Estudiante> read() {
		List<Estudiante> estudiantes = new ArrayList<>();
		FindIterable<Document> documentos = coleccion.find();
		for (Document doc : documentos) {

			// para las direcciones
			Estudiante e = new Estudiante();

			Document addressDoc = (Document) doc.get("address");
			if (addressDoc != null) {
				Direccion address = new Direccion(
						addressDoc.getString("city"), 
						addressDoc.getInteger("zip"),
						addressDoc.getString("street"),
						addressDoc.getInteger("number"));
				// lo seteamos aqui en caso de que de nulo
				e.setAddress(address);
			}

			// para las puntuaciones

			List<Document> scoresDoc = (List<Document>) doc.get("scores");

			List<Score> listascore = new ArrayList<>();

			for (Document s : scoresDoc) {
				if (s != null) {
					Score score = new Score(
							s.getDouble("score"), 
							s.getString("type"));

					listascore.add(score);
					e.setScore(listascore);
					
				}
			}

			e.setId(doc.getInteger("id", 0));
			e.setName(doc.getString("name"));
			e.setNotaMedia(doc.getDouble("notaMedia"));
			List<String> cursos = doc.getList("aficiones", String.class);
			// e.setCursos(cursos);

			// (cursos != null ? cursos : new ArrayList<>());
			estudiantes.add(e);
		}
		return estudiantes;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

}
