package repositorio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.BancoAlimentoException;
import modelo.CentroLogistico;
import modelo.Trabajador;


public class RepositorioBancoAlimentos {

	
	private static final Logger logger = LogManager.getLogger(RepositorioBancoAlimentos.class);
	
	
	
	List<CentroLogistico> centroslogisticos= new ArrayList<>();
	
	
	
		public RepositorioBancoAlimentos(List<CentroLogistico> centroslogisticos) {
		super();
		this.centroslogisticos = centroslogisticos;
	}


	public void agregacentrologistico (CentroLogistico centrologistico) throws BancoAlimentoException {
	int i =0;
	boolean	encontrado=false;
	
	while(!encontrado && i< centroslogisticos.size()) {
	
			if (centroslogisticos.get(i).equals(centrologistico.getId())){
				encontrado=true;
				throw new BancoAlimentoException("ya existe");
				}
			i++;
		}
	
		
	if(encontrado=true) {
	centroslogisticos.add(centrologistico);

		}
	}
	
	
	public void agregartrabajadoracentro(Trabajador trabajador, CentroLogistico centro) throws BancoAlimentoException {
		if(trabajador.getId().equals(centro.getId())) {
			throw new BancoAlimentoException("ya existe");

		}
		else {
			trabajador.setId(centro.getId());
			centro.getPersonal().add(trabajador);
		}
	}
	
	public CentroLogistico mostrarcentrologistico(String id) {
		int i =0;
		boolean	encontrado=false;
		CentroLogistico centro= null;
		while(!encontrado && i< centroslogisticos.size()) {
			
			if (centroslogisticos.get(i).getId().equals(id)){
				encontrado=true;
				centro= centroslogisticos.get(i);
			}
			i++;
		}
		return centro;
		
		
	}
	public Trabajador mostrarcolaborador(String id) {
		int i =0;
		int j =0;

		boolean	encontrado=false;
		boolean	encontrado2=false;

		Trabajador trabajador= null;

	    while (!encontrado && i < centroslogisticos.size()) {
	        CentroLogistico centro = centroslogisticos.get(i);

	        while (!encontrado2 && j < centro.getPersonal().size()) {
	            Trabajador t = centro.getPersonal().get(j);
	            if (t.getId().equals(id)) {
	                trabajador = t;
	                encontrado = true;
	                encontrado2 = true;
	            }
	            j++;
	        }
	        i++;
	    }
	
	    return trabajador;
	}


	public List<CentroLogistico> getCentroslogisticos() {
		return centroslogisticos;
	}


	public void setCentroslogisticos(List<CentroLogistico> centroslogisticos) {
		this.centroslogisticos = centroslogisticos;
	}
	
}	
		
		
	

