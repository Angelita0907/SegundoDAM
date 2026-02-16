package repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Lectura;
@Repository
public interface LecturaRepository extends JpaRepository<Lectura, Long> {

	List<Lectura> findAllLecturas();

	Set<Lectura> findByNombre(String nombre);

	Lectura findLecturaById(long id);

}
