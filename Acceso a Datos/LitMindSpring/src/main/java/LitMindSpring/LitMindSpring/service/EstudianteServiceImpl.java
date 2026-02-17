package LitMindSpring.LitMindSpring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LitMindSpring.LitMindSpring.models.Estudiante;
import LitMindSpring.LitMindSpring.repository.EstudianteRepository;
import exceptions.EstudianteException;


@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

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

	@Override
	public Estudiante createEstudiante(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
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

}