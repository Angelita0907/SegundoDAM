package dam.accesoDatos.repaso.biblioteca.repositorio;

import java.util.HashSet;
import java.util.List;

import dam.accesoDatos.repaso.biblioteca.modelo.Editorial;

public class EditorialRepository {

	private HashSet<Editorial> editoriales;

	public EditorialRepository(List<Editorial> editoriales) {
		super();
		this.editoriales = new HashSet<Editorial>();
	}

	public HashSet<Editorial> getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(HashSet<Editorial> editoriales) {
		this.editoriales = editoriales;
	}
	
	public void addEditorial(Editorial e) {
		editoriales.add(e);
	}

}
