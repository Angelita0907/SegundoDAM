<<<<<<< HEAD
package repository;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import models.InteraccionAgente;

public class RepositorioInteracciones {
	
	private static final Logger logger = LogManager.getLogger(RepositorioInteracciones.class);
	
	private ArrayList<InteraccionAgente> listaInteracciones;
	

	public RepositorioInteracciones() {
		super();
		this.listaInteracciones = new ArrayList<>();
	}
	
	
	public ArrayList<InteraccionAgente> getListaInteracciones() {
		return listaInteracciones;
	}
	public void setListaInteracciones(ArrayList<InteraccionAgente> listaInteracciones) {
		this.listaInteracciones = listaInteracciones;
	}
	
	public void incrementarNumeroValoraciones(String identificador) {
		
		for (InteraccionAgente interaccion : listaInteracciones) {
	        if (interaccion.getIdentificador().equals(identificador)) {
	            int valoracionActual = interaccion.getNumValoracionesPositivas();
	            interaccion.setNumValoracionesPositivas(valoracionActual + 1);
	        }
	    }
		
	}
	public void agregarInteraccionARegistro(InteraccionAgente interaccion) {		
		listaInteracciones.add(interaccion);
	}
	
	public void actualizaPorcentajeInteraccion(InteraccionAgente interaccion, double porcentajeNuevo) {
		
		for(InteraccionAgente i : listaInteracciones) {
			i.setPorcentajeAcierto(porcentajeNuevo);
		}
	}
	

	
}
=======
package repository;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import models.InteraccionAgente;

public class RepositorioInteracciones {
	
	private static final Logger logger = LogManager.getLogger(RepositorioInteracciones.class);
	
	private ArrayList<InteraccionAgente> listaInteracciones;
	

	public RepositorioInteracciones() {
		super();
		this.listaInteracciones = new ArrayList<>();
	}
	
	
	public ArrayList<InteraccionAgente> getListaInteracciones() {
		return listaInteracciones;
	}
	public void setListaInteracciones(ArrayList<InteraccionAgente> listaInteracciones) {
		this.listaInteracciones = listaInteracciones;
	}
	
	public void incrementarNumeroValoraciones(String identificador) {
		
		for (InteraccionAgente interaccion : listaInteracciones) {
	        if (interaccion.getIdentificador().equals(identificador)) {
	            int valoracionActual = interaccion.getNumValoracionesPositivas();
	            interaccion.setNumValoracionesPositivas(valoracionActual + 1);
	        }
	    }
		
	}
	public void agregarInteraccionARegistro(InteraccionAgente interaccion) {		
		listaInteracciones.add(interaccion);
	}
	
	public void actualizaPorcentajeInteraccion(InteraccionAgente interaccion, double porcentajeNuevo) {
		
		for(InteraccionAgente i : listaInteracciones) {
			i.setPorcentajeAcierto(porcentajeNuevo);
		}
	}
	

	
}
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
