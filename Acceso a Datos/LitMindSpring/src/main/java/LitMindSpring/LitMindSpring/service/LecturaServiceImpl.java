package LitMindSpring.LitMindSpring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Lectura createLectura(Lectura lectura) {
		
		return lecturaRepository.save(lectura);
	}

	@Override
	public Lectura updateNameLectura(Long id, Lectura lectura) {

		Lectura lOriginal = this.findLecturaById(id);
		if (lOriginal != null) {
			lOriginal.setTitulo(lectura.getTitulo());
		} else {
			new LecturaException(id);
		}

		
		return lecturaRepository.save(lOriginal);
	}

	@Override
	public void deleteLectura(Long id) {
		Lectura lOriginal = this.findLecturaById(id);
		lecturaRepository.delete(lOriginal);

	}

}
