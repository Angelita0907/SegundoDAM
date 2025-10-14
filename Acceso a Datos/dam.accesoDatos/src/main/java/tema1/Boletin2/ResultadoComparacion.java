package tema1.Boletin2;

import java.util.Objects;

public class ResultadoComparacion {

	private String nombreFichero;
	private ValorComparacion comparacion;
	
	public ResultadoComparacion(String nombreFichero, ValorComparacion comparacion) {
		super();
		this.nombreFichero = nombreFichero;
		this.comparacion = comparacion;
	}
	
	public String getNombreFichero() {
		return nombreFichero;
	}
	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}
	public ValorComparacion getComparacion() {
		return comparacion;
	}
	public void setComparacion(ValorComparacion comparacion) {
		this.comparacion = comparacion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombreFichero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadoComparacion other = (ResultadoComparacion) obj;
		return Objects.equals(nombreFichero, other.nombreFichero);
	}
	
	
}
