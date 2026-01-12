package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Trabajador {

	private String nombre;
	private String dni;
	private LocalDate fecha_nacimiento;
	private TipoTrabajador tipo;
	private String idCentroLogistico;

	public Trabajador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trabajador(String nombre, String dni, LocalDate fecha_nacimiento, TipoTrabajador tipo,
			String idCentroLogistico) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.fecha_nacimiento = fecha_nacimiento;
		this.tipo = tipo;
		this.idCentroLogistico = idCentroLogistico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public TipoTrabajador getTipo() {
		return tipo;
	}

	public void setTipo(TipoTrabajador tipo) {
		this.tipo = tipo;
	}

	public String getIdCentroLogistico() {
		return idCentroLogistico;
	}

	public void setIdCentroLogistico(String idCentroLogistico) {
		this.idCentroLogistico = idCentroLogistico;
	}

	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", dni=" + dni + ", fecha_nacimiento=" + fecha_nacimiento + ", tipo="
				+ tipo + ", idCentroLogistico=" + idCentroLogistico + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajador other = (Trabajador) obj;
		return Objects.equals(dni, other.dni);
	}

}
