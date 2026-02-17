package acceso.veterinaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.veterinaria.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
	
	List<Animal> findAll();
	Animal findByIdAnimal(long id);
	

}
