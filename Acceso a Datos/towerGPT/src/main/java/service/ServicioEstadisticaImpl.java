package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.InteraccionAgente;
import models.TipoAgente;
import repository.RepositorioInteracciones;

public class ServicioEstadisticaImpl {
	
	private static final Logger logger = LogManager.getLogger(ServicioEstadisticaImpl.class);
	
	private RepositorioInteracciones repoInteraccioes;
	
	public ServicioEstadisticaImpl(RepositorioInteracciones repoInteraccioes) {
		super();
		this.repoInteraccioes = repoInteraccioes;
	}
	
	public RepositorioInteracciones getRepoInteraccioes() {
		return repoInteraccioes;
	}
	public void setRepoInteraccioes(RepositorioInteracciones repoInteraccioes) {
		this.repoInteraccioes = repoInteraccioes;
	}
	
	//funciones del repositorio
	
	public void inincrementarNumeroValoraciones (String id) {
		repoInteraccioes.incrementarNumeroValoraciones(id);
	}
	
	public void addInteraccionRegistro(InteraccionAgente i) {
		repoInteraccioes.agregarInteraccionARegistro(i);
	}
	
	public void actualizarPorcentaje(InteraccionAgente interaccion, double porcentajeNuevo) {
		repoInteraccioes.agregarInteraccionARegistro(interaccion);
	}
	
	
	public HashSet<InteraccionAgente> obtenerInteraccionConMejorValoracion(){
		
		
		
		return null;
	}
	
	
	public Map<TipoAgente, List<InteraccionAgente>> mostrarInteraccionAgrupadasPorTipo(HashSet<InteraccionAgente> listaInteracciones, TipoAgente tipo) {
		
		Map<TipoAgente, List<InteraccionAgente>> interaccionTipo = new HashMap<TipoAgente, List<InteraccionAgente>>();
		
		if(tipo == TipoAgente.IA) {
			interaccionTipo = agruparPorIA(listaInteracciones);
		}
		else if (tipo == TipoAgente.HUMANO) {
			interaccionTipo = agruparPorHumano(listaInteracciones);
		}
		
		return interaccionTipo;
	}
	
	public Map<TipoAgente, List<InteraccionAgente>> agruparPorIA (HashSet<InteraccionAgente> interacciones){
		
		Map<TipoAgente, List<InteraccionAgente>> interaccionesIA = new HashMap<TipoAgente, List<InteraccionAgente>> ();
		List<InteraccionAgente> listaInteraccionesIA = new ArrayList<>();
		
		for(InteraccionAgente i : interacciones) {
			if(i.getTipoAgente() == TipoAgente.IA)
			{
				listaInteraccionesIA.add(i);
			}
		}
		interaccionesIA.put(TipoAgente.IA, listaInteraccionesIA);
		
		return interaccionesIA;
	}
	
	public Map<TipoAgente, List<InteraccionAgente>> agruparPorHumano (HashSet<InteraccionAgente> interacciones){
			
			Map<TipoAgente, List<InteraccionAgente>> interaccionesHumano = new HashMap<TipoAgente, List<InteraccionAgente>> ();
			List<InteraccionAgente> listaInteraccionesHumano = new ArrayList<>();
			
			for(InteraccionAgente i : interacciones) {
				if(i.getTipoAgente() == TipoAgente.HUMANO)
				{
					listaInteraccionesHumano.add(i);
				}
			}
			interaccionesHumano.put(TipoAgente.IA, listaInteraccionesHumano);
			
			return interaccionesHumano;
		}
	
	
	public void grabarResumenEstadistica(String ruta) {
		
		
		
	}
	
	
	public String obtenerinteraccionesAciertoMayorOrdenadas(double porcentajeAcierto) {
		
		
		
		return null;
	}
	
	
	public void grabarFicheroCSV(List<InteraccionAgente> listaInteracciones, String ruta) {
	
	
	
	}
	
	
	public double obtenerTiempoMedioPorAgente(TipoAgente agente) {
		
		
		
		return 0;
	}
	
	
	public double obtenerPorcentajeMedioPorAgente(TipoAgente agente) {
		
		
		
		return 0;
	}
	
	

}
