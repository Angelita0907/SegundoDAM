package dam.accesoDatos.repaso.biblioteca.controller;

import java.util.ArrayList;
import java.util.HashSet;

import dam.accesoDatos.repaso.biblioteca.modelo.Editorial;
import dam.accesoDatos.repaso.biblioteca.modelo.Genero;
import dam.accesoDatos.repaso.biblioteca.modelo.Libro;
import dam.accesoDatos.repaso.biblioteca.repositorio.EditorialRepository;
import dam.accesoDatos.repaso.biblioteca.repositorio.LibroRepository;
import dam.accesoDatos.repaso.biblioteca.servicio.EditorialService;
import dam.accesoDatos.repaso.biblioteca.servicio.LibroService;

public class ControllerLibreria {

	public static void main(String[] args) {
		
		EditorialRepository editorialRepo = new EditorialRepository(new ArrayList<>());
		LibroRepository libroRepo = new LibroRepository(new HashSet<>());
		
		EditorialService editorialService = new EditorialService(editorialRepo);
		LibroService libroService = new LibroService(libroRepo);
		
		Editorial e1 = new Editorial("Editorial Planeta", "Calle de la Princesa, 10, Madrid, España", "B-28010001", "https://www.planetadelibros.com", "contacto@planetadelibros.com");
		Editorial e2 = new Editorial("Grupo SM", "Avenida de América, 42, Madrid, España", "A-28020002", "https://www.grupo-sm.com", "info@grupo-sm.com");
		Editorial e3 = new Editorial("Alfaguara", "Calle de Alcalá, 45, Madrid, España", "B-28030003", "https://www.alfaguara.com", "contacto@alfaguara.com");
		Editorial e4 = new Editorial("Anaya", "Paseo de la Castellana, 150, Madrid, España", "A-28040004", "https://www.anaya.es", "info@anaya.es");
		Editorial e5 = new Editorial("Edebé", "Calle de Serrano, 30, Madrid, España", "B-28050005", "https://www.edebe.com", "contacto@edebe.com");

		editorialService.editorialAdd(e1);
		editorialService.editorialAdd(e2);
		editorialService.editorialAdd(e3);
		editorialService.editorialAdd(e4);
		editorialService.editorialAdd(e5);

		Libro l1 = new Libro("978-3-16-148410-0", "El Reino de las Sombras", "Laura Vázquez", 2023, e1, 200, Genero.DRAMA);
		Libro l2 = new Libro("978-1-4028-9462-6", "Misterios en la Niebla", "Martín Gómez", 2024, e2, 150, Genero.HISTÓRICO);
		Libro l3 = new Libro("978-0-14-312855-3", "Los Viajeros del Tiempo", "Sofía Rivera", 2025, e3, 120, Genero.HISTÓRICO);
		Libro l4 = new Libro("978-84-987654-3-2", "La Rebelión de los Sueños", "Sara Navarro", 2025, e2, 210, Genero.ROMÁNTICO); 
		Libro l5 = new Libro("978-84-192837-4-5", "Exploradores del Más Allá", "David Molina", 2024, e3, 180, Genero.DRAMA); 
		
		libroService.libroAdd(l1);
		libroService.libroAdd(l2);
		libroService.libroAdd(l3);
		libroService.libroAdd(l4);
		libroService.libroAdd(l5);
		
	}

}
