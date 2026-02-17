package acceso.veterinaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.veterinaria.models.Vacuna;

@Repository
public interface VacunaRepository extends JpaRepository<Vacuna, Long>{
	
	List<Vacuna> findAll();
	Vacuna findByIdVacuna(long id);

}
