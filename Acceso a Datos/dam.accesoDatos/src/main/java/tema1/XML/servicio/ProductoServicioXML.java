package tema1.XML.servicio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tema1.XML.modelo.Producto;
import tema1.XML.repositorio.ProductoRepositorioXML;
import utils.XMLDomProductos;

public class ProductoServicioXML {

	private static final Logger logger = LogManager.getLogger(ProductoServicioXML.class);
	private static final String rutaXML = "productos.xml";

	private ProductoRepositorioXML repoProducto;
	private XMLDomProductos domProductos = new XMLDomProductos();

	// List<Producto> listaProductos = new
	// ArrayList<>(domProductos.leerProductosDesdeXML(rutaXML));

	public ProductoServicioXML(List<Producto> productos) {
		super();
		this.repoProducto = new ProductoRepositorioXML(productos);
	}

	public ProductoRepositorioXML getRepoProducto() {
		return repoProducto;
	}

	public void setRepoProducto(ProductoRepositorioXML repoProducto) {
		this.repoProducto = repoProducto;
	}


	/*
	 * método que devuelva los productos cuyo stock es inferior a un número de
	 * unidades que se recibe por parámetro
	 */

	public List<Producto> productoMenor(int stock) throws Exception {
		// lista que usamos luego
		List<Producto> productosFiltro = new ArrayList<>();

		// lista para llamar a la funcion que nos crea la lista segun el xml
		List<Producto> listaProductos = repoProducto.getProductos();

		for (Producto producto : listaProductos) {
			if (producto.getStock() < stock) {
				productosFiltro.add(producto);
			}
		}
		return productosFiltro;
	}

	public void retiraDeVentaProductos(List<Producto> listaProducto) {

		for (Producto producto : listaProducto) {
			if (producto.getStock() < 5) {
				producto.setEnVenta(false);
			}
		}

	}
	
	public List<Producto> productosMenor5(List<Producto> lista) throws Exception{
		List<Producto> productosFiltro = new ArrayList<>();

		// lista para llamar a la funcion que nos crea la lista segun el xml
		List<Producto> listaProductos = new ArrayList<>(domProductos.leerProductosDesdeXML(rutaXML));

		for (Producto producto : listaProductos) {
			if (producto.getStock() < 5) {
				productosFiltro.add(producto);
			}
		}
		return productosFiltro;
	}
	
	//falta el 7
	
	

}
