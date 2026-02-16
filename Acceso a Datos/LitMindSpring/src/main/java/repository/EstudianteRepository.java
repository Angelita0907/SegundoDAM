package repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

	List<Estudiante> findAllEstudiantes();

	Set<Estudiante> findByName(String nombre);

	Estudiante findEstudianteById(long id);

}
