package dam.accesoDatos.repaso.conversaciones.servicio;

import java.time.LocalDate;

import dam.accesoDatos.repaso.conversaciones.modelo.Conversacion;
import dam.accesoDatos.repaso.conversaciones.modelo.TipoAgente;
import exepciones.ConversacionException;

public interface IServicioConversaciones
{
	
	public void registraNuevaConveracion(TipoAgente tipo, String pregunta, String respuesta);

	public Conversacion getRecuperaConversacion(TipoAgente tipo, String pregunta, LocalDate fecha);

	public boolean eliminaConversacion(LocalDate fecha, TipoAgente tipo) throws ConversacionException;

	public boolean incrementaNumeroValoraciones(LocalDate fecha, TipoAgente tipo, String pregunta);

	public double getValoracionMediaParaHumanos();

	public double getValoracionMedidaParaBots();
}

