package tema1.XML.modelo;

import java.util.Objects;

public class Empleado {
	
	private String identificador;
	private String nombreApellido;
	private int edad;
	private String empresa;
	
	public Empleado(String identificador, String nombreApellido, int edad, String empresa) {
		super();
		this.identificador = identificador;
		this.nombreApellido = nombreApellido;
		this.edad = edad;
		this.empresa = empresa;
	}
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getNombreApellido() {
		return nombreApellido;
	}
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return identificador == other.identificador;
	}

	@Override
	public String toString() {
		return "Empleado [identificador=" + identificador + ", nombreApellido=" + nombreApellido + ", edad=" + edad
				+ ", empresa=" + empresa + "]";
	}


}
