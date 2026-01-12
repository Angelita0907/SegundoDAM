package dam.accesoDatos.repaso.conversaciones.repository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;

import dam.accesoDatos.repaso.conversaciones.modelo.Conversacion;
import dam.accesoDatos.repaso.conversaciones.modelo.TipoAgente;
import exepciones.ConversacionException;

public class RepositorioConversaciones implements IRepositorioConversaciones{

	HashSet<Conversacion> listaConversaciones;

	public HashSet<Conversacion> getListaConversaciones() {
		return listaConversaciones;
	}

	public void setListaConversaciones(HashSet<Conversacion> listaConversaciones) {
		this.listaConversaciones = listaConversaciones;
	}

	public RepositorioConversaciones() {
		super();
		this.listaConversaciones = new HashSet<Conversacion>();
	}

	@Override
	public void agregaConversacion(TipoAgente tipo, String pregunta, String respuesta) {
		Conversacion c = new Conversacion(tipo, pregunta, respuesta);
		listaConversaciones.add(c);
	}

	@Override
	public Conversacion getConversacion(LocalDate fecha, TipoAgente tipo, String pregunta)
			throws ConversacionException {
		
		boolean encontrado = false;
		Conversacion conversacionBucada = null;
		Iterator<Conversacion> it = listaConversaciones.iterator();

		while (!encontrado && it.hasNext()) {
			Conversacion conversacionItero = it.next();
			if (conversacionItero.getFechaConversacion().equals(fecha) && conversacionItero.getTipo().equals(tipo) && conversacionItero.getPregunta().equals(pregunta)) {
				encontrado = true;
				conversacionBucada = conversacionItero;
			}
			else {
				throw new ConversacionException(pregunta);
			}
		}
		return conversacionBucada;
	}

	@Override
	public boolean contieneConversacionConversacion(Conversacion conversacion) {
		
		boolean contiene = false;
		
		if(listaConversaciones.contains(conversacion)) {
			contiene = true;
		}
		
		return contiene;
	}

	@Override
	public void eliminaConversacion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException {
		Conversacion encuentraC = this.getConversacion(fecha, tipo, pregunta);
		if (encuentraC == null) {
			throw new ConversacionException("No existe la conversacion.");
		}
		listaConversaciones.remove(encuentraC);
	}

	@Override
	public void incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta)
			throws ConversacionException {
		Conversacion c = this.getConversacion(fecha, tipo, pregunta);
		int incremento = c.getNumValoracionesPositivas()+1;
		c.setNumValoracionesPositivas(incremento);
		
	}


}
