package LitMindSpring.LitMindSpring.models;

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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(exclude = {"estudiantes"}) 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "logro")
public class Logro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	private Set<Estudiante> estudiantes = new HashSet<Estudiante>();

	

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

	public Logro(String nombreLogro, String descripcion, String icono, int puntosRequeridos, int lecturasRequeridas,
			String categoria) {
		super();
		this.nombreLogro = nombreLogro;
		this.descripcion = descripcion;
		this.icono = icono;
		this.puntosRequeridos = puntosRequeridos;
		this.lecturasRequeridas = lecturasRequeridas;
		this.categoria = categoria;
		this.estudiantes = new HashSet<Estudiante>();
	}

}
