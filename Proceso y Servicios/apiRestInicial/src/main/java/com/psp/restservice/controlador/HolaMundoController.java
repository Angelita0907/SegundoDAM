package com.psp.restservice.controlador;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psp.restservice.modelo.SaludoRespuesta;  




@RestController
public class HolaMundoController {

	private static final String salida = "Hola, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/holaMundo")
	public SaludoRespuesta holaMundo(@RequestParam(value = "nombre", defaultValue = "Mundo") String name) {
		return new SaludoRespuesta(counter.incrementAndGet(), String.format(salida, name));
	}
}
