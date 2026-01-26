package boletintcpHilos.Ejercicio4;

public class Tablero {
	
	private String[][] tablero;

	public Tablero() {
		super();
		this.tablero = new String[][]{
			{"Crucero", null, null, null},
			{null, null, "Entradas", null},
			{"Masaje", null, null, "1000"}};
	}
	
	// para saber si hay premio el cliente introduce fila y columna
	
	public synchronized String intento(int fila, int columna) {
		
		String acierto = null;
		
		if (fila >= 0 && fila < 3 && columna >= 0 && columna < 4) {
			acierto = tablero[fila][columna];
			if (acierto != null) {
				tablero[fila][columna] = null; 
			}
		}
		
		return acierto;
	}
	
	public void mostrarPremios() {
		System.out.print("Posiciones con premio: ");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != null) {
                    System.out.print("[" + (i + 1) + ", " + (j + 1) + "] ");
                }
            }
        }
	}

	public String[][] getTablero() {
		return tablero;
	}

	public void setTablero(String[][] tablero) {
		this.tablero = tablero;
	}
	

}
