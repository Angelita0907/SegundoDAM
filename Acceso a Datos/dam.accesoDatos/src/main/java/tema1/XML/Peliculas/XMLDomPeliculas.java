package tema1.XML.Peliculas;

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

import tema1.XML.modelo.Empleado;
import tema1.XML.modelo.Pelicula;

public class XMLDomPeliculas {
	
	private static final Logger logger = LogManager.getLogger(XMLDomPeliculas.class);
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
	
	private  Pelicula getPeliculaFromElement(Element elemento)
	{
			Pelicula p = new Pelicula();
			String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
			int fecha = Integer.parseInt(elemento.getElementsByTagName("Fecha").item(0).getTextContent());
			String director = elemento.getElementsByTagName("Director").item(0).getTextContent();
						
			// se usa atribute porque id es una etiqueta de empleado
			//String id = elemento.getAttribute("identificador"); // La etiqueta empleado tiene el atributo identificador
			
			p.setTitulo(titulo);
			p.setFecha(fecha);
			p.setDirector(director);
			
			Node a = elemento.getElementsByTagName("Actores").item(0);
			if(a != null && a.getNodeType() == Node.ELEMENT_NODE) {
				p.setActores(this.getActoresFromElemento((Element)a));
			}
			return p;
		}
	
	// recorra los elementos de acotres y los guarde en otra lista para poder luego pasarlo a lectura
	private List<String> getActoresFromElemento(Element elemento){
		
		List<String> listaActores = new ArrayList<>();
		
		NodeList actorNodo = elemento.getElementsByTagName("Actor");

		for (int j = 0; j < actorNodo.getLength(); j++) {
			Node modeloNodo = actorNodo.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				
				Element hijo = (Element) modeloNodo;
				
				listaActores.add(hijo.getFirstChild().getNodeValue());
			}
		}
		
		return listaActores;
	}
	
	public List<Pelicula> leerPeliculasDesdeXML(String rutaFichero) throws Exception {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosPeliculas = doc.getElementsByTagName("Pelicula");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosPeliculas.getLength(); j++) {
			Node modeloNodo = nodosPeliculas.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				// esto es un casting para saber si se puede cambiar de un tipo nodo
				Pelicula p = this.getPeliculaFromElement((Element) modeloNodo);
				peliculas.add(p);
			}
		}
		return peliculas;
	}

}
