package utils;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import modelo.Equipo;
import modelo.Piloto;

public class Formula1XMLNuevo {

    private static final Logger logger = LogManager.getLogger(Formula1XMLNuevo.class);
    private static final String rutaResources = "src\\main\\resources\\";

    /**
     * Escribe una lista de equipos (y sus pilotos) en un archivo XML.
     */
    public void escribeEquiposEnXML(String nombreFichero, List<Equipo> equipos) {
        try {
            Document documento = this.construyoObjetoDocumento("equipos");

            for (Equipo e : equipos) {
                Element elementoEquipo = this.creaElemento("equipo", null, documento.getDocumentElement(), documento);
                agregaEquipoADocumento(documento, elementoEquipo, e);
            }

            escribeDocumentoEnFichero(documento, rutaResources + nombreFichero);
            logger.info("Archivo XML generado correctamente: " + nombreFichero);

        } catch (ParserConfigurationException | TransformerException e1) {
            logger.error("Error al escribir XML: " + e1.getMessage());
        }
    }

    /**
     * Crea y escribe el documento XML en el fichero físico.
     */
    private void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource source = new DOMSource(documento);
        StreamResult resultado = new StreamResult(new File(nombreFichero));

        transformer.transform(source, resultado);
    }

    /**
     * Añade la información de un equipo y sus pilotos al documento.
     */
    private void agregaEquipoADocumento(Document documento, Element padre, Equipo e) {
        // Elementos del equipo
        this.creaElemento("nombreEquipo", e.getNombreEquipo(), padre, documento);
        this.creaElemento("puntos", Integer.toString(e.getPuntos()), padre, documento);

        // Lista de pilotos
        Element pilotos = this.creaElemento("pilotos", null, padre, documento);
        for (Piloto p : e.getListaPilotos()) {
            Element piloto = this.creaElemento("piloto", null, pilotos, documento);
            this.creaElemento("nombrePiloto", p.getNombre(), piloto, documento);
            this.creaElemento("puntos", Integer.toString(p.getPuntos()), piloto, documento);
            this.creaElemento("identificadorEquipo", String.valueOf(p.getIdentificadorEquipo()), piloto, documento);
            this.creaElemento("pais", p.getPais(), piloto, documento);

            // Atributo identificador del piloto
            piloto.setAttribute("identificadorPiloto", String.valueOf(p.getIdentificadorPiloto()));
        }

        // Atributo identificador del equipo
        padre.setAttribute("identificadorEquipo", String.valueOf(e.getIdentificadorEquipo()));
    }

    /**
     * Crea un elemento XML (con o sin valor) y lo añade al nodo padre.
     */
    private Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
        Element elemento = documento.createElement(nombreElemento);
        if (valorElemento != null) {
            Text texto = documento.createTextNode(valorElemento);
            elemento.appendChild(texto);
        }
        padre.appendChild(elemento);
        return elemento;
    }

    /**
     * Crea la estructura base de un documento XML con una raíz.
     */
    private Document construyoObjetoDocumento(String nombreRaiz) throws ParserConfigurationException {
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        DOMImplementation implementacion = builder.getDOMImplementation();
        return implementacion.createDocument(null, nombreRaiz, null);
    }
}
