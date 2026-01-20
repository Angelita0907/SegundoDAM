package modelo;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reunion")
public class Reunion {
	// Este campo es la clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReunion;
//Es obligatorio usar la notación @Column(name="nombreCampo")
	// Si las columnas de la tablas se llaman diferentes que los atributos
	// @Column(name="fecha")
	private LocalDateTime fecha;
	// @Column(name="asunto")
	private String asunto;

	// ahora haremos la relacion de reuniones con sala
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idSala")
	private Sala sala;

// Generamos el constructor sin parámetros y los métodos get/set
	public int getIdReunion() {
		return idReunion;
	}

	public void setIdReunion(int idReunion) {
		this.idReunion = idReunion;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Reunion() {
		super();
	}

	public Reunion(LocalDateTime fecha, String asunto, Sala sala) {
		super();
		this.fecha = fecha;
		this.asunto = asunto;
		this.sala = sala;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asunto, fecha, idReunion, sala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reunion other = (Reunion) obj;
		return Objects.equals(asunto, other.asunto) && Objects.equals(fecha, other.fecha)
				&& idReunion == other.idReunion && Objects.equals(sala, other.sala);
	}

	@Override
	public String toString() {
		return "Reunion [idReunion=" + idReunion + ", fecha=" + fecha + ", asunto=" + asunto + ", sala=" + sala + "]";
	}

}
