package LitMindSpring.LitMindSpring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@ResponseBody
	public String addEstudiante(@RequestBody Estudiante estudiante) {
		String addedEstudiante = estudianteService.createEstudiante(estudiante);
		new ResponseEntity<>(addedEstudiante, HttpStatus.CREATED);
		return addedEstudiante;
	}

	// actualizar estudiante
	@PutMapping("/estudiante/{id}")
	public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
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

	// paginas lectura
	@PostMapping("/lectura")
	public ResponseEntity<Lectura> addLectura(@RequestBody Lectura lectura) {
		Lectura addedLectura = lecturaService.createLectura(lectura);
		return new ResponseEntity<>(addedLectura, HttpStatus.CREATED);
	}

	// actualizar lectura
	@PutMapping("/lectura/{id}")
	public ResponseEntity<Lectura> updateLectura(@PathVariable Long id, @RequestBody Lectura lectura) {
		Lectura addedLectura = lecturaService.updateNameLectura(id, lectura);
		return new ResponseEntity<>(addedLectura, HttpStatus.OK);
	}

	// lista de lectura
	@RequestMapping("/listaLectura")
	public String lecturaCatalog(Model model) {
		List<Lectura> lecturas = lecturaService.findAllLecturas();
		model.addAttribute("lecturas", lecturas);
		return "listaLectura";
	}

	// Método para obtener un producto por ID
	@GetMapping("/lectura/{id}")
	public String getLecturaById(@PathVariable Long id, Model model) {
		Lectura lectura = lecturaService.findLecturaById(id);
		model.addAttribute("detalleLectura", lectura);
		return "detalleLectura";
	}

	@DeleteMapping("/lectura/{id}")
	public ResponseEntity<Lectura> deleteLectura(@PathVariable Long id) {
		lecturaService.deleteLectura(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// páginas logro
	@PostMapping("/logro")
	public ResponseEntity<Logro> addLogro(@RequestBody Logro logro) {
		Logro addedLogro = logroService.createLogro(logro);
		return new ResponseEntity<>(addedLogro, HttpStatus.CREATED);
	}

	// actualizar logro
	@PutMapping("/logro/{id}")
	public ResponseEntity<Logro> updateLogro(@PathVariable Long id, @RequestBody Logro logro) {
		Logro addedLogro = logroService.updateNameLogro(id, logro);
		return new ResponseEntity<>(addedLogro, HttpStatus.OK);
	}

	// lista de logros
	@RequestMapping("/listaLogro")
	public String logroCatalog(Model model) {
		List<Logro> logros = logroService.findAllLogros();
		model.addAttribute("logros", logros);
		return "listaLogro";
	}

	// Método para obtener un logro por ID
	@GetMapping("/logro/{id}")
	public String getLogroById(@PathVariable Long id, Model model) {
		Logro logro = logroService.findLogroById(id);
		model.addAttribute("detalleLogro", logro);
		return "detalleLogro";
	}

	@DeleteMapping("/logro/{id}")
	public ResponseEntity<Logro> deleteLogro(@PathVariable Long id) {
		logroService.deleteLogro(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// para devolver un json
	// agregar logro a un estudiante
	@PostMapping("/agregarLogro/{idEstudiante}")
	@ResponseBody
	public Map<String, Object> addLogroEstudiante(@PathVariable Long idEstudiante, @RequestBody Logro logro) {
		Map<String, Object> respuesta = new HashMap<>();
		Estudiante estudiante = estudianteService.addLogro2Estudiante(idEstudiante, logro);

		Logro logroEstudiante = logroService.findLogroById(logro.getId());

		respuesta.put("idEstudiante", estudiante.getId());
		respuesta.put("idLogro", logroEstudiante.getId());

		return respuesta;
	}

	@ExceptionHandler(EstudianteException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(EstudianteException pnfe) {
		Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
