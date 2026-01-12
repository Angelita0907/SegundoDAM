package tema1.XML.modelo;

public class Producto {

	private int id;
	private boolean enVenta;
	private String nombre;
	private float precio;
	private int stock;
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(int id, boolean enVenta, String nombre, float precio, int stock) {
		super();
		this.id = id;
		this.enVenta = enVenta;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEnVenta() {
		return enVenta;
	}
	public void setEnVenta(boolean enVenta) {
		this.enVenta = enVenta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", enVenta=" + enVenta + ", nombre=" + nombre + ", precio=" + precio + ", stock="
				+ stock + "]";
	}
	
}
