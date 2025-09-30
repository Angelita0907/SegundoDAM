package dam.accesoDatos.repaso.biblioteca.modelo;

import java.util.Comparator;

public class CompararNumLibros implements Comparator<Editorial> {


	@Override
	public int compare(Editorial o1, Editorial o2) {
		// TODO Auto-generated method stub
		return o1.getEmail().compareTo(o2.getEmail());
	}

}
