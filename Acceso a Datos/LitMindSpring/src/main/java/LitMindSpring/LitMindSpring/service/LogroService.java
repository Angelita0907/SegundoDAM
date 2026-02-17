package LitMindSpring.LitMindSpring.service;

import java.util.List;
import java.util.Set;

import LitMindSpring.LitMindSpring.models.Logro;


public interface LogroService {

	// metodos de Logro
		List<Logro> findAllLogros();
		Set<Logro> findLogroByNombre(String nombre);
		public Logro findLogroById(long id);
		public Logro createLogro(Logro logro);
		public Logro updateNameLogro(Long id, Logro logro);
		public void deleteLogro(Long id);
	
}
