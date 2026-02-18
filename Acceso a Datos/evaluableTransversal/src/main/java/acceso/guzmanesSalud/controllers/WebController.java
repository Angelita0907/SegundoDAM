package acceso.guzmanesSalud.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;
import acceso.guzmanesSalud.services.PacientesService;
import acceso.guzmanesSalud.services.PacientesServiceImpl;
import exceptions.PacienteNotFoundException;


@Controller
@RequestMapping("/salud")

public class WebController {
	
	@Autowired
	private PacientesService pacienteService;


	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	// lista de pacintes
	@GetMapping("/pacientes")
	public String lista(Model model) {
		List<Paciente> pacientes = pacienteService.findAllPacientes();
		model.addAttribute("pacientes", pacientes);
		return "pacientes";
	}
	
	@GetMapping("/detalle/{id}")
	public String getLogroById(@PathVariable Long id, Model model) {
		Paciente paciente = pacienteService.findPacienteById(id);
		model.addAttribute("paciente", paciente);
		return "detalle";
	}


	// para devolver un json
	// agregar logro a un estudiante
	@PostMapping("/agregarConstantes/{id}")
	@ResponseBody
	public Map<String, Object> addConstantesPaciente(@PathVariable Long idPaciente, @RequestBody ConstantesVitales constantes) {
		Map<String, Object> respuesta = new HashMap<>();
		Paciente paciente = pacienteService.agregarConstantesVitales(idPaciente, constantes);

		ConstantesVitales constantesPaciene = pacienteService.findConstantesById(constantes.getIdConstantes());

		respuesta.put("idPaciente", paciente.getIdPaciente());
		respuesta.put("idConstantes", constantesPaciene.getIdConstantes());
		respuesta.put("Frecuencia Cardiaca:", constantesPaciene.getFrecuenciaCardiaca());
		respuesta.put("tension:", constantesPaciene.getTension());

		return respuesta;
	}

	// para gestionar las excepciones
	@ExceptionHandler(PacienteNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(PacienteNotFoundException pnfe) {
		Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
