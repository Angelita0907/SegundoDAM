package dam.accesoDatos.repaso.biblioteca.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProbandoLog {
	
	private static final Logger logger = LogManager.getLogger(ProbandoLog.class);


	public static void main(String[] args) {
		//logger.error("Ocurre excepción");
		logger.debug("Esto escribe en el fichero log");

	}

}
