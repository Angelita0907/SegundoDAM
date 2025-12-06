package librosMongo.modelo;

import java.util.ArrayList;
import java.util.List;


public class Asignacion {
    
    private String id; 
    private String idDocente; 
    private String tituloAsignacion;
    private boolean esObligatoria; 
    private String codigoClase;
    private int totalAlumnos; 
    private List<String> idLecturas; 

    public Asignacion() {
		super();
	}

	public Asignacion(String id, String idDocente, String tituloAsignacion, boolean esObligatoria, String codigoClase,
			int totalAlumnos, List<String> idLecturasReferencias) {
		super();
		this.id = id;
		this.idDocente = idDocente;
		this.tituloAsignacion = tituloAsignacion;
		this.esObligatoria = esObligatoria;
		this.codigoClase = codigoClase;
		this.totalAlumnos = totalAlumnos;
		this.idLecturas = new ArrayList<>();
	}

    // Getters y Setters
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
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

    public List<String> getIdLecturasReferencias() {
        return idLecturas;
    }

    public void setIdLecturasReferencias(List<String> idLecturasReferencias) {
        this.idLecturas = idLecturasReferencias;
    }

	@Override
	public String toString() {
		return "Asignacion [id=" + id + ", idDocente=" + idDocente + ", tituloAsignacion=" + tituloAsignacion
				+ ", esObligatoria=" + esObligatoria + ", codigoClase=" + codigoClase + ", totalAlumnos=" + totalAlumnos
				+ ", idLecturasReferencias=" + idLecturas + "]";
	}


 
}