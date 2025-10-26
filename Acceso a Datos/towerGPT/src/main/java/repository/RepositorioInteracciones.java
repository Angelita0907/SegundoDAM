package repository;
import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import models.InteraccionAgente;

public class RepositorioInteracciones {
	
	private static final Logger logger = LogManager.getLogger(RepositorioInteracciones.class);
	
	private HashSet<InteraccionAgente> listaInteracciones;
	

	public RepositorioInteracciones(HashSet<InteraccionAgente> listaInteracciones) {
		super();
		this.listaInteracciones = new HashSet<>();
	}
	
	
	public HashSet<InteraccionAgente> getListaInteracciones() {
		return listaInteracciones;
	}
	public void setListaInteracciones(HashSet<InteraccionAgente> listaInteracciones) {
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
		
		interaccion.setPorcentajeAcierto(porcentajeNuevo);
		
	}

	
}
