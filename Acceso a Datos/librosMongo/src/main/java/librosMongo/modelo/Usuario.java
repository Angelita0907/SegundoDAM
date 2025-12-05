package librosMongo.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    
    private String id; 
    private String nombreCompleto;
    private int edad; 
    private boolean esDocente;
    private String rolPrincipal;
    private List<Integer> puntosPorLogro;


    public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String id, String nombreCompleto, int edad, boolean esDocente, String rolPrincipal,
			List<Integer> puntosPorLogro) {
		super();
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.esDocente = esDocente;
		this.rolPrincipal = rolPrincipal;
		this.puntosPorLogro = new ArrayList<>();
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getEsDocente() {
        return esDocente;
    }

    public void setEsDocente(Boolean esDocente) {
        this.esDocente = esDocente;
    }


    public String getRolPrincipal() {
        return rolPrincipal;
    }

    public void setRolPrincipal(String rolPrincipal) {
        this.rolPrincipal = rolPrincipal;
    }


    public List<Integer> getPuntosPorLogro() {
        return puntosPorLogro;
    }

    public void setPuntosPorLogro(List<Integer> puntosPorLogro) {
        this.puntosPorLogro = puntosPorLogro;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombreCompleto=" + nombreCompleto + ", rolPrincipal=" + rolPrincipal  + "]";
    }
}