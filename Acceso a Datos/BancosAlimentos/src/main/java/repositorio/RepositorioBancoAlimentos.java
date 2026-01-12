package repositorio;

import java.util.Iterator;
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
		if (!encontrado) {
			listaCentros.add(c);
		}
		
	}
	
	// agregar trabajador por el centro
	public void agregarTrabajadorACentro(String dni, String centro) throws BancoAlimentosException {
		boolean encontrado = false;
		CentroLogistico centroEncontrado = null;

		Iterator<CentroLogistico> itCentros = listaCentros.iterator();
		while (itCentros.hasNext() && !encontrado) {
			CentroLogistico c = itCentros.next();
			if (c.getId().equalsIgnoreCase(centro)) {
				centroEncontrado = c;
				encontrado = true;
			}
		}

		if (!encontrado) {
			throw new BancoAlimentosException("No se encontró el centro logístico");
		}

		Iterator<Trabajador> itTrabajadores = centroEncontrado.getListaTrabajdores().iterator();
		while (itTrabajadores.hasNext() && !encontrado) {
			Trabajador t = itTrabajadores.next();
			if (t.getDni().equalsIgnoreCase(dni)) {
				throw new BancoAlimentosException("El trabajador ya existe en este centro");
			} else {
				centroEncontrado.getListaTrabajdores().add(t);
			}
		}
	}
	
	public CentroLogistico mostrarCentro(String id) throws BancoAlimentosException {
		boolean encontrado = false;
		CentroLogistico centro = null;

		Iterator<CentroLogistico> it = listaCentros.iterator();
		while (it.hasNext() && !encontrado) {
			CentroLogistico c = it.next();

			if (c.getId().equalsIgnoreCase(id)) {
				encontrado = true;
				centro = c;
			}
		}

		if (!encontrado)
			throw new BancoAlimentosException("No se encuentra ningún centro asociado a ese id");

		return centro;
	}
	
	public Trabajador mostrarTrabajador(String dni) throws BancoAlimentosException {
		boolean encontrado = false;
		Trabajador trabajador = null;

		Iterator<CentroLogistico> itCentros = listaCentros.iterator();
		while (itCentros.hasNext()) {
			CentroLogistico centro = itCentros.next();

			Iterator<Trabajador> it = centro.getListaTrabajdores().iterator();
			while (it.hasNext() && !encontrado) {
				Trabajador t = it.next();
				if (t.getDni().equalsIgnoreCase(dni)) {
					encontrado = true;
					trabajador = t;

				} 
				
			}
			throw new BancoAlimentosException("No se encuentra ningún trabajador asociado a ese dni");
		}
		return trabajador;
	}
		

}
