package simulacionExamen;

public class Deportivo extends Evento {

	private boolean televidado;

	public Deportivo(int id, String nombre, int numEntradas, int maxAsistentes, simulacionExamen.estado estado,
			boolean televidado) {
		super(id, nombre, numEntradas, maxAsistentes, estado);
		this.televidado = televidado;
	}

	public boolean isTelevidado() {
		return televidado;
	}

	public void setTelevidado(boolean televidado) {
		this.televidado = televidado;
	}

	@Override
	public double calcularCosteBae() {
		
		double costeBase = 0;
		
		if(televidado == true) {
			costeBase = -10000;
		}
		else if (getMaxAsistentes() >= 3000) {
			costeBase = 150000;
		}
		else {
			costeBase = 75000;
		}
		
		return costeBase;
	}
	
	
	
}
