package boletintcpHilos.Ejercicio4;

public class Contador {

	private int numConexiones;

	public Contador(int numConexiones) {
		super();
		this.numConexiones = 0;
	}

	public int getNumConexiones() {
		return numConexiones;
	}
	
	public synchronized int incrementar() {
       return numConexiones++;
    }

	public void setNumConexiones(int numConexiones) {
		this.numConexiones = numConexiones;
	}


	@Override
	public String toString() {
		return "Contador numConexiones=" + numConexiones + "]";
	}
	
	
	
}
