package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modelo.Enfrentamiento;
import modelo.Equipo;
import modelo.TipoVideoJuego;
import repositorio.RepositorioEnfretamientos;
import repositorio.RepositorioEquipos;



public class TorneoDomXML {
	
	private static final Logger logger = LogManager.getLogger(TorneoDomXML.class);
	private static final String rutaResources = "src\\main\\resources\\";
	
	RepositorioEquipos repoEquipo;
	
	// este siempre es igual para todos
	// para generar el dom del xml
	private Document getDocumentFromXML(String nombrefichero) {
		File file = new File(rutaResources + nombrefichero);
		Document documento = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			documento = dBuilder.parse(file);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return documento;
	} 
	
	// primero leemos piloto y creamos el árbol con su lista
	// porque no pertence directamente al equipo cada uno por su lado
	
	private Equipo getEquipoFromElement(Element elemento)
	{
			Equipo eq = new Equipo();
			
			String codigo = elemento.getAttribute("codigo");
			String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
			String email = elemento.getElementsByTagName("email").item(0).getTextContent();
			int numJugadores = Integer.parseInt(elemento.getElementsByTagName("numJugadores").item(0).getTextContent());
			
			// se usa atribute porque id es una etiqueta de empleado
			//String id = elemento.getAttribute("identificador"); // La etiqueta empleado tiene el atributo identificador
			
			eq.setCodigo(codigo);
			eq.setNombre(nombre);
			eq.setEmailContacto(email);
			eq.setNumJugadores(numJugadores);
			
			return eq;
		}
	
	public List<Equipo> leerEquipoDesdeXML(String rutaFichero) throws Exception {
		List<Equipo> equipos = new ArrayList<Equipo>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodoProductos = doc.getElementsByTagName("equipo");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodoProductos.getLength(); j++) {
			Node modeloNodo = nodoProductos.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				// esto es un casting para saber si se puede cambiar de un tipo nodo
				Equipo eq = this.getEquipoFromElement((Element) modeloNodo);
				equipos.add(eq);
			}
		}
		return equipos;
	}
	
	// lo mismo pero con equipos
	
	private Enfrentamiento getEnfrentamientoFromElement(Element elemento)
	{
			Enfrentamiento e = new Enfrentamiento();
			int id = Integer.parseInt(elemento.getAttribute("id"));
			String fecha = elemento.getElementsByTagName("fecha").item(0).getTextContent();
			String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();
		    TipoVideoJuego videojuego = TipoVideoJuego.valueOf(elemento.getElementsByTagName("videojuego").item(0).getTextContent()); 
		    
		    /*Equipo equipo = this.getEquipoFromElement(elemento);
		    
		    Equipo ganador = elemento.getAttribute(equipo.getCodigo());*/
			// se usa atribute porque id es una etiqueta de empleado
			//String id = elemento.getAttribute("identificador"); // La etiqueta empleado tiene el atributo identificador
			
		    String ganador = elemento.getAttribute("codigoRef");
		    
		    e.setId(id);
			e.setFecha(fecha);
			e.setDescripcion(descripcion);
		    e.setVideojuego(videojuego);
		    //e.setEquipoGanador(ganador);
		    e.setEquipoGanador(ganador);
		    e.setDescripcion(descripcion);
			
			return e;
		}
	
	public List<Enfrentamiento> leerEnfrentamientoDesdeXML(String rutaFichero) throws Exception {
		List<Enfrentamiento> enfrentamientos = new ArrayList<Enfrentamiento>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodoProductos = doc.getElementsByTagName("enfrentamiento");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodoProductos.getLength(); j++) {
			Node modeloNodo = nodoProductos.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				// esto es un casting para saber si se puede cambiar de un tipo nodo
				Enfrentamiento e = this.getEnfrentamientoFromElement((Element) modeloNodo);
				enfrentamientos.add(e);
			}
		}
		return enfrentamientos;
	}

}

