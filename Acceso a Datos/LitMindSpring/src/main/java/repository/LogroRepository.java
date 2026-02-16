package repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Logro;

@Repository
public interface LogroRepository extends JpaRepository<Logro, Long> {

	List<Logro> findAll();

	Set<Logro> findByNombre(String nombre);

	Logro findLogroById(long id);

}
