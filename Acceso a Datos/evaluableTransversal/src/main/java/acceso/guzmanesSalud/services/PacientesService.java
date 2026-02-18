package acceso.guzmanesSalud.services;

import java.util.List;
import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;

public interface PacientesService {
	
	List<Paciente> findAllPacientes();
	public Paciente createPaciente(Paciente paciente);
	public Paciente findPacienteById(long idPaciente);
	public Paciente agregarConstantesVitales(long id, ConstantesVitales constantes);
	
	public ConstantesVitales findConstantesById(long idConstantes);

}
