<<<<<<< HEAD
package simulacionExamen.config;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

// sirve para conectar con nuestra base de datos
public class MongoDBConexion {
	private static final Logger logger = LogManager.getLogger(MongoDBConexion.class);
	private MongoDatabase db;

	public MongoDBConexion() {
		Propiedades propiedades;
		try {
			propiedades = new Propiedades("app.properties");
			String ruta = propiedades.get("mongodb.uri");
			String baseDatos = propiedades.get("mongodb.database");
			MongoClient client = MongoClients.create(ruta);
			this.db = client.getDatabase(baseDatos);
			logger.debug("Conectado a la BD: " + db.getName());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	public MongoDatabase getDb() {
		return db;
	}
}
=======
package simulacionExamen.config;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

// sirve para conectar con nuestra base de datos
public class MongoDBConexion {
	private static final Logger logger = LogManager.getLogger(MongoDBConexion.class);
	private MongoDatabase db;

	public MongoDBConexion() {
		Propiedades propiedades;
		try {
			propiedades = new Propiedades("app.properties");
			String ruta = propiedades.get("mongodb.uri");
			String baseDatos = propiedades.get("mongodb.database");
			MongoClient client = MongoClients.create(ruta);
			this.db = client.getDatabase(baseDatos);
			logger.debug("Conectado a la BD: " + db.getName());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	public MongoDatabase getDb() {
		return db;
	}
}
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
