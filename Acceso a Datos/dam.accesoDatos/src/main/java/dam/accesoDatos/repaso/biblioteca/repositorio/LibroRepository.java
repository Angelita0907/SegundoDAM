package dam.accesoDatos.repaso.biblioteca.repositorio;

import java.util.HashSet;
import java.util.Iterator;

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
	
	public Libro leeLibro(String isbn)  {
		boolean encontrado = false;
		Libro libroBuscado = null;
		Iterator<Libro> it =libros.iterator();
		 
		while (!encontrado && it.hasNext()) {
			Libro libroItero= it.next();
			if(libroItero.getIsbn().equals(isbn))
			{
				encontrado = true;
				libroBuscado = libroItero;
			}
		}
		
		return libroBuscado;
		
	}
	
	public void delLibro(String isbn) throws LibreriaException {
		Libro libroBuscado = this.leeLibro(isbn);
		if(libroBuscado == null)
		{
			throw new LibreriaException("Libro a borrar no existe ese isbn:"+isbn);
		}
		this.libros.remove(libroBuscado);
	}

}
