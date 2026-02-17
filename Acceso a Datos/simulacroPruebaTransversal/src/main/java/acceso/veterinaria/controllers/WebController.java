package acceso.veterinaria.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import acceso.veterinaria.models.Animal;
import acceso.veterinaria.models.Vacuna;
import acceso.veterinaria.services.AnimalService;
import exceptions.AnimalNotFoundException;

@Controller
@RequestMapping("/clinica")

public class WebController {
	@Autowired
	private AnimalService animalService;

	@RequestMapping("/") 
	public String index(Model model) {
		return "index";
	}

	@PostMapping("/animal")
	@ResponseBody
	public String addAnimal(@RequestBody Animal animal) {
		String addedProduct = animalService.createAnimal(animal);
		return addedProduct;
	}

	@RequestMapping("/animales")
	public String animales(Model model) {
		List<Animal> animales = animalService.findAllAnimals();
		model.addAttribute("animales", animales);
		return "animales";
	}
	
    // Método para obtener un producto por ID
    @GetMapping("/animal/{idAnimal}")
    public String getAnimalById(@PathVariable Long idAnimal, Model model) {
        Animal animal = animalService.findAnimalById(idAnimal);
    	model.addAttribute("detalleAnimal", animal);
        return "detalleAnimal";
    }
    
    //agregar vacuna a un animal
    @PostMapping("/agregarVacuna/{idAnimal}")
    @ResponseBody
    public Map<String, Object> addVacunaAnimal(@PathVariable Long idAnimal, @RequestBody Vacuna vacuna){
    	Map<String, Object> respuesta = new HashMap<>();
        Animal animal = animalService.addVacuna2Animal(idAnimal, vacuna);

        Vacuna vacunaAnimal = animalService.findVacunaById(vacuna.getIdVacuna());
        
        respuesta.put("idAnimal", animal.getIdAnimal());
        respuesta.put("idVacuna", vacunaAnimal.getIdVacuna());

        return respuesta;
    }
    
    
	
	@ExceptionHandler(AnimalNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(AnimalNotFoundException pnfe) 
	{
	        Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
	

}
