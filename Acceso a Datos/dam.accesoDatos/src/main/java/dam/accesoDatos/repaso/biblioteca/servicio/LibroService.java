package dam.accesoDatos.repaso.biblioteca.servicio;

import dam.accesoDatos.repaso.biblioteca.modelo.LibreriaException;
import dam.accesoDatos.repaso.biblioteca.repositorio.LibroRepository;

public class LibroService {
	
	private LibroRepository repositorio;
	
	boolean deleteLibro(String isbn)
	{
		boolean borrado= true;
		try {
		repositorio.delLibro(isbn);
		}
		catch(LibreriaException e)
		{
			borrado = false;
		}
		
		return borrado;
	
	}

}
