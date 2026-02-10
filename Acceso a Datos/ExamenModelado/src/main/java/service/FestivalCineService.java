package service;

import repository.CineRepository;
import repository.PeliculaRepository;
import repository.SalaRepository;

public class FestivalCineService {
	
	private SalaRepository salarepo;
	private PeliculaRepository pelicularepo;
	private CineRepository cinerepo;
	
	public FestivalCineService() {
		super();
		this.salarepo = new SalaRepository();
		this.pelicularepo = new PeliculaRepository();
		this.cinerepo = new CineRepository();
	}
	
	public SalaRepository getSalarepo() {
		return salarepo;
	}
	public void setSalarepo(SalaRepository salarepo) {
		this.salarepo = salarepo;
	}
	public PeliculaRepository getPelicularepo() {
		return pelicularepo;
	}
	public void setPelicularepo(PeliculaRepository pelicularepo) {
		this.pelicularepo = pelicularepo;
	}
	public CineRepository getCinerepo() {
		return cinerepo;
	}
	public void setCinerepo(CineRepository cinerepo) {
		this.cinerepo = cinerepo;
	}
	
	

}
