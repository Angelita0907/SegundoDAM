package boletintcpHilos.Ejercicio4;

public class Tablero {
	
	private String[][] tablero;

	public Tablero(String[][] tablero) {
		super();
		this.setTablero(new String[][]{
			{"Crucero", null, null, null},
			{null, null, "Entradas", null},
			{"Masaje", null, null, "1000"}});
	}

	public String[][] getTablero() {
		return tablero;
	}

	public void setTablero(String[][] tablero) {
		this.tablero = tablero;
	}
	

}
