package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.Equipo;
import modelo.Piloto;
import repositorio.RepositorioEquipos;

public class ServicioEquipos {

	private RepositorioEquipos repositorio;

    public ServicioEquipos() {
        this.repositorio = new RepositorioEquipos();
    }

    //metodos repositorio
    
    // equipo

    public void agregarEquipo(Equipo equipo) {
        repositorio.agregarEquipo(equipo);
    }

    public Equipo mostrarEquipo(int idEquipo) {
        return repositorio.mostrarEquipo(idEquipo);
    }

    // pioto

    public void agregarPiloto(Piloto piloto) {
        repositorio.agregarPiloto(piloto);
    }

    public Piloto mostrarPiloto(int idPiloto) {
        return repositorio.mostrarPiloto(idPiloto);
    }

    public List<Piloto> mostrarPilotosDeEquipo(int idEquipo) {
        return repositorio.mostrarPilotoEquipo(idEquipo);
    }
    
    public List<Piloto> listaPilotosPuntuacion(int puntuacion){
    	
    	List<Piloto> pilotosPuntuacion = new ArrayList<>();
    	
    	for (Piloto piloto : repositorio.getListaPiloto()) {
			if(piloto.getPuntos() > puntuacion) {
				pilotosPuntuacion.add(piloto);
			}
		}
		return pilotosPuntuacion;
    	
    }
	
}
