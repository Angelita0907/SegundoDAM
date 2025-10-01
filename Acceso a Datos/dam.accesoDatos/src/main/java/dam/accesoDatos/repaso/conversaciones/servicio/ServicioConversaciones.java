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
	public boolean eliminaConversacion(LocalDate fecha, TipoAgente tipo, String oregunta) throws ConversacionException {
		boolean borrado = true;
		try {
			repoConversaciones.eliminaConversacion(fecha, tipo, null);
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
		
		return 0;
	}

	@Override
	public double getValoracionMedidaParaBots() {
		// TODO Auto-generated method stub
		return 0;
	}

}
