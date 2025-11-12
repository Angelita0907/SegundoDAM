package controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Enfrentamiento;
import modelo.Equipo;
import servicio.TorneoService;
import utils.EnfrentamientoJson;
import utils.TorneoDomXML;

public class GestionaTorneo {

	private static final Logger logger = LogManager.getLogger(GestionaTorneo.class);
	
	public static void main(String[] args) {
		
		TorneoDomXML domTorneo = new TorneoDomXML();
		EnfrentamientoJson enfrentamientoAJson = new EnfrentamientoJson();
		
		try {
			List<Equipo> listaEquipos = domTorneo.leerEquipoDesdeXML("torneoGamer.xml");
			List<Enfrentamiento> listaEnfrentamiento = domTorneo.leerEnfrentamientoDesdeXML("torneoGamer.xml");
			
			TorneoService servicioTorneo = new TorneoService();
			
			/*for (Equipo equipo : listaEquipos) {
				servicioTorneo.agregarListaEquipo(equipo);
			}*/
			
			servicioTorneo.agregarListaEquipo(listaEquipos);
			
			servicioTorneo.agregarListaEnfretamiento(listaEnfrentamiento);
						
			/*for (Enfrentamiento enfrentamiento : listaEnfrentamiento) {
				servicioTorneo.agregarListaEnfretamiento(listaEnfrentamiento);
			}*/
			
			String ruta = "src/main/resources/enfrentamientosGanados.json";
			
			enfrentamientoAJson.escribeProductoAJson(listaEnfrentamiento, ruta);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
