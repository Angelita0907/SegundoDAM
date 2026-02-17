package LitMindSpring.LitMindSpring.service;

import java.util.List;
import java.util.Set;

import LitMindSpring.LitMindSpring.models.Estudiante;
import LitMindSpring.LitMindSpring.models.Lectura;



public interface LecturaService {
	
	// metodo de Lectura
		List<Lectura> findAllLecturas();
		Set<Lectura> findLecturaByNombre(String nombre);
		public Lectura findLecturaById(long id);
		public Estudiante createLectura(Lectura lectura);
		public Estudiante updateNameLectura(Long id, Lectura lectura);
		public void deleteLectura(Long id);

}
