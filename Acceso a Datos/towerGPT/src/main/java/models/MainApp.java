package models;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import repository.RepositorioInteracciones;
import service.ServicioEstadisticaImpl;

public class MainApp {
	
	private static final Logger logger = LogManager.getLogger(RepositorioInteracciones.class);

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String rutaCsv = "src\\main\\resources\\towerGPt.csv";
		String rutaJson = "src\\main\\resources\\towerGPT.json";
		String rutaTxt = "src\\main\\resources\\resumenEstadistica.txt";
		
		RepositorioInteracciones repo = new RepositorioInteracciones();
        ServicioEstadisticaImpl servicio = new ServicioEstadisticaImpl(repo);

		
		// para crear las interacciones le pedí a chatgpt que me los creara sinceramente
		InteraccionAgente i1 = new InteraccionAgente(TipoAgente.HUMANO, "Pregunta 1", "Respuesta 1", 5.2, 4, 80);
        InteraccionAgente i2 = new InteraccionAgente(TipoAgente.IA, "Pregunta 2", "Respuesta 2", 1.5, 5, 95);
        InteraccionAgente i3 = new InteraccionAgente(TipoAgente.HUMANO, "Pregunta 3", "Respuesta 3", 7.0, 3, 70);
        InteraccionAgente i4 = new InteraccionAgente(TipoAgente.IA, "Pregunta 4", "Respuesta 4", 2.3, 4, 90);
        InteraccionAgente i5 = new InteraccionAgente(TipoAgente.HUMANO, "Pregunta 5", "Respuesta 5", 6.8, 5, 85);

        servicio.addInteraccionRegistro(i1);
        servicio.addInteraccionRegistro(i2);
        servicio.addInteraccionRegistro(i3);
        servicio.addInteraccionRegistro(i4);
        servicio.addInteraccionRegistro(i5);
        
        InteraccionAgente mejorValoracion = servicio.obtenerInteraccionConMejorValoracion();
        logger.info("Interacción con mejor valoración: " + mejorValoracion);

        servicio.actualizarPorcentaje(i3, 92);
        servicio.incrementarNumeroValoraciones(i3.getIdentificador());
        logger.info("Se ha modificado la interacción: " + i3);
        //System.out.println("Se ha modificado la interacción: " + i3);
        
		//creamos csv
        List<InteraccionAgente> listaInteracciones = new ArrayList<>(repo.getListaInteracciones());
        try {
			servicio.grabarFicheroCSV(listaInteracciones, rutaCsv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //creamos json
        // voy a poner un logger porque si no sale la consola vavia
        servicio.cargarRegistrosDesdeJSON(listaInteracciones, rutaJson);
        
        //creamos resumen
        //TODO
	}

}
