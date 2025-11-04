package tema1.XML.controlador;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tema1.XML.Peliculas.XMLDomPeliculas;
import tema1.XML.modelo.Pelicula;

public class GestionaPeliculas {

	private static final Logger logger = LogManager.getLogger(GestionaEmpledoXML.class);

	public static void main(String[] args) {
		
		XMLDomPeliculas xmlPeliculas = new XMLDomPeliculas();
		
		try {
			//List<Empleado> e = xmlEmpleado.leerEmpleadosDesdeXML("empleados2.xml");
			// lo que hace es escribir el empleado en el logger
			
			List<Pelicula> p = xmlPeliculas.leerPeliculasDesdeXML("peliculas.xml");
			
			logger.info(p);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}