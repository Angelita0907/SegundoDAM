package controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Acta;
import modelo.Persona;
import modelo.Reunion;
import modelo.Sala;
import repository.RepositorioActa;
import repository.RepositorioPersona;
import repository.RepositorioReunion;
import repository.RepositorioSala;

public class GestionaReuniones {

	private static final Logger logger = LogManager.getLogger(GestionaReuniones.class);

	public static void main(String[] args) {

		RepositorioSala daoSala = new RepositorioSala();
		RepositorioReunion daoReunion = new RepositorioReunion();
		RepositorioActa daoActa = new RepositorioActa();
		RepositorioPersona daoPersona = new RepositorioPersona();
		
		Sala nuevaSala = new Sala("Sala De Crisis");
		Reunion nuevaReunion = new Reunion(LocalDateTime.now().plusDays(3), "Reunion futura5", nuevaSala);

		Acta nuevaActa = new Acta("Primera reunión", nuevaReunion);
		
		//daoReunion.create(nuevaReunion);
		daoActa.create(nuevaActa);
		
		/*Sala sala2 = new Sala("Sala De Marrones");
		Reunion reunion2 = new Reunion(LocalDateTime.now().plusDays(3), "Reunion Pasada", sala2);

		Acta acta2 = new Acta("Perry el Ornitorrinco", reunion2);
		*/
		//daoReunion.create(reunion2);
		//daoActa.create(acta2);
		

		List<Reunion> reuniones = daoReunion.getAll();

		for (Reunion reunion : reuniones) {
			logger.debug(reunion);
		}
		
		// ponemo para las relaciones n:m
		Persona p = new Persona("12345677p", "Pepa Rosa", 22, "rosaio@gmail.com", LocalDate.of(2001, 1, 21), "612345789" );
		daoPersona.create(p);

		//Creo la persona en la BBDD
		p.addReunion(nuevaReunion);
		daoPersona.update(p);
		//Propago el cambio. En este momento se rellena la tabla intermedia.

	}

}
