package gestiona;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Equipo;
import modelo.Piloto;
import servicio.ServicioEquipos;
import utils.EquiposAJson;
import utils.Formula1XMLDom;
import utils.Formula1XMLNuevo;

public class GestionaClasificacion {
	
	private static final Logger logger = LogManager.getLogger(GestionaClasificacion.class);


	public static void main(String[] args) {
		
		Formula1XMLDom domFormula1 = new Formula1XMLDom();
		ServicioEquipos equipoServicio = new ServicioEquipos();
		EquiposAJson formula1JSON = new EquiposAJson();
		Formula1XMLNuevo xmlNuevo = new Formula1XMLNuevo();
		
		
		try {
			// crear dom para piloto
			List<Piloto> listaPilotos = domFormula1.leerPilotosDesdeXML("formula1.xml");
			
			for (Piloto piloto : listaPilotos) {
				equipoServicio.agregarPiloto(piloto);
			}
			
			
			//crear dom para equipo
			List<Equipo> listaEquipos = domFormula1.leerEquiposDesdeXML("formula1.xml");
			
			for (Equipo equipo : listaEquipos) {
				equipoServicio.agregarEquipo(equipo);
			}
			
			//asociar piloto al equipo (mirar apuntes)
			for (Piloto piloto : listaPilotos) {
				for (Equipo equipo : listaEquipos) {
					if(piloto.getIdentificadorEquipo() == equipo.getIdentificadorEquipo()) {
						// añadimos al objeto equipo el piloto y asi con los demas de la lista de equipos
						equipo.getListaPilotos().add(piloto);
					}
				}
			}
			
			for (Equipo equipo : listaEquipos) {
			    logger.info("Equipo: " + equipo.getNombreEquipo());
			    for (Piloto piloto : equipo.getListaPilotos()) {
			        logger.info(piloto);
			    }
			}
			
			List<Piloto> mayorPuntos = new ArrayList<>(equipoServicio.listaPilotosPuntuacion(4));
			
			String rutaJson = "src/main/resources/pilotosPuntuacion.json";
			formula1JSON.escribeProductoAJson(mayorPuntos, rutaJson);
			
			String nombreNuevoXML = "equipos_generados.xml";
            xmlNuevo.escribeEquiposEnXML(nombreNuevoXML, listaEquipos);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
