package dam.accesoDatos.repaso.biblioteca.repositorio;

import java.util.HashSet;
import java.util.Iterator;

import dam.accesoDatos.repaso.biblioteca.modelo.Editorial;
import dam.accesoDatos.repaso.biblioteca.modelo.Genero;
import dam.accesoDatos.repaso.biblioteca.modelo.LibreriaException;
import dam.accesoDatos.repaso.biblioteca.modelo.Libro;

public class LibroRepository {

	private HashSet<Libro> libros;

	public LibroRepository(HashSet<Libro> libros) {
		super();
		this.libros = new HashSet<Libro>();
	}

	public HashSet<Libro> getLibros() {
		return libros;
	}

	public void setLibros(HashSet<Libro> libros) {
		this.libros = libros;
	}

	public void addLibro(Libro l) {
		libros.add(l);
	}

	public Libro leeLibro(String isbn) {
		boolean encontrado = false;
		Libro libroBuscado = null;
		Iterator<Libro> it = libros.iterator();

		while (!encontrado && it.hasNext()) {
			Libro libroItero = it.next();
			if (libroItero.getIsbn().equals(isbn)) {
				encontrado = true;
				libroBuscado = libroItero;
			}
		}

		return libroBuscado;

	}

	public void delLibro(String isbn) throws LibreriaException {
		Libro libroBuscado = this.leeLibro(isbn);
		if (libroBuscado == null) {
			throw new LibreriaException("Libro a borrar no existe ese isbn:" + isbn);
		}
		this.libros.remove(libroBuscado);
	}

	public void actuLibro(String isbn) throws LibreriaException {
		Libro libroBuscado = this.leeLibro(isbn);
		if (libroBuscado == null) {
			throw new LibreriaException("Libro a modificar no existe ese isbn:" + isbn);
		}
		// actualizar dato de un libro

	}

	public HashSet<Libro> buscalibrosGenero(Genero genero) {

		HashSet<Libro> librosGenero = new HashSet<Libro>();

		for (Libro l : libros) {
			if (l.getGenero().equals(genero)) {
				librosGenero.add(l);
			}
		}
		return librosGenero;
	}

	public HashSet<Libro> librosCifEditorial(String cif) {

		HashSet<Libro> mismaEditorial = new HashSet<Libro>();

		for (Libro l : libros) {
			if (l.getEditorial().getCif().equals(cif)) {
				mismaEditorial.add(l);
			}
		}

		return mismaEditorial;
	}

}
