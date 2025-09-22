package simulacionExamen;

import java.time.LocalDate;

public class Evento {
	
	static int contador;
	private int id;
	private String nombre;
	private final LocalDate fecha = null;
	private int numEntradas;
	private int maxAsistentes;
	private estado estado;
	
	public Evento(int id, String nombre, int numEntradas, int maxAsistentes, estado estado) {
		super();
		this.id = contador;
		this.nombre = nombre;
		this.numEntradas = numEntradas;
		this.maxAsistentes = maxAsistentes;
		this.estado = estado;
		contador = contador+1;
	}
	
	
	

}
