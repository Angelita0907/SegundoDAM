package tema1.Json.Ejemplo;

public class Empleado {
	
	private String nombreApellido, empresa;
	private int identificador, edad;
	
	public String getNombreApellido() {
		return nombreApellido;
	}
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Empleado(String nombreApellido, String empresa, int identificador, int edad) {
		super();
		this.nombreApellido = nombreApellido;
		this.empresa = empresa;
		this.identificador = identificador;
		this.edad = edad;
	}
	
	

}
