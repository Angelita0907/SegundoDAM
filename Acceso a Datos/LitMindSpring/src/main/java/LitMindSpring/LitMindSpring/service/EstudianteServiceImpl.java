package LitMindSpring.LitMindSpring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LitMindSpring.LitMindSpring.models.Estudiante;
import LitMindSpring.LitMindSpring.models.Logro;
import LitMindSpring.LitMindSpring.repository.EstudianteRepository;
import LitMindSpring.LitMindSpring.repository.LogroRepository;
import exceptions.EstudianteException;


@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private LogroRepository logroRepository;

	// metodos de estudiante
	@Override
	public List<Estudiante> findAllEstudiantes() {
		return estudianteRepository.findAll();
	}

	@Override
	public Set<Estudiante> findByNombreCompleto(String nombre) {
		return estudianteRepository.findByNombreCompleto(nombre);
	}

	@Override
	public Estudiante findEstudianteById(long id) {
		return estudianteRepository.findEstudianteById(id);
	}

	// que devuelva una cadena
	@Override
	public String createEstudiante(Estudiante estudiante) {
		Estudiante eNevo = estudianteRepository.save(estudiante);
		String respuesta = "";
		if (eNevo != null) {
			respuesta = "Estudiante creado correctamente, con el id: "+ eNevo.getId();
		}
		else {
			respuesta = "No se ha podido crear el estudiante";
		}
		return respuesta;
	}

	@Override
	public Estudiante updateNameEstudiante(Long id, Estudiante estudiante) {

		Estudiante eOriginal = this.findEstudianteById(id);
		if (eOriginal != null) {
			eOriginal.setNombreCompleto(estudiante.getNombreCompleto());
		} else {
			new EstudianteException(id);
		}

		return estudianteRepository.save(eOriginal);
	}

	@Override
	public void deleteEstudiante(Long id) {
		Estudiante eOriginal = this.findEstudianteById(id);
		estudianteRepository.delete(eOriginal);

	}
	
	// metodo para poder usarlo y que devuelva un json
	@Override
	public Estudiante addLogro2Estudiante(long id, Logro logro) {

	    // que el estudiante exista y que el logro exista
	    Estudiante estudiante = estudianteRepository.findEstudianteById(id);

	    Logro nuevoLogro = null;
	    if (logro.getId() != null) {
	        nuevoLogro = logroRepository.findLogroById(logro.getId());
	    } else {
	        nuevoLogro = logroRepository.save(logro);
	    }

	    estudiante.getLogros().add(nuevoLogro);
	    nuevoLogro.getEstudiantes().add(estudiante);

	    return estudianteRepository.save(estudiante);
	}

}