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

import modelo.Equipo;
import modelo.Piloto;

public class Formula1XMLDom {
	
	private static final Logger logger = LogManager.getLogger(Formula1XMLDom.class);
	private static final String rutaResources = "src\\main\\resources\\";
	
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
	
	private Piloto getPilotoFromElement(Element elemento)
	{
			Piloto p = new Piloto();
			int identificadorPiloto = Integer.parseInt(elemento.getAttribute("identificadorPiloto"));
			String nombrePiloto = elemento.getElementsByTagName("nombrePiloto").item(0).getTextContent();
		    int puntos = Integer.parseInt(elemento.getElementsByTagName("puntos").item(0).getTextContent());
		    int identificadorEquipo = Integer.parseInt(elemento.getElementsByTagName("identificadorEquipo").item(0).getTextContent());
		    String pais = elemento.getElementsByTagName("pais").item(0).getTextContent();
			// se usa atribute porque id es una etiqueta de empleado
			//String id = elemento.getAttribute("identificador"); // La etiqueta empleado tiene el atributo identificador
			
			p.setIdentificadorPiloto(identificadorPiloto);
			p.setNombre(nombrePiloto);
			p.setPuntos(puntos);
			p.setIdentificadorEquipo(identificadorEquipo);
			p.setPais(pais);
			
			return p;
		}
	
	public List<Piloto> leerPilotosDesdeXML(String rutaFichero) throws Exception {
		List<Piloto> pilotos = new ArrayList<Piloto>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodoProductos = doc.getElementsByTagName("piloto");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodoProductos.getLength(); j++) {
			Node modeloNodo = nodoProductos.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				// esto es un casting para saber si se puede cambiar de un tipo nodo
				Piloto p = this.getPilotoFromElement((Element) modeloNodo);
				pilotos.add(p);
			}
		}
		return pilotos;
	}
	
	// lo mismo pero con equipos
	
	private Equipo getEquipoFromElement(Element elemento)
	{
			Equipo e = new Equipo();
			int identificadorEquipo = Integer.parseInt(elemento.getAttribute("identificadorEquipo"));
			String nombreEquipo = elemento.getElementsByTagName("nombreEquipo").item(0).getTextContent();
		    int puntos = Integer.parseInt(elemento.getElementsByTagName("puntos").item(0).getTextContent());
		    
			// se usa atribute porque id es una etiqueta de empleado
			//String id = elemento.getAttribute("identificador"); // La etiqueta empleado tiene el atributo identificador
			
			e.setIdentificadorEquipo(identificadorEquipo);
			e.setNombreEquipo(nombreEquipo);
			e.setPuntos(puntos);
			
			return e;
		}
	
	public List<Equipo> leerEquiposDesdeXML(String rutaFichero) throws Exception {
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
				Equipo e = this.getEquipoFromElement((Element) modeloNodo);
				equipos.add(e);
			}
		}
		return equipos;
	}

}
