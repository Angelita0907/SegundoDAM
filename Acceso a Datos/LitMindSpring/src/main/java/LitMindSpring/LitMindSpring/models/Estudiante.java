package LitMindSpring.LitMindSpring.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import utils.Rol;

@Data
@EqualsAndHashCode(exclude = {"logros", "lecturas"}) 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiante")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombreCompleto;

	@Column
	private String email;

	@Column
	private Integer edad;

	@Column
	private int puntosXP;

	@Column
	private int nivelActual;

	@Enumerated
	@Column(length = 20)
	private Rol rol;

	// Relación 1:N con Lectura (lado inverso)
	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Lectura> lecturas = new ArrayList<Lectura>();

	// Relación N:M con Logro
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Logro> logros = new HashSet<Logro>();

	public Estudiante(String nombreCompleto, String email, Integer edad, int puntosXP, int nivelActual, Rol rol) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.edad = edad;
		this.puntosXP = puntosXP;
		this.nivelActual = nivelActual;
		this.rol = rol;
		this.lecturas = new ArrayList<Lectura>();
		this.logros = new HashSet<Logro>();
	}
	
	public void addLogro(Logro l) {
		this.logros.add(l);
		if (!l.getEstudiantes().contains(this)) {
			l.getEstudiantes().add(this);
		}

	}

	public void removeLogro(Logro l) {
		this.logros.remove(l);
		if (l.getEstudiantes().contains(this)) {
			l.getEstudiantes().remove(this);

		}

	}

}
