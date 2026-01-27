package repasoExamen;

import java.util.HashMap;
import java.util.Map;

public class MapaCompartido {

	private Map<Integer, String> mapaVuelos;

	public MapaCompartido() {
		super();
		this.mapaVuelos = new HashMap<>();
	}

	public Map<Integer, String> getMapaVuelos() {
		return mapaVuelos;
	}

	public void setMapaVuelos(Map<Integer, String> mapaVuelos) {
		this.mapaVuelos = mapaVuelos;
	}

	public synchronized String hacerReserva(String reservaVuelo) {

		String reserva = "";

		String [] partes = reservaVuelo.split("y");
		
		int numAsiento = Integer.parseInt(partes[0].trim());
		String nombre = partes[1].trim();
		
		// si no existe la clave no está reservado
		if(!mapaVuelos.containsKey(numAsiento)) {
			
			reserva = "Reserva realizada con éxito";
			System.out.println(reserva);
			mapaVuelos.put(numAsiento, nombre);
		}
		else {
			String ocupado = mapaVuelos.get(nombre);
			reserva = "No es posible realizar la reserva, ya pertenece a "+ ocupado;
		}

		return reserva;
	}

	public void getTodasReservas() {
		
		for (Map.Entry<Integer, String> elementoMapa : mapaVuelos.entrySet()) {
			Integer numAsiento = elementoMapa.getKey();
			String nombre = elementoMapa.getValue();
			
			System.out.println("Número asiento: "+ numAsiento + " a nombre de : "+ nombre);
		}
	}

}
