<<<<<<< HEAD
package models;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Random;

public class InteraccionAgente implements Comparable<InteraccionAgente> {
	
	private static int contador;
	
	private String identificador;
	private TipoAgente tipoAgente;
	private String peticion;
	private String respuesta;
	private double tiempoEjecucion;
	private int numValoracionesPositivas;
	private double porcentajeAcierto;
	
	public InteraccionAgente(TipoAgente tipoAgente, String peticion, String respuesta) {
		super();
		this.tipoAgente = tipoAgente;
		this.peticion = peticion;
		this.respuesta = respuesta;
		identificador = identificador /*contador+1*/;
	}
	
	public InteraccionAgente(TipoAgente tipoAgente, String peticion, String respuesta, double tiempoEjecucion,
			int numValoracionesPositivas, double porcentajeAcierto) {
		super();
		this.tipoAgente = tipoAgente;
		this.peticion = peticion;
		this.respuesta = respuesta;
		this.tiempoEjecucion = tiempoEjecucion;
		this.numValoracionesPositivas = numValoracionesPositivas;
		this.porcentajeAcierto = porcentajeAcierto;
		identificador = identificador+1;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public TipoAgente getTipoAgente() {
		return tipoAgente;
	}
	public void setTipoAgente(TipoAgente tipoAgente) {
		this.tipoAgente = tipoAgente;
	}
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public double getTiempoEjecucion() {
		return tiempoEjecucion;
	}
	public void setTiempoEjecucion(double tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}
	public int getNumValoracionesPositivas() {
		return numValoracionesPositivas;
	}
	public void setNumValoracionesPositivas(int numValoracionesPositivas) {
		this.numValoracionesPositivas = numValoracionesPositivas;
	}
	public double getPorcentajeAcierto() {
		return porcentajeAcierto;
	}
	public void setPorcentajeAcierto(double porcentajeAcierto) {
		this.porcentajeAcierto = porcentajeAcierto;
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
		InteraccionAgente other = (InteraccionAgente) obj;
		return identificador == other.identificador;
	}

	@Override
	public String toString() {
		return "InteraccionAgente [identificador=" + identificador + ", tipoAgente=" + tipoAgente + ", peticion="
				+ peticion + ", respuesta=" + respuesta + ", tiempoEjecucion=" + tiempoEjecucion
				+ ", numValoracionesPositivas=" + numValoracionesPositivas + ", porcentajeAcierto=" + porcentajeAcierto
				+ "]";
	}

	@Override
	public int compareTo(InteraccionAgente o) {
		// TODO Auto-generated method stub
		return Double.compare(this.porcentajeAcierto, o.getPorcentajeAcierto());
	}
	
	/*
	public String calculaIdentificador() {
		
		Random aleatorio = new Random();
		int num = aleatorio.nextInt();
		
		String numeroString = Integer.toString(num);
		SimpleDateFormat formatoFecha = new SimpleDateFormat("ddMMyyyy");
		String fechaComoCadena = formatoFecha.format(getFechaConversacion());
		this.identificador = num + fechaComoCadena;
		
		return identificador;
		
	}*/
	 
	

}
=======
package models;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Random;

public class InteraccionAgente implements Comparable<InteraccionAgente> {
	
	private static int contador;
	
	private String identificador;
	private TipoAgente tipoAgente;
	private String peticion;
	private String respuesta;
	private double tiempoEjecucion;
	private int numValoracionesPositivas;
	private double porcentajeAcierto;
	
	public InteraccionAgente(TipoAgente tipoAgente, String peticion, String respuesta) {
		super();
		this.tipoAgente = tipoAgente;
		this.peticion = peticion;
		this.respuesta = respuesta;
		identificador = identificador /*contador+1*/;
	}
	
	public InteraccionAgente(TipoAgente tipoAgente, String peticion, String respuesta, double tiempoEjecucion,
			int numValoracionesPositivas, double porcentajeAcierto) {
		super();
		this.tipoAgente = tipoAgente;
		this.peticion = peticion;
		this.respuesta = respuesta;
		this.tiempoEjecucion = tiempoEjecucion;
		this.numValoracionesPositivas = numValoracionesPositivas;
		this.porcentajeAcierto = porcentajeAcierto;
		identificador = identificador+1;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public TipoAgente getTipoAgente() {
		return tipoAgente;
	}
	public void setTipoAgente(TipoAgente tipoAgente) {
		this.tipoAgente = tipoAgente;
	}
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public double getTiempoEjecucion() {
		return tiempoEjecucion;
	}
	public void setTiempoEjecucion(double tiempoEjecucion) {
		this.tiempoEjecucion = tiempoEjecucion;
	}
	public int getNumValoracionesPositivas() {
		return numValoracionesPositivas;
	}
	public void setNumValoracionesPositivas(int numValoracionesPositivas) {
		this.numValoracionesPositivas = numValoracionesPositivas;
	}
	public double getPorcentajeAcierto() {
		return porcentajeAcierto;
	}
	public void setPorcentajeAcierto(double porcentajeAcierto) {
		this.porcentajeAcierto = porcentajeAcierto;
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
		InteraccionAgente other = (InteraccionAgente) obj;
		return identificador == other.identificador;
	}

	@Override
	public String toString() {
		return "InteraccionAgente [identificador=" + identificador + ", tipoAgente=" + tipoAgente + ", peticion="
				+ peticion + ", respuesta=" + respuesta + ", tiempoEjecucion=" + tiempoEjecucion
				+ ", numValoracionesPositivas=" + numValoracionesPositivas + ", porcentajeAcierto=" + porcentajeAcierto
				+ "]";
	}

	@Override
	public int compareTo(InteraccionAgente o) {
		// TODO Auto-generated method stub
		return Double.compare(this.porcentajeAcierto, o.getPorcentajeAcierto());
	}
	
	/*
	public String calculaIdentificador() {
		
		Random aleatorio = new Random();
		int num = aleatorio.nextInt();
		
		String numeroString = Integer.toString(num);
		SimpleDateFormat formatoFecha = new SimpleDateFormat("ddMMyyyy");
		String fechaComoCadena = formatoFecha.format(getFechaConversacion());
		this.identificador = num + fechaComoCadena;
		
		return identificador;
		
	}*/
	 
	

}
>>>>>>> 0b2e203e636caa13e7fb62219d0b34690426ce80
