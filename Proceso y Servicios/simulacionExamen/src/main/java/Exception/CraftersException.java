package Exception;

public class CraftersException extends Exception {

	public CraftersException(String message) {
        super(message);
        System.out.println("Lanzo mi excepcion con: ");
    }
	
}
