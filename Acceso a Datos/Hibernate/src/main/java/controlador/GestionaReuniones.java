package controlador;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Reunion;
import modelo.Sala;
import repository.RepositorioReunion;
import repository.RepositorioSala;

public class GestionaReuniones {

	private static final Logger logger = LogManager.getLogger(GestionaReuniones.class);

	public static void main(String[] args) {

		RepositorioSala daoSala = new RepositorioSala();


		/*
		 * no hace falta poner todo lo de crear la sala ya que con crear la reunión 
		 * mapeada con la sala, la crea a la vez que la reunión
		 * */
		
	//	daoSala.create(nuevaSala);

	/*	List<Sala> salas = daoSala.getAll();

		for (Sala sala : salas) {
			logger.debug(sala);
		}
		
*/
		RepositorioReunion daoReunion = new RepositorioReunion();

		List<Reunion> reuniones = daoReunion.getAll();
		
		Sala nuevaSala = new Sala("Sala De Crisis", 3, reuniones);
		Reunion nuevaReunion = new Reunion(LocalDateTime.now().plusDays(3), "Reunion futura", nuevaSala);

		daoSala.create(nuevaSala);


		for (Reunion reunion : reuniones) {
			logger.debug(reunion);
		}

	}

}
