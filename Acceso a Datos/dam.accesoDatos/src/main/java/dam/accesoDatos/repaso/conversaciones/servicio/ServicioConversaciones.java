package dam.accesoDatos.repaso.conversaciones.servicio;

import java.time.LocalDate;

import dam.accesoDatos.repaso.conversaciones.modelo.Conversacion;
import dam.accesoDatos.repaso.conversaciones.modelo.TipoAgente;
import dam.accesoDatos.repaso.conversaciones.repository.RepositorioConversaciones;
import exepciones.ConversacionException;

public class ServicioConversaciones implements IServicioConversaciones{

	private RepositorioConversaciones repoConversaciones;

	public ServicioConversaciones(RepositorioConversaciones repoConversaciones) {
		super();
		this.repoConversaciones = repoConversaciones;
	}

	@Override
	public void registraNuevaConveracion(TipoAgente tipo, String pregunta, String respuesta) {
		repoConversaciones.agregaConversacion(tipo, pregunta, respuesta);
	}

	@Override
	public Conversacion getRecuperaConversacion(TipoAgente tipo, String pregunta, LocalDate fecha) {
		Conversacion convrecu = null;
        try {
        	convrecu = repoConversaciones.getConversacion(fecha, tipo, pregunta);
        } catch (ConversacionException e) {
        	e.getMessage();
        }
        return convrecu;
	}

	@Override
	public boolean eliminaConversacion(LocalDate fecha, TipoAgente tipo, String pregunta) throws ConversacionException {
		boolean borrado = true;
		try {
			repoConversaciones.eliminaConversacion(fecha, tipo, pregunta);
		} catch (ConversacionException e) {
			borrado = false;
		}

		return borrado;
	}

	@Override
	public boolean incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta) {
		boolean aumenta = false;
        try {
            repoConversaciones.incrementaNumeroValoraciones(fecha, tipo, pregunta);
            aumenta = true;
        } catch (ConversacionException e) {
            e.getMessage();
        }
        return aumenta;
	}

	@Override
	public double getValoracionMediaParaHumanos() {
		
		RepositorioConversaciones repoC = new RepositorioConversaciones();
		int totalC = 0;
		int contador = 0;
		double mediaHumano = 0;
		
		for (Conversacion conversacionItero : repoC.getListaConversaciones()) {
			
			totalC = conversacionItero.getNumValoracionesPositivas();
			
			if (conversacionItero.getTipo().equals(TipoAgente.HUMANO)) {
				contador++;
			}
		}
		return mediaHumano = totalC/contador;
	}

	@Override
	public double getValoracionMedidaParaBots() {
		RepositorioConversaciones repoC = new RepositorioConversaciones();
		int totalC = repoC.getListaConversaciones().size();
		int contador = 0;
		double mediaIA = 0;
		
		for (Conversacion conversacionItero : repoC.getListaConversaciones()) {
			if (conversacionItero.getTipo().equals(TipoAgente.IA)) {
				contador++;
			}
		}
		return mediaIA = totalC/contador;
	}

}
