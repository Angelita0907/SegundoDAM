package tema1.Json.Ejemplo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ManejaJson;

public class GestionaEmpleadoJson {

	private static final Logger logger = LogManager.getLogger(GestionaEmpleadoJson.class);
	
	public static void main(String[] args) {
		
		List<Empleado> listaEmpleado = new ArrayList<Empleado>();
		
		ManejaJson gestiona = new ManejaJson();

		String ruta = "src\\main\\resources\\Empleado.json";
		
		gestiona.leeEmpleados(ruta);
		
	}

}
