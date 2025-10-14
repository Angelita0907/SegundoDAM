package tema1.Lectura;

public class Nota {

	private double nota;

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	

	public Nota(double nota) {
		super();
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Nota [nota=" + nota + "]";
	}
	
	
	
}
