package tema1.XML.controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tema1.XML.modelo.Producto;
import tema1.XML.repositorio.ProductoRepositorioXML;
import tema1.XML.servicio.ProductoServicioXML;
import utils.XMLDomProductos;

public class GestionaProductos {
	
	private static final Logger logger = LogManager.getLogger(GestionaProductos.class);
	private static final String rutaResources = "src/main/resources/";

	public static void main(String[] args) {
		
		String rutaXML = "src\\main\\resources\\productos.xml";
		
		ProductoRepositorioXML repoProductos = new ProductoRepositorioXML();
		XMLDomProductos domProductos = new XMLDomProductos();
		ProductoServicioXML servicioProducto = new ProductoServicioXML(repoProductos);
		
		try {
			List<Producto> productos = domProductos.leerProductosDesdeXML("productos.xml");
			logger.info(servicioProducto.productoMenor(3));
			servicioProducto.retiraDeVentaProductos(productos);
			
			List<Producto> menor5 = new ArrayList<>(servicioProducto.productosMenor5(productos));
			
			String rutaJson = "src/main/resources/productos_menor5.json";
			servicioProducto.escribeProductoAJson(menor5, rutaJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
