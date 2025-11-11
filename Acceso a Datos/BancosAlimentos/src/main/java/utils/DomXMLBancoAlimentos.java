package utils;

import java.io.File;
import java.time.LocalDate;
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

import modelo.CentroLogistico;
import modelo.TipoTrabajador;
import modelo.Trabajador;

public class DomXMLBancoAlimentos {

	private static final Logger logger = LogManager.getLogger(DomXMLBancoAlimentos.class);
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

	private CentroLogistico getCentroFromElement(Element elemento) {

		CentroLogistico centro = new CentroLogistico();

		String id = elemento.getAttribute("ID");
		String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
		String ciudad = elemento.getElementsByTagName("Ciudad").item(0).getTextContent();
		int comedor = Integer.parseInt(elemento.getElementsByTagName("ComedoresAbastecidos").item(0).getTextContent());

		centro.setId(id);
		centro.setNombre(nombre);
		centro.setCiudad(ciudad);
		centro.setComedores(comedor);

		NodeList trabajadoresNodo = elemento.getElementsByTagName("Trabajador"); // cada nodo <Trabajador>
		for (int i = 0; i < trabajadoresNodo.getLength(); i++) {
			Node nodo = trabajadoresNodo.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element eTrabajador = (Element) nodo;
				Trabajador t = getTrabajadorFromElement(eTrabajador);
				t.setIdCentroLogistico(id);
				centro.getListaTrabajdores().add(t);
			}
		}

		return centro;
	}

	private Trabajador getTrabajadorFromElement(Element elemento) {

		Trabajador t = new Trabajador();

		String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim();
		String dni = elemento.getElementsByTagName("DNI").item(0).getTextContent().trim();
		LocalDate fecha = LocalDate
				.parse(elemento.getElementsByTagName("FechaNacimiento").item(0).getTextContent().trim());
		String tipo = elemento.getElementsByTagName("Tipo").item(0).getTextContent().trim();

		TipoTrabajador tipoTrabajador = TipoTrabajador.valueOf(tipo.toUpperCase());

		t.setNombre(nombre);
		t.setDni(dni);
		t.setFecha_nacimiento(fecha);
		t.setTipo(tipoTrabajador);

		return t;

	}

	public List<CentroLogistico> leerCentroLogisticoDesdeXML(String rutaFichero) throws Exception {
		List<CentroLogistico> peliculas = new ArrayList<CentroLogistico>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosCentro = doc.getElementsByTagName("CentroLogistico");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosCentro.getLength(); j++) {
			Node modeloNodo = nodosCentro.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				// esto es un casting para saber si se puede cambiar de un tipo nodo
				CentroLogistico p = this.getCentroFromElement((Element) modeloNodo);
				peliculas.add(p);
			}
		}
		return peliculas;
	}

	public List<Trabajador> leerTrabajadorDesdeXML(String rutaFichero) throws Exception {

		List<Trabajador> trabajadores = new ArrayList<Trabajador>();

		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosproductos = doc.getElementsByTagName("Trabajador");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosproductos.getLength(); j++) {
			Node modeloNodo = nodosproductos.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				Trabajador t = this.getTrabajadorFromElement((Element) modeloNodo);
				trabajadores.add(t);
			}

		}

		return trabajadores;

	}

}
