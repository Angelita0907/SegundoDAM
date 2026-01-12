package repositorio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Equipo;
import modelo.Piloto;


public class RepositorioEquipos {

	private static final Logger logger = LogManager.getLogger(RepositorioEquipos.class);
	
	private List<Equipo> listaEquipos;
	private List<Piloto> listaPiloto;
	
	
	
	public RepositorioEquipos() {
		super();
		this.listaEquipos = new ArrayList<>();
		this.listaPiloto = new ArrayList<>();
	}


	public List<Equipo> getListaEquipos() {
		return listaEquipos;
	}


	public void setListaEquipos(List<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}


	public List<Piloto> getListaPiloto() {
		return listaPiloto;
	}

	
	public void setListaPiloto(List<Piloto> listaPiloto) {
		this.listaPiloto = listaPiloto;
	}

	//añadir y recuperar equipos
	public void agregarEquipo(Equipo equipo) {
		listaEquipos.add(equipo);
	}
	
	public Equipo mostrarEquipo(int idEquipo) {
		
		Equipo equipoMostrar = null;
		
		for (Equipo equipo : listaEquipos) {
			if (equipo.getIdentificadorEquipo() == idEquipo) {
				equipoMostrar = equipo;
            }		
		}
		return equipoMostrar;
	}
	
	// añadir y recuperar pilotos
		public void agregarPiloto(Piloto piloto) {
			listaPiloto.add(piloto);
		}
		
		public Piloto mostrarPiloto(int idPiloto) {
			
			Piloto pilotoMostrar = null;
			
			for (Piloto piloto : listaPiloto) {
				if (piloto.getIdentificadorPiloto() == idPiloto) {
					pilotoMostrar = piloto;
				}
			}
			
			return pilotoMostrar;
		}
		
	// mostrar poiloto especifico de un eqipo
		 public List<Piloto> mostrarPilotoEquipo(int idEquipo) {
		        Equipo equipo = mostrarEquipo(idEquipo);
		        // una lista nueva para guardar los pilotos del equipo en especifico
		        List<Piloto> listaPilotos = new ArrayList<>();
		        if (equipo != null) {
		            listaPilotos = equipo.getListaPilotos();
		        }
		        return listaPilotos;
		    }
		 
	
		 
		 
}
