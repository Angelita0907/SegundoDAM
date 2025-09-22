package simulacionExamen;

public class Concierto extends Evento {

	private String artistaPrincipa;
	private String invitados[];

	public Concierto(int id, String nombre, int numEntradas, int maxAsistentes, simulacionExamen.estado estado,
			String artistaPrincipa, String[] invitados) {
		super(id, nombre, numEntradas, maxAsistentes, estado);
		this.artistaPrincipa = artistaPrincipa;
		this.invitados = new String[10];
	}

	public String getArtistaPrincipa() {
		return artistaPrincipa;
	}

	public void setArtistaPrincipa(String artistaPrincipa) {
		this.artistaPrincipa = artistaPrincipa;
	}

	public String[] getInvitados() {
		return invitados;
	}

	public void setInvitados(String[] invitados) {
		this.invitados = invitados;
	}

	@Override
	public double calcularCosteBae() {
		double costeBase = 0;
		return costeBase;
	}

}
