package semaforos.ejercicio4;

public class PeticionWeb implements Runnable{

	private final Servidor servidor;
	
	private String nombre;
	
	
	public PeticionWeb(Servidor servidor, String nombre) {
		super();
		this.servidor = servidor;
		this.setNombre(nombre);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public void run() {

		servidor.realizaRequest();
		
	}

}
