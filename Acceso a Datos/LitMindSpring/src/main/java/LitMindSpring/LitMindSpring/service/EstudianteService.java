package LitMindSpring.LitMindSpring.service;

import java.util.List;
import java.util.Set;

import LitMindSpring.LitMindSpring.models.Estudiante;
import LitMindSpring.LitMindSpring.models.Logro;


public interface EstudianteService {

	// metodos de Estudiante
	List<Estudiante> findAllEstudiantes();
	Set<Estudiante> findByNombreCompleto(String nombre);
	public Estudiante findEstudianteById(long id);
	public String createEstudiante(Estudiante estudiante);
	public Estudiante updateNameEstudiante(Long id, Estudiante estudiante);
	public void deleteEstudiante(Long id);
	public Estudiante addLogro2Estudiante(long id, Logro logro);


}
