package dam.accesoDatos.repaso.biblioteca.servicio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import dam.accesoDatos.repaso.biblioteca.modelo.CompararNumLibros;
import dam.accesoDatos.repaso.biblioteca.modelo.Editorial;
import dam.accesoDatos.repaso.biblioteca.modelo.LibreriaException;
import dam.accesoDatos.repaso.biblioteca.repositorio.EditorialRepository;

public class EditorialService {

	private EditorialRepository editorialRepo;

	public EditorialService(EditorialRepository editorialRepo) {
		super();
		this.editorialRepo = editorialRepo;
	}
	
	public void editorialAdd(Editorial e) {
		editorialRepo.addEditorial(e);
	}
	
	public boolean deleteEditorial(String cif) {
		boolean borrado = true;
		try {
			editorialRepo.delEditorial(cif);
		} catch (LibreriaException e) {
			borrado = false;
		}
		
		return borrado;
	}
	
	public List<Editorial> editorialOrdenada(){
		
		List<Editorial> editorialesOrden = new ArrayList<>();
		
		for(Editorial e : editorialRepo.getEditoriales()) {
			editorialesOrden.add(e);
		}
		
		return editorialesOrden;
	}
	
	public List<Editorial>  ordenaEditorialEmail() {
		// lo ponemos a lista para poder usar comparator con sort
		CompararNumLibros c = new CompararNumLibros();
		List<Editorial> editorialOrd = editorialRepo.getEditoriales();
		editorialOrd.sort(c);//void
		
		return editorialOrd;
		
	}
	
	
}
