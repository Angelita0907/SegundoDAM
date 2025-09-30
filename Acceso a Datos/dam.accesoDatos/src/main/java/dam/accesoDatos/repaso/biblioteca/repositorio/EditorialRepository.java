package dam.accesoDatos.repaso.biblioteca.repositorio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import dam.accesoDatos.repaso.biblioteca.modelo.Editorial;
import dam.accesoDatos.repaso.biblioteca.modelo.LibreriaException;

public class EditorialRepository {

	private List<Editorial> editoriales;

	public EditorialRepository(List<Editorial> editoriales) {
		super();
		this.editoriales = new ArrayList<Editorial>();
	}

	public List<Editorial> getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(List<Editorial> editoriales) {
		this.editoriales = editoriales;
	}
	
	public void addEditorial(Editorial e) {
		editoriales.add(e);
	}
	
	public Editorial buscaEditorial(String cif)  {
		boolean encontrado = false;
		Editorial editorialEncontrada = null;
		Iterator<Editorial> it = editoriales.iterator();
		 
		while (!encontrado && it.hasNext()) {
			Editorial ediItero= it.next();
			if(ediItero.getCif().equals(cif))
			{
				encontrado = true;
				editorialEncontrada = ediItero;
			}
		}
		return editorialEncontrada;
	}
	
	public void delEditorial(String cif) throws LibreriaException {
		Editorial editorialBuscada = this.buscaEditorial(cif);
		if (editorialBuscada == null) {
			throw new LibreriaException("La editorial a borrar no existe ese cif: "+cif);
		}
		this.editoriales.remove(editorialBuscada);
	}
	
	

}
