package repaso;

public class PeticionWeb implements Runnable {

	private Servidor semaforo;
	private String nombre;

	public Servidor getSemaforo() {
		return semaforo;
	}

	public PeticionWeb(Servidor semaforo, String nombre) {
		super();
		this.semaforo = semaforo;
		this.setNombre(nombre);
	}

	public void setSemaforo(Servidor semaforo) {
		this.semaforo = semaforo;
	}
	
	public void peticion() {
		System.out.println(nombre + " Realizando petición");
	}

	@Override
	public void run() {
		peticion();
		semaforo.realizaRequest();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
