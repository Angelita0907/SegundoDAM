package controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Cine;
import models.Pelicula;
import models.Sala;
import service.FestivalCineService;

public class GestionaFestivalCine {

	private static final Logger logger = LogManager.getLogger(GestionaFestivalCine.class);
	
	public static void main(String[] args) {
		
		FestivalCineService servicioCine = new FestivalCineService();
		
		Pelicula p1 = new Pelicula("El chico y la Garza", "Animación", 96);
		servicioCine.getPelicularepo().create(p1);
		Pelicula p2 = new Pelicula("100 Dalmatas", "infantil", 92);
		servicioCine.getPelicularepo().create(p2);
		Pelicula p3 = new Pelicula("Malditos Bastardos", "Comedia-Historia", 120);
		servicioCine.getPelicularepo().create(p3);
		Pelicula p4 = new Pelicula("Hamnet", "Emotiva", 130);
		servicioCine.getPelicularepo().create(p4);
		Pelicula p5 = new Pelicula("Cumbres Borrascosas", "Romance-Angustia", 132);
		servicioCine.getPelicularepo().create(p5);
		
		Sala s1 = new Sala("Sala infantil", 20);
		Sala s2 = new Sala("Sala pequeña", 15);
		Sala s3 = new Sala("Sala mediana", 30);
		Sala s4  = new Sala("Sala grande", 50);
		
		s1.addPelicla(p2);
		s1.addPelicla(p1);
		s2.addPelicla(p1);
		s3.addPelicla(p3);
		s4.addPelicla(p5);
		
		Cine c1 = new  Cine("Cinesa", "Camas, Sevilla");
		servicioCine.getCinerepo().create(c1);
		c1.addSala(s4);
		c1.addSala(s3);
		servicioCine.getCinerepo().mergeaObjeto(c1);
		
		Cine c2 = new Cine("Cine Yelmo", "Lagoh");
		servicioCine.getCinerepo().create(c2);
		c2.addSala(s1);
		c2.addSala(s2);
		servicioCine.getCinerepo().mergeaObjeto(c2);
		
		List<Pelicula> peliculas = servicioCine.getPelicularepo().getAll();
		for (Pelicula pelicula : peliculas) {
			logger.debug(pelicula);
		}
		
		List<Cine> cines = servicioCine.getCinerepo().getAll();
		for (Cine cine : cines) {
			logger.debug(cine);
		}
		
		List<Sala> salas = servicioCine.getSalarepo().getAll();
		for (Sala sala : salas) {
			logger.debug(sala);
		}
		
		
	}

}
