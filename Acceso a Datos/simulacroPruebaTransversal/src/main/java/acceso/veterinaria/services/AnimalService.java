package acceso.veterinaria.services;

import java.util.List;
import java.util.Set;

import acceso.veterinaria.models.Animal;
import acceso.veterinaria.models.Vacuna;

public interface AnimalService {

	// funciones animal
	List<Animal> findAllAnimals();
	public String createAnimal(Animal animal);
	public Animal findAnimalById(long id);
	public Animal addVacuna2Animal(long id, Vacuna vacuna);
	
	// funciones vacuna
	List<Vacuna> findAllVacunas();
	public Vacuna createVacuna(Vacuna vacuna);
	public Vacuna findVacunaById(long id);
	
}
