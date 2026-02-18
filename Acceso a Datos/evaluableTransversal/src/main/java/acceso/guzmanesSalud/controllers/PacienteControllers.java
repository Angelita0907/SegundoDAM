package acceso.guzmanesSalud.controllers;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;
import acceso.guzmanesSalud.services.PacientesServiceImpl;

public class PacienteControllers {

	private static final Logger logger = LogManager.getLogger(PacienteControllers.class);
	
	public static void main(String[] args) {
		
		PacientesServiceImpl pacienteServicio = new PacientesServiceImpl();
		
		// crear pacientes
		Paciente p1 = new Paciente("Pedrito", "12345678A");
		pacienteServicio.createPaciente(p1);
		Paciente p2 = new Paciente("Ana", "98765432B");
		pacienteServicio.createPaciente(p2);
		
		logger.info("Paciente: "+ pacienteServicio.findPacienteById(p1.getIdPaciente()));
		
		ConstantesVitales constantes = new ConstantesVitales(22.1, 75.3, 36, LocalDateTime.now());
		
		logger.info("Contantes agregadas a paciente " + pacienteServicio.agregarConstantesVitales(2, constantes));
		

	}

}
