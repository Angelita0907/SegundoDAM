package repositorio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.CentroLogistico;
import modelo.Trabajador;
import utils.BancoAlimentosException;

public class RepositorioBancoAlimentos {
	
	private static final Logger logger = LogManager.getLogger(RepositorioBancoAlimentos.class);

	private List<CentroLogistico> listaCentros;
	
	public RepositorioBancoAlimentos(List<CentroLogistico> listaCentros) {
		super();
		this.listaCentros = listaCentros;
	}

	public List<CentroLogistico> getListaCentros() {
		return listaCentros;
	}

	public void setListaCentros(List<CentroLogistico> listaCentros) {
		this.listaCentros = listaCentros;
	}
	
	public void agregarCentroLogistico(CentroLogistico c) throws BancoAlimentosException {
		
		int i = 0;
		boolean encontrado = false;
		
		while (!encontrado && i < listaCentros.size()) {
			
			if(listaCentros.get(i).equals(c.getId())) {
				encontrado = true;
				throw new BancoAlimentosException("ya está el centro");
			}
			i++;
		}
		if (encontrado = true) {
			listaCentros.add(c);
		}
		
	}
	
	// agregar trabajador por el centro
	public void agregarTrabajadorACentro(Trabajador t, CentroLogistico c) throws BancoAlimentosException {
		if(t.getIdCentroLogistico().equals(c.getId())) {
			throw new BancoAlimentosException("ya está dentro");
		}
		else {
			t.setIdCentroLogistico(c.getId());
			c.getListaTrabajdores().add(t);
		}
	}
	
	public CentroLogistico mostrarCentro(String id) {
		int i = 0;
		boolean encontrado = false;
		CentroLogistico datosCentro = null;
		
		while(!encontrado && i < listaCentros.size()) {
			if(listaCentros.get(i).getId().equals(id)) {
				datosCentro = listaCentros.get(i);
				encontrado = true;
			}
			i++;
		}

		return datosCentro;
	}
	
	public Trabajador mostrarTrabajador(String dni) {
		int i = 0;
		boolean encontrado = false;
		Trabajador datosTrabajador = null;
		// terminar
		while(!encontrado && i < listaCentros.size()) {
			if(listaCentros.getListaTrabajdores().get(i)) {
				datosTrabajador = listaCentros.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return datosTrabajador;
	}
		

}
