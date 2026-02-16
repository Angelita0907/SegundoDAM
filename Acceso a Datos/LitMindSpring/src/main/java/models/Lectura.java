package models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.Genero;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lectura")
public class Lectura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 200)
	private String titulo;

	@Column(nullable = false, length = 100)
	private String autor;

	@Enumerated(EnumType.STRING)
	@Column
	private Genero genero;

	@Column(name = "numero_paginas")
	private Integer numeroPaginas;

	@Column(name = "puntos_otorgados")
	private int puntosOtorgados;

	@Column(length = 500)
	private String descripcion;

	// Datos de la asignación (fusionados de la clase Asignacion original)
	@Column(name = "nombre_docente", length = 100)
	private String nombreDocente;

	@Column(name = "fecha_asignacion")
	private LocalDate fechaAsignacion;

	@Column(name = "fecha_limite")
	private LocalDate fechaLimite;

	@Column
	private int progreso = 0; // 0-100

	@Column
	private Double calificacion; // 0-10

	@Column(name = "es_obligatoria")
	private Boolean esObligatoria = false;

	// Relación N:1 con Estudiante (muchas lecturas pertenecen a un estudiante)
	@ManyToOne()
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;

	@Override
	public String toString() {
		return "Lectura [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero
				+ ", numeroPaginas=" + numeroPaginas + ", puntosOtorgados=" + puntosOtorgados + ", descripcion="
				+ descripcion + ", nombreDocente=" + nombreDocente + ", fechaAsignacion=" + fechaAsignacion
				+ ", fechaLimite=" + fechaLimite + ", progreso=" + progreso + ", calificacion=" + calificacion
				+ ", esObligatoria=" + esObligatoria + ", estudiante=" + estudiante + "]";
	}

}