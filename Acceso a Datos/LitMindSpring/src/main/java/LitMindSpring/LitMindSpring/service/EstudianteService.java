package LitMindSpring.LitMindSpring.service;

import java.util.List;
import java.util.Set;

import LitMindSpring.LitMindSpring.models.Estudiante;


public interface EstudianteService {

	// metodos de Estudiante
	List<Estudiante> findAllEstudiantes();
	Set<Estudiante> findByNombreCompleto(String nombre);
	public Estudiante findEstudianteById(long id);
	public Estudiante createEstudiante(Estudiante estudiante);
	public Estudiante updateNameEstudiante(Long id, Estudiante estudiante);
	public void deleteEstudiante(Long id);


}
