package exceptions;

public class LecturaException extends RuntimeException {

	private static final long serialVersionUID = -5166520259073525309L;

	public LecturaException() {
		super();
	}
	
	public LecturaException(String mensaje) {
		super(mensaje);
	}

	public LecturaException(long id) {
		super("Lectura no encontrada: " + id);
	}
	
}