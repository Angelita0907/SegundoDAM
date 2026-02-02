package modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_estudiante;
	private int puntosXP;
	private int nivelActual;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToMany(mappedBy = "estudiantes", cascade = CascadeType.ALL)
	private Set<Logro> logros; // Relación N:M
	
	
	public Estudiante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estudiante(int puntosXP, int nivelActual, Usuario usuario, Set<Logro> logros) {
		super();
		this.puntosXP = puntosXP;
		this.nivelActual = nivelActual;
		this.usuario = usuario;
		this.logros = new HashSet<>();
	}

	public int getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public int getPuntosXP() {
		return puntosXP;
	}

	public void setPuntosXP(int puntosXP) {
		this.puntosXP = puntosXP;
	}

	public int getNivelActual() {
		return nivelActual;
	}

	public void setNivelActual(int nivelActual) {
		this.nivelActual = nivelActual;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Logro> getLogros() {
		return logros;
	}

	public void setLogros(Set<Logro> logros) {
		this.logros = logros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_estudiante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return id_estudiante == other.id_estudiante;
	}

	@Override
	public String toString() {
		return "Estudiante [id_estudiante=" + id_estudiante + ", puntosXP=" + puntosXP + ", nivelActual=" + nivelActual
				+ ", usuario=" + usuario + ", logros=" + logros + "]";
	}
	
	// metodos para el n:m

		public void addLogro(Logro l) {

			this.logros.add(l);

			if (!l.getEstudiantes().contains(this)) {
				l.getEstudiantes().add(this);
			}

		}

		public void removePersona(Logro l) {

			this.logros.remove(l);

			if (l.getEstudiantes().contains(this)) {
				l.getEstudiantes().remove(this);
				
				
			}

		}

}
