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

import tema1.XML.modelo.Producto;

public class XMLDomProductos {
	private static final Logger logger = LogManager.getLogger(XMLDomProductos.class);
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
	
	private  Producto getProductoFromElement(Element elemento)
	{
			Producto p = new Producto();
			int id = Integer.parseInt(elemento.getAttribute("id"));
		    boolean enVenta = Boolean.parseBoolean(elemento.getAttribute("enVenta"));
		    String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
		    float precio = Float.parseFloat(elemento.getElementsByTagName("Precio").item(0).getTextContent());
		    int stock = Integer.parseInt(elemento.getElementsByTagName("Stock").item(0).getTextContent()); // S mayúscula
		
			// se usa atribute porque id es una etiqueta de empleado
			//String id = elemento.getAttribute("identificador"); // La etiqueta empleado tiene el atributo identificador
			
			p.setId(id);
			p.setEnVenta(enVenta);
			p.setNombre(nombre);
			p.setPrecio(precio);
			p.setStock(stock);
			
			return p;
		}
	
	public List<Producto> leerProductosDesdeXML(String rutaFichero) throws Exception {
		List<Producto> productos = new ArrayList<Producto>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodoProductos = doc.getElementsByTagName("Producto");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodoProductos.getLength(); j++) {
			Node modeloNodo = nodoProductos.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				// esto es un casting para saber si se puede cambiar de un tipo nodo
				Producto p = this.getProductoFromElement((Element) modeloNodo);
				productos.add(p);
			}
		}
		return productos;
	}

}
