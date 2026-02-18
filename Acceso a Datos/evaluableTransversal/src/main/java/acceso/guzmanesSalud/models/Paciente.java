package acceso.guzmanesSalud.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    private String nombre;
    private String dni;  

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConstantesVitales> constantesVitales;

	public Paciente() {
		super();
		this.constantesVitales = new ArrayList<ConstantesVitales>();
	}

	public Paciente(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.constantesVitales = new ArrayList<ConstantesVitales>();
	}
	
	
    
    
    
}
