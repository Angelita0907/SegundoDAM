package LitMindSpring.LitMindSpring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LitMindSpring.LitMindSpring.models.Estudiante;
import LitMindSpring.LitMindSpring.models.Lectura;
import LitMindSpring.LitMindSpring.repository.LecturaRepository;
import exceptions.LecturaException;

@Service
public class LecturaServiceImpl implements LecturaService {

	@Autowired
	private LecturaRepository lecturaRepository;

	// metodos de lectura
	@Override
	public List<Lectura> findAllLecturas() {
		return lecturaRepository.findAll();
	}

	@Override
	public Set<Lectura> findLecturaByNombre(String nombre) {
		return lecturaRepository.findByTitulo(nombre);
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
