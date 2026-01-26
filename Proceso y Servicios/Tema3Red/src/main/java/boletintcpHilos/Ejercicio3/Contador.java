package boletintcpHilos.Ejercicio3;

public class Contador {

	private int numConexiones;

	public Contador(int numConexiones) {
		super();
		this.numConexiones = 1;
	}

	public int getNumConexiones() {
		return numConexiones;
	}

	public synchronized void setNumConexiones(int numConexiones) {
		this.numConexiones = numConexiones;
	}


	@Override
	public String toString() {
		return "Contador numConexiones=" + numConexiones + "]";
	}
	
	
	
}
