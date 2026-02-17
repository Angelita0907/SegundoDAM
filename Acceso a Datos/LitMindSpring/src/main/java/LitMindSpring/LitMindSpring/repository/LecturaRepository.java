package LitMindSpring.LitMindSpring.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LitMindSpring.LitMindSpring.models.Lectura;


@Repository
public interface LecturaRepository extends JpaRepository<Lectura, Long> {

	List<Lectura> findAll();

	Set<Lectura> findByTitulo(String nombre);

	Lectura findLecturaById(long id);

}
