package models;

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
import lombok.NoArgsConstructor;
import utils.Rol;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiante")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long estudiante_id;

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
	private List<Lectura> lecturas = new ArrayList<>();

	// Relación N:M con Logro
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Logro> logros = new HashSet<>();

	@Override
	public String toString() {
		return "Estudiante [id=" + estudiante_id + ", nombreCompleto=" + nombreCompleto + ", email=" + email + ", edad=" + edad
				+ ", puntosXP=" + puntosXP + ", nivelActual=" + nivelActual + ", rol=" + rol + ", lecturas=" + lecturas
				+ ", logros=" + logros + "]";
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
