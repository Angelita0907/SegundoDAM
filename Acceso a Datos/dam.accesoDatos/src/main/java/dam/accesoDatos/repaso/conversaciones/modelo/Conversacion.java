package dam.accesoDatos.repaso.conversaciones.modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Conversacion {

	private String identificador;
	private TipoAgente tipo;
	private String pregunta;
	private String respuesta;
	private LocalDate fechaConversacion;
	private int numValoracionesPositivas;

	public Conversacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Conversacion(TipoAgente tipo, String pregunta, String respuesta) {
		super();
		calculaIdentificador();
		this.tipo = tipo;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
	}

	public Conversacion(TipoAgente tipo, String pregunta, String respuesta, LocalDate fechaConversacion,
			int numValoracionesPositivas) {
		super();
		calculaIdentificador();
		this.tipo = tipo;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.fechaConversacion = fechaConversacion;
		this.numValoracionesPositivas = numValoracionesPositivas;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public LocalDate getFechaConversacion() {
		return fechaConversacion;
	}

	public void setFechaConversacion(LocalDate fechaConversacion) {
		this.fechaConversacion = fechaConversacion;
	}

	public int getNumValoracionesPositivas() {
		return numValoracionesPositivas;
	}

	public void setNumValoracionesPositivas(int numValoracionesPositivas) {
		this.numValoracionesPositivas = numValoracionesPositivas;
	}

	public TipoAgente getTipo() {
		return tipo;
	}

	public void setTipo(TipoAgente tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conversacion other = (Conversacion) obj;
		return Objects.equals(identificador, other.identificador);
	}

	@Override
	public String toString() {
		return "Conversacion [identificador=" + identificador + ", tipo=" + tipo + ", pregunta=" + pregunta
				+ ", respuesta=" + respuesta + ", fechaConversacion=" + fechaConversacion
				+ ", numValoracionesPositivas=" + numValoracionesPositivas + "]";
	}

	public String calculaIdentificador() {
		
		Random aleatorio = new Random();
		int num = aleatorio.nextInt();
		
		String numeroString = Integer.toString(num);
		SimpleDateFormat formatoFecha = new SimpleDateFormat("ddMMyyyy");
		String fechaComoCadena = formatoFecha.format(getFechaConversacion());
		this.identificador = num + fechaComoCadena;
		
		return identificador;
		
	}
	
}
