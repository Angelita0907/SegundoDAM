package service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.EstudianteException;
import exceptions.LecturaException;
import exceptions.LogroException;
import models.Estudiante;
import models.Lectura;
import models.Logro;
import repository.EstudianteRepository;
import repository.LecturaRepository;
import repository.LogroRepository;

@Service
public class LitMindServiceImpl implements LitMindService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Autowired
	private LecturaRepository lecturaRepository;

	@Autowired
	private LogroRepository logroRepository;

	// metodos de estudiante
	@Override
	public List<Estudiante> findAllEstudiantes() {
		return estudianteRepository.findAll();
	}

	@Override
	public Set<Estudiante> findByName(String nombre) {
		return estudianteRepository.findByName(nombre);
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

	// metodos de logro
	@Override
	public List<Logro> findAllLogros() {
		return logroRepository.findAll();
	}

	@Override
	public Set<Logro> findLogroByNombre(String nombre) {
		return logroRepository.findByNombre(nombre);
	}

	@Override
	public Logro findLogroById(long id) {
		return logroRepository.findLogroById(id);
	}

	@Override
	public Logro createLogro(Logro logro) {
		return logroRepository.save(logro);
	}

	@Override
	public Logro updateNameLogro(Long id, Logro logro) {

		Logro lOriginal = this.findLogroById(id);
		if (lOriginal != null) {
			lOriginal.setNombreLogro(logro.getNombreLogro());
		} else {
			new LogroException(id);
		}

		return logroRepository.save(lOriginal);
	}

	@Override
	public void deleteLogro(Long id) {
		Logro lOriginal = this.findLogroById(id);
		logroRepository.delete(lOriginal);

	}

	// metodos de lectura
	@Override
	public List<Lectura> findAllLecturas() {
		return lecturaRepository.findAll();
	}

	@Override
	public Set<Lectura> findLecturaByNombre(String nombre) {
		return lecturaRepository.findByNombre(nombre);
	}

	@Override
	public Lectura findLecturaById(long id) {
		return lecturaRepository.findLecturaById(id);
	}

	@Override
	public Estudiante createLectura(Lectura lectura) {
		lecturaRepository.save(lectura);
		return lectura.getEstudiante();
	}

	@Override
	public Estudiante updateNameLectura(Long id, Lectura lectura) {

		Lectura lOriginal = this.findLecturaById(id);
		if (lOriginal != null) {
			lOriginal.setTitulo(lectura.getTitulo());
		} else {
			new LecturaException(id);
		}

		lecturaRepository.save(lOriginal);
		return lOriginal.getEstudiante();
	}

	@Override
	public void deleteLectura(Long id) {
		Lectura lOriginal = this.findLecturaById(id);
		lecturaRepository.delete(lOriginal);

	}

}