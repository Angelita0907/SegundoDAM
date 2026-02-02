package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignacion")
public class Asignacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_asignacion;
	private String tituloAsignacion;
	private boolean esObligatoria;
	private String codigoClase;
	private int totalAlumnos;

	// relacion 1:n unidireccional con Docente
	@ManyToOne()
	@JoinColumn(name = "id_docente")
	private Docente docente;

	// relacion 1:n bidireccional con Lecturas
	@ManyToOne()
	@JoinColumn(name = "id_lectura")
	private Lectura lectura;

	public Asignacion() {
		super();
	}

	public Asignacion(String tituloAsignacion, boolean esObligatoria,
			String codigoClase, int totalAlumnos, Docente docente, Lectura lectura) {
		super();
		this.tituloAsignacion = tituloAsignacion;
		this.esObligatoria = esObligatoria;
		this.codigoClase = codigoClase;
		this.totalAlumnos = totalAlumnos;
		this.docente = docente;
		this.lectura = lectura;
	}

	// Getters y Setters
	public int getId() {
		return id_asignacion;
	}

	public void setId(int id) {
		this.id_asignacion = id;
	}

	public String getTituloAsignacion() {
		return tituloAsignacion;
	}

	public void setTituloAsignacion(String tituloAsignacion) {
		this.tituloAsignacion = tituloAsignacion;
	}

	public boolean isEsObligatoria() {
		return esObligatoria;
	}

	public void setEsObligatoria(boolean esObligatoria) {
		this.esObligatoria = esObligatoria;
	}

	public String getCodigoClase() {
		return codigoClase;
	}

	public void setCodigoClase(String codigoClase) {
		this.codigoClase = codigoClase;
	}

	public int getTotalAlumnos() {
		return totalAlumnos;
	}

	public void setTotalAlumnos(int totalAlumnos) {
		this.totalAlumnos = totalAlumnos;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Lectura getLectura() {
		return lectura;
	}

	public void setLectura(Lectura lectura) {
		this.lectura = lectura;
	}

	@Override
	public String toString() {
		return "Asignacion [id=" + id_asignacion + ","+ ", tituloAsignacion=" + tituloAsignacion
				+ ", esObligatoria=" + esObligatoria + ", codigoClase=" + codigoClase + ", totalAlumnos=" + totalAlumnos
				+ "]";
	}

}