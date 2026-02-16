package exceptions;

public class LogroException extends RuntimeException {

	private static final long serialVersionUID = -5166520259073525308L;

	public LogroException() {
		super();
	}
	
	public LogroException(String mensaje) {
		super(mensaje);
	}

	public LogroException(long id) {
		super("Logro no encontrado: " + id);
	}
	
}
