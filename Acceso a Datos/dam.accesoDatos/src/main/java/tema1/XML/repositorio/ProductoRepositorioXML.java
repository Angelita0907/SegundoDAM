package tema1.XML.repositorio;

import java.util.ArrayList;
import java.util.List;

import tema1.XML.modelo.Producto;
import utils.XMLDomProductos;

public class ProductoRepositorioXML {

	// TODO
	// terminar
	private static final String rutaXML = "productos.xml";
	
	List<Producto> productos;

	public ProductoRepositorioXML(List<Producto> productos) {
		super();
		this.productos = productos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	


}
