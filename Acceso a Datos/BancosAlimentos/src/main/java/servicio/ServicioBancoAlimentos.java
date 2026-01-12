package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.CentroLogistico;
import modelo.TipoTrabajador;
import modelo.Trabajador;
import repositorio.RepositorioBancoAlimentos;
import utils.BancoAlimentosException;

public class ServicioBancoAlimentos {
	
	RepositorioBancoAlimentos repoBancoAlimentos;

	public ServicioBancoAlimentos(List<CentroLogistico> listaCentros) {
		super();
		this.repoBancoAlimentos = new RepositorioBancoAlimentos(listaCentros);
	}

	public RepositorioBancoAlimentos getRepoBancoAlimentos() {
		return repoBancoAlimentos;
	}

	public void setRepoBancoAlimentos(RepositorioBancoAlimentos repoBancoAlimentos) {
		this.repoBancoAlimentos = repoBancoAlimentos;
	}
	
	public void agregarCentroLogistico(CentroLogistico c) throws BancoAlimentosException {
		repoBancoAlimentos.agregarCentroLogistico(c);
	}
	
	public void agregarTrabajadorACentro(String dni, String centro) throws BancoAlimentosException {
		repoBancoAlimentos.agregarTrabajadorACentro(dni, centro);
	}
	
	public CentroLogistico mostrarCentro(String id) throws BancoAlimentosException {
		return repoBancoAlimentos.mostrarCentro(id);
	}
	
	public Trabajador mostrarTrabajador(String dni) throws BancoAlimentosException {
		return repoBancoAlimentos.mostrarTrabajador(dni);
	}
	
	public List<Trabajador> getColaboradoresPorTipo(TipoTrabajador tipo){
		
		List<Trabajador> listaTrabajadorTipo = new ArrayList<>();
		
		for (CentroLogistico centro : repoBancoAlimentos.getListaCentros()) {
	        for (Trabajador t : centro.getListaTrabajdores()) {
	            if (t.getTipo() == tipo) {
	                listaTrabajadorTipo.add(t);
	            }
	        }
	    }
		
		return listaTrabajadorTipo;
		
	}

}
