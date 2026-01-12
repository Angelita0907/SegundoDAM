package controller;

import Exception.CraftersException;
import simulacionExamen.Concierto;
import simulacionExamen.Deportivo;

public class ConcertCraftersMain {

	public static void main(String[] args) throws CraftersException {
		
		Deportivo d1 = new Deportivo(0, null, 0, 0, null, false);
		Concierto c1 = new Concierto(0, null, 0, 0, null, null, args);
	}

}
