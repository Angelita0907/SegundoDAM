package dam.accesoDatos.repaso.biblioteca.servicio;

import java.util.HashSet;

import dam.accesoDatos.repaso.biblioteca.modelo.Genero;
import dam.accesoDatos.repaso.biblioteca.modelo.LibreriaException;
import dam.accesoDatos.repaso.biblioteca.modelo.Libro;
import dam.accesoDatos.repaso.biblioteca.repositorio.LibroRepository;

public class LibroService {
	
	/* el servicio gestiona las excepciones que provocamos en el repositorio
	 * es decir, el servicio hace el try de la funcion del repositorio
	 * y luego si ocurre la excepcion el catch hace lo que tenemos puesto
	 */

	private LibroRepository libRepo;
	
	public LibroService(LibroRepository libRepo) {
		super();
		this.libRepo = libRepo;
	}

	public void libroAdd(Libro l) {
		libRepo.addLibro(l);
	}

	public boolean deleteLibro(String isbn) {
		boolean borrado = true;
		try {
			libRepo.delLibro(isbn);
		} catch (LibreriaException e) {
			borrado = false;
		}

		return borrado;
	}
	
	public boolean actuLibro(String isbn) {
		boolean actualizado = true;
		try {
			libRepo.actuLibro(isbn);
		} catch (LibreriaException e) {
			actualizado = false;
		}
		
		return actualizado;
	}
	
	public HashSet<Libro> listaLibmismoGenero(Genero g){
		
		return libRepo.buscalibrosGenero(g);
	}
	
	public HashSet<Libro> listamismaEditorial(String cif){
		return libRepo.librosCifEditorial(cif);
	}

}
