package acceso.veterinaria.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import acceso.veterinaria.models.Animal;
import acceso.veterinaria.models.Vacuna;
import acceso.veterinaria.repositories.AnimalRepository;
import acceso.veterinaria.repositories.VacunaRepository;
import exceptions.AnimalNotFoundException;

public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired 
	private VacunaRepository vacunaRepository;
	
	@Override
	public List<Animal> findAllAnimals() {
		return animalRepository.findAll();
	}

	@Override
	public String createAnimal(Animal animal) {
		String respuesta = "";
		Animal aNuevo = animalRepository.save(animal);
		
		if(aNuevo != null) {
			respuesta = "Animal creado correctamente" + aNuevo.getNombre();
		}
		else {
			throw new AnimalNotFoundException("No se ha podido crear el animal");
		}
		
		return respuesta;
	}

	@Override
	public Animal findAnimalById(long id) {
		Optional<Animal> optionalAnimal = animalRepository.findById(id);
		return optionalAnimal.orElseThrow(() -> new AnimalNotFoundException(id));
	}

	@Override
	public Animal addVacuna2Animal(long id, Vacuna vacuna) {
		
		
		
		return null;
	}

	@Override
	public List<Vacuna> findAllVacunas() {
		return vacunaRepository.findAll();
	}

	@Override
	public Vacuna createVacuna(Vacuna vacuna) {
		return vacunaRepository.save(vacuna);
	}

	@Override
	public Vacuna findVacunaById(long id) {
		Optional<Vacuna> optionalVacuna = vacunaRepository.findById(id);
		return optionalVacuna.orElseThrow(() -> new AnimalNotFoundException(id));
	}

}
