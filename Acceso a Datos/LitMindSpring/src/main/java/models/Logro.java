package models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "logro")
public class Logro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_logro;

	@Column
	private String nombreLogro;

	@Column
	private String descripcion;

	@Column
	private String icono; 

	@Column
	private int puntosRequeridos;

	@Column
	private int lecturasRequeridas;

	@Column
	private String categoria;

	// Relación N:M con Estudiante (lado inverso)
	@ManyToMany(mappedBy = "logros")
	private Set<Estudiante> estudiantes = new HashSet<>();

	@Override
	public String toString() {
		return "Logro [id=" + id_logro + ", nombreLogro=" + nombreLogro + ", descripcion=" + descripcion + ", icono=" + icono
				+ ", puntosRequeridos=" + puntosRequeridos + ", lecturasRequeridas=" + lecturasRequeridas
				+ ", categoria=" + categoria + ", estudiantes=" + estudiantes + "]";
	}

	public void addEstudiante(Estudiante e) {
		this.estudiantes.add(e);
		if (!e.getLogros().contains(this)) {
			e.getLogros().add(this);
		}
	}

	public void removeEstudiante(Estudiante e) {
		this.estudiantes.remove(e);
		if (e.getLogros().contains(this)) {
			e.getLogros().remove(this);
		}
	}

}
