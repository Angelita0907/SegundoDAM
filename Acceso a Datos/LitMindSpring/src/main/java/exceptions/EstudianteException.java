package exceptions;

public class EstudianteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5166520259073525307L;

	public EstudianteException() {
		super();
	}
	
	public EstudianteException(String mensaje) {
		super(mensaje);
	}

	public EstudianteException(long id) {
		super("Estudiante no encontrado: "+id);
	}
	
}
