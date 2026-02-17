package LitMindSpring.LitMindSpring.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LitMindSpring.LitMindSpring.models.Estudiante;



@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

	List<Estudiante> findAll();

	Set<Estudiante> findByNombreCompleto(String nombre);

	Estudiante findEstudianteById(long id);

}
