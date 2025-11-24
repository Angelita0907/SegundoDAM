package boletin3.ejercicio1;

public class CalculaMaxHilo implements Runnable{
	private int[] tabla;
	private int inicio;
	private int fin;
	private int maximoTramo;
	

	public int[] getTabla() {
		return tabla;
	}

	public void setTabla(int[] tabla) {
		this.tabla = tabla;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public int getMaximoTramo() {
		return maximoTramo;
	}

	public void setMaximoTramo(int maximoTramo) {
		this.maximoTramo = maximoTramo;
	}

	// coge la posicion que tenga el valor mas alto y lo sustituye por el anterior que tenia guardaddo
	private int calculaMax() {
		int maxTotal = tabla[inicio];
		for (int i = inicio; i < fin; i++) {
			if (tabla[i] > maxTotal) {
				maxTotal = tabla[i];
			}
		}
		System.out.println("Maximo del rango "+inicio+" - "+fin+":"+maxTotal);
		return maxTotal;

	}
	
	@Override
	public void run() {
		maximoTramo = calculaMax();
		
	}
	
}

