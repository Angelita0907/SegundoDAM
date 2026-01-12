package tema1.XML.controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tema1.XML.XMLDomEmpleado;
import tema1.XML.modelo.Empleado;

public class GestionaEmpledoXML {
	
	private static final Logger logger = LogManager.getLogger(GestionaEmpledoXML.class);

	public static void main(String[] args) {
		
		XMLDomEmpleado xmlEmpleado = new XMLDomEmpleado();
		
		try {
			List<Empleado> e = xmlEmpleado.leerEmpleadosDesdeXML("empleados2.xml");
			// lo que hace es escribir el empleado en el logger
			logger.info(e);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
