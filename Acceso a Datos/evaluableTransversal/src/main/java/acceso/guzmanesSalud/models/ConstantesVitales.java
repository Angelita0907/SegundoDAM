package acceso.guzmanesSalud.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "constantes")
public class ConstantesVitales {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConstantes;

    private double frecuenciaCardiaca; 
    private double tension;   
    private double temperatura;       
    private LocalDateTime fechaRegistro;

    
    
    public ConstantesVitales(double frecuenciaCardiaca, double tension, double temperatura, LocalDateTime fechaRegistro) {
		super();
		this.frecuenciaCardiaca = frecuenciaCardiaca;
		this.tension = tension;
		this.temperatura = temperatura;
		this.fechaRegistro = fechaRegistro;
	}



	@ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

}
