package simulacionExamen;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Evento {

	static int contador;
	private int id;
	private String nombre;
	private final LocalDate fecha = null;
	private int numEntradas;
	private int maxAsistentes;
	private estado estado;

	public Evento(int id, String nombre, int numEntradas, int maxAsistentes, estado estado) {
		super();
		this.id = contador;
		this.nombre = nombre;
		this.numEntradas = numEntradas;
		this.maxAsistentes = maxAsistentes;
		this.estado = estado;
		contador = contador + 1;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Evento.contador = contador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumEntradas() {
		return numEntradas;
	}

	public void setNumEntradas(int numEntradas) {
		this.numEntradas = numEntradas;
	}

	public int getMaxAsistentes() {
		return maxAsistentes;
	}

	public void setMaxAsistentes(int maxAsistentes) {
		this.maxAsistentes = maxAsistentes;
	}

	public estado getEstado() {
		return estado;
	}

	public void setEstado(estado estado) {
		this.estado = estado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Evento id:" + id + ", nombre:" + nombre + ", fecha:" + fecha + ", estado:" + estado;
	}

	public abstract double calcularCosteBae();

	public void modificaEstado(Evento e) {
		// TODO terminar
	}

	public double getPorcentajeOcupacion() {

		double ocupacion = (numEntradas / maxAsistentes) * 100;
		return ocupacion;
	}
	
	public double getgetPorcentajeOcupacion(int numVendidas) {
		double ocupacion = ((numEntradas + numVendidas) / maxAsistentes) * 100;
		return ocupacion;
	}

}
