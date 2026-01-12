package mongo.config;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// lee de un fichero las propiedades del fihcerp

public class Propiedades {
	private final static String rutaResources = "src\\main\\resources\\";
	
	private static final Logger logger = LogManager.getLogger(Propiedades.class);
	
	private Properties props = new Properties();

	public Propiedades(String nombreFichero) throws IOException {
		props.load(new FileInputStream(rutaResources + nombreFichero));
	}

	public String get(String key) {
		return props.getProperty(key);
	}
}
