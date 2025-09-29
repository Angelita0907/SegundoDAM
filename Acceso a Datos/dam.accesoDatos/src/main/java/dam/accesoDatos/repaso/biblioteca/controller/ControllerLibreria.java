package dam.accesoDatos.repaso.biblioteca.controller;

import java.util.ArrayList;
import java.util.HashSet;

import dam.accesoDatos.repaso.biblioteca.modelo.Editorial;
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
		
		Editorial e1 = new Editorial(null, null, null, null, null);
		Editorial e2 = new Editorial(null, null, null, null, null);
		
		editorialService.editorialAdd(e1);
		editorialService.editorialAdd(e2);

		Libro l1 = new Libro(null, null, null, 0, e2, 0, null);
		Libro l2 = new Libro(null, null, null, 0, e1, 0, null);
		
		libroService.libroAdd(l1);
		libroService.libroAdd(l2);
		
	}

}
