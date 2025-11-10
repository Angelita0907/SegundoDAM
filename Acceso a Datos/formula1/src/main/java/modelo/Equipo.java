package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {

	private int identificadorEquipo;
	private String nombreEquipo;
	private int puntos;
	private List<Piloto> listaPilotos = new ArrayList<>();

	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipo(int identificadorEquipo, String nombreEquipo, int puntos, List<Piloto> listaPilotos) {
		super();
		this.identificadorEquipo = identificadorEquipo;
		this.nombreEquipo = nombreEquipo;
		this.puntos = puntos;
		this.listaPilotos = new ArrayList<>();
	}

	public int getIdentificadorEquipo() {
		return identificadorEquipo;
	}

	public void setIdentificadorEquipo(int identificadorEquipo) {
		this.identificadorEquipo = identificadorEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public List<Piloto> getListaPilotos() {
		return listaPilotos;
	}

	public void setListaPilotos(List<Piloto> listaPilotos) {
		this.listaPilotos = listaPilotos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificadorEquipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return identificadorEquipo == other.identificadorEquipo;
	}

	@Override
	public String toString() {
		return "Equipo [identificadorEquipo=" + identificadorEquipo + ", nombreEquipo=" + nombreEquipo + ", puntos="
				+ puntos + ", listaPilotos=" + listaPilotos + "]";
	}

}
