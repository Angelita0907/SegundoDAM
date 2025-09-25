package dam.accesoDatos.repaso.biblioteca.servicio;

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
	
}
