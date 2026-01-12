package modelo;

import java.util.Objects;

public class Enfrentamiento {

	private int id;
	private String fecha;
	private String descripcion;
	private TipoVideoJuego videojuego;
//	private Equipo equipoGanador;
	private String equipoGanador;
	
	public Enfrentamiento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enfrentamiento(int id, String fecha, String descripcion, TipoVideoJuego videojuego, String equipoGanador) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.videojuego = videojuego;
		this.equipoGanador = equipoGanador;
	}
	
	
	
	public String getEquipoGanador() {
		return equipoGanador;
	}
	public void setEquipoGanador(String equipoGanador) {
		this.equipoGanador = equipoGanador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoVideoJuego getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(TipoVideoJuego videojuego) {
		this.videojuego = videojuego;
	}
	/*public Equipo getEquipoGanador() {
		return equipoGanador;
	}
	public void setEquipoGanador(Equipo equipoGanador) {
		this.equipoGanador = equipoGanador;
	}*/
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
		Enfrentamiento other = (Enfrentamiento) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Enfrentamiento [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + ", videojuego="
				+ videojuego + ", equipoGanador=" + equipoGanador + "]";
	}
	
	
	
}
