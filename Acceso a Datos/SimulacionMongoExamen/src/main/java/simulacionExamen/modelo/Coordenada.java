package simulacionExamen.modelo;

public class Coordenada {

	private double lat;
	private double lon;

	public Coordenada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coordenada(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "Coordenada [lat=" + lat + ", lon=" + lon + "]";
	}

}
