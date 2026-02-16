package service;

import java.util.List;
import java.util.Set;

import models.Estudiante;
import models.Lectura;
import models.Logro;

public interface LitMindService {

	// metodos de Estudiante
	List<Estudiante> findAllEstudiantes();
	Set<Estudiante> findByName(String nombre);
	public Estudiante findEstudianteById(long id);
	public Estudiante createEstudiante(Estudiante estudiante);
	public Estudiante updateNameEstudiante(Long id, Estudiante estudiante);
	public void deleteEstudiante(Long id);
	
	// metodos de Logro
	List<Logro> findAllLogros();
	Set<Logro> findLogroByNombre(String nombre);
	public Logro findLogroById(long id);
	public Logro createLogro(Logro logro);
	public Logro updateNameLogro(Long id, Logro logro);
	public void deleteLogro(Long id);
	
	// metodo de Lectura
	List<Lectura> findAllLecturas();
	Set<Lectura> findLecturaByNombre(String nombre);
	public Lectura findLecturaById(long id);
	public Estudiante createLectura(Lectura lectura);
	public Estudiante updateNameLectura(Long id, Lectura lectura);
	public void deleteLectura(Long id);

}
