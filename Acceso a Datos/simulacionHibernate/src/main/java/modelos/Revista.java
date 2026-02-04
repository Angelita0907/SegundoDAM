package modelos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "revista")
public class Revista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_revista;
	private String nombreRevista;
	private int numeroRevista;
	private LocalDate fecha;
	private int unidadesImpresas;

	@OneToMany(mappedBy = "revista", cascade = CascadeType.ALL)
	private Set<Articulo> articulos;

	public Revista() {
		super();
		this.articulos = new HashSet<>();
	}

	public Revista(String nombreRevista, int numeroRevista, LocalDate fecha, int unidadesImpresas) {
		super();
		this.nombreRevista = nombreRevista;
		this.numeroRevista = numeroRevista;
		this.fecha = fecha;
		this.unidadesImpresas = unidadesImpresas;
		this.articulos = new HashSet<>();
	}

	public int getId_revista() {
		return id_revista;
	}

	public void setId_revista(int id_revista) {
		this.id_revista = id_revista;
	}

	public String getNombreRevista() {
		return nombreRevista;
	}

	public void setNombreRevista(String nombreRevista) {
		this.nombreRevista = nombreRevista;
	}

	public int getNumeroRevista() {
		return numeroRevista;
	}

	public void setNumeroRevista(int numeroRevista) {
		this.numeroRevista = numeroRevista;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getUnidadesImpresas() {
		return unidadesImpresas;
	}

	public void setUnidadesImpresas(int unidadesImpresas) {
		this.unidadesImpresas = unidadesImpresas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_revista);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
		return id_revista == other.id_revista;
	}

	@Override
	public String toString() {
		return "Revista [id_revista=" + id_revista + ", nombreRevista=" + nombreRevista + ", numeroRevista="
				+ numeroRevista + ", fecha=" + fecha + ", unidadesImpresas=" + unidadesImpresas + "]";
	}

	public void addArticulo(Articulo a) {

		this.articulos.add(a);

		a.setRevista(this);

	}

}
