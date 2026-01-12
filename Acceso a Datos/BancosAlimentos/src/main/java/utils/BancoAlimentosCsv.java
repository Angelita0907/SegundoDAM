package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controlador.GestionaColaboradoresBancos;
import modelo.CentroLogistico;
import modelo.Trabajador;
import repositorio.RepositorioBancoAlimentos;

public class BancoAlimentosCsv {
	private static final Logger logger = LogManager.getLogger(GestionaColaboradoresBancos.class);
	
	RepositorioBancoAlimentos repo;

	public BancoAlimentosCsv(List<CentroLogistico> listaCentro) {
		super();
		this.repo = new RepositorioBancoAlimentos(listaCentro);
	}


	public void escribeCentrosYTrabajadoresCSV(String nombreArchivo) {

		PrintWriter out = null;

		FileWriter fichero = null;

		try {

			File carpeta = new File("src/main/resources");

			if (!carpeta.exists()) {
				carpeta.mkdirs();

			}

			String rutaCompleta = "src/main/resources/" + nombreArchivo;
			fichero = new FileWriter(rutaCompleta);
			out = new PrintWriter(fichero);

			for (CentroLogistico centro : repo.getListaCentros()) {
                if (centro.getListaTrabajdores() == null || centro.getListaTrabajdores().isEmpty()) {
                    // Centro sin personal
                    out.printf(Locale.US, "%s,%s,%s,%d,\n",
                            centro.getId(),
                            centro.getNombre(),
                            centro.getCiudad(),
                            centro.getComedores());
                } else {
                    // Centro con trabajadores
                    for (Trabajador t : centro.getListaTrabajdores()) {
                        out.printf(Locale.US, "%s,%s,%s,%d,%s,%s,%s,%s,%b\n",
                                centro.getId(),
                                centro.getNombre(),
                                centro.getCiudad(),
                                centro.getComedores(),
                                t.getIdCentroLogistico(),
                                t.getNombre(),
                                t.getDni(),
                                t.getFecha_nacimiento(),
                                t.getTipo());
                    }
                }

			logger.info("CSV generado en: " + rutaCompleta);

			} 
		}
			catch (IOException e) {

			e.printStackTrace();

		} finally {

			if (out != null)
				out.close();

			if (fichero != null) {

				try {

					fichero.close();

				} catch (IOException e) {

					logger.info("Error al cerrar el fichero CSV");

				}

			}

		}

	}

}
