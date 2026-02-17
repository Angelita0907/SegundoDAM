package LitMindSpring.LitMindSpring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import exceptions.EstudianteException;
import LitMindSpring.LitMindSpring.service.*;
import LitMindSpring.LitMindSpring.models.*;

@Controller
@RequestMapping("/litmind")

public class WebController {
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private LogroService logroService;
	
	@Autowired
	private LecturaService lecturaService;

	@RequestMapping("/") 
	public String index(Model model) {
		return "index";
	}

	// páginas de estudiante
	@PostMapping("/estudiante")
	public ResponseEntity<Estudiante> addEstudiante(@RequestBody Estudiante estudiante) {
		Estudiante addedEstudiante = estudianteService.createEstudiante(estudiante);
		return new ResponseEntity<>(addedEstudiante, HttpStatus.CREATED);
	}
	
	// actualizar estudiante
	@PutMapping("/estudiante/{id}")
	public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id,@RequestBody Estudiante estudiante) {
		Estudiante addedEstudiante = estudianteService.updateNameEstudiante(id, estudiante);
		return new ResponseEntity<>(addedEstudiante, HttpStatus.OK);
	}

	// lista de estudiantes
	@RequestMapping("/listaEstudiante")
	public String catalog(Model model) {
		List<Estudiante> estudiantes = estudianteService.findAllEstudiantes();
		model.addAttribute("estudiantes", estudiantes);
		return "listaEstudiante";
	}
	
    // Método para obtener un producto por ID
    @GetMapping("/estudiante/{id}")
    public String getEstudiantetById(@PathVariable Long id, Model model) {
    	Estudiante estudiante = estudianteService.findEstudianteById(id);
    	model.addAttribute("detalleEstudiante", estudiante);
        return "detalleEstudiante";
    }
    
    @DeleteMapping("/estudiante/{id}")
    public ResponseEntity<Estudiante> deleteEstudiante(@PathVariable Long id) {
    	estudianteService.deleteEstudiante(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
    
    //paginas lectura
    
    
    //páginas logro
    
	
	@ExceptionHandler(EstudianteException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(EstudianteException pnfe) 
	{
	        Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
	

}
