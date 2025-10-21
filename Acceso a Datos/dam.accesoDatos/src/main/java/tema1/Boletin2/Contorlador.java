package tema1.Boletin2;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Contorlador {
	
	private static final Logger logger = LogManager.getLogger(Contorlador.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DiffFolder diff = new DiffFolder();
			diff.setCarpetas(
				new File(diff.getRuta(), "carpeta1"),
				new File(diff.getRuta(), "carpeta2")
			);

			for (ResultadoComparacion r : diff.compare()) {

				logger.info(r);
				}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error, no se ha podido comparar");
		}
		
	}

}
