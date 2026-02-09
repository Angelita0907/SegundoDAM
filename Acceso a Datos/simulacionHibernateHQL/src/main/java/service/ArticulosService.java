package service;

import dao.ArticuloDao;
import dao.AutorDao;
import dao.RevistaDao;

public class ArticulosService {
	
	private ArticuloDao articuloRepository;
	private AutorDao autorRepository;
	private RevistaDao revistaRepository;
	
	
	
	public ArticulosService(ArticuloDao articuloRepository, AutorDao autorRepository, RevistaDao revistaRepository) {
		super();
		this.articuloRepository = new ArticuloDao();
		this.autorRepository = new AutorDao();
		this.revistaRepository = new RevistaDao();
	}
	
	
	
	public ArticuloDao getArticuloRepository() {
		return articuloRepository;
	}
	public void setArticuloRepository(ArticuloDao articuloRepository) {
		this.articuloRepository = articuloRepository;
	}
	public AutorDao getAutorRepository() {
		return autorRepository;
	}
	public void setAutorRepository(AutorDao autorRepository) {
		this.autorRepository = autorRepository;
	}
	public RevistaDao getRevistaRepository() {
		return revistaRepository;
	}
	public void setRevistaRepository(RevistaDao revistaRepository) {
		this.revistaRepository = revistaRepository;
	}
	
	

}
