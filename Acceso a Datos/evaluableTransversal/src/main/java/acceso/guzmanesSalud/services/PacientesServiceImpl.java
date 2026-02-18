package acceso.guzmanesSalud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;
import acceso.guzmanesSalud.repositories.ConstantesVitalesRepository;
import acceso.guzmanesSalud.repositories.PacienteRepositorio;
import exceptions.PacienteNotFoundException;

@Service
public class PacientesServiceImpl implements PacientesService{

	@Autowired
	private PacienteRepositorio pacienteRepository;
	
	@Autowired
	private ConstantesVitalesRepository constantesRepository;
	
	@Override
	public List<Paciente> findAllPacientes() {
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente createPaciente(Paciente paciente) {
		
		Paciente pNuevo = pacienteRepository.save(paciente);
		String respuesta = "";
		if(pNuevo != null) {
			respuesta = "Paciente creado con el id:"+pNuevo.getIdPaciente();
		}
		else {
			new PacienteNotFoundException("No se ha podido crear el paciente");
		}
		
		return pNuevo;
	}

	@Override
	public Paciente findPacienteById(long idPaciente) {
		// TODO Auto-generated method stub
		return pacienteRepository.findByIdPaciente(idPaciente);
	}
	
	@Override
	public ConstantesVitales findConstantesById(long idConstantes) {
		// TODO Auto-generated method stub
		return /*constantesRepository.findConstantesById(idConstantes)*/ null;
	}

	@Override
	public Paciente agregarConstantesVitales(long idPaciente, ConstantesVitales constantes) {
		
		Paciente paciente = pacienteRepository.findByIdPaciente(idPaciente);
		
		ConstantesVitales constantesV = null;	
		if(constantes.getIdConstantes() != null) {
			//constantesV = constantesRepository.findConstantesById(constantes.getIdConstantes());
		}
		else {
			constantesV = constantesRepository.save(constantes);
		}
		
		paciente.getConstantesVitales().add(constantesV);
		
		return pacienteRepository.save(paciente);
	}

	

	
	
}
