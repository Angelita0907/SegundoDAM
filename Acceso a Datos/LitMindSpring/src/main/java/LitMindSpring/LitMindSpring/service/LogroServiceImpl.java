package LitMindSpring.LitMindSpring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LitMindSpring.LitMindSpring.models.Logro;
import LitMindSpring.LitMindSpring.repository.LogroRepository;
import exceptions.LogroException;

@Service
public class LogroServiceImpl implements LogroService {

	@Autowired
	private LogroRepository logroRepository;

	// metodos de logro
	@Override
	public List<Logro> findAllLogros() {
		return logroRepository.findAll();
	}

	@Override
	public Set<Logro> findLogroByNombre(String nombre) {
		return logroRepository.findByNombreLogro(nombre);
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

}
