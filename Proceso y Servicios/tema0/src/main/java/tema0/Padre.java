package tema0;
import java.util.List;

public class Padre {
	
	public void metodo1(int [] numeros) throws MiExcepcion {
		int suma = 0;
		for(int i : numeros) {
			suma = suma + i;
		}
	
		throw new MiExcepcion("Viva España");
					
	}
	
	public int metodo1(List<Integer>tabla) {
		int suma = 0;
		for(int i : tabla) {
			suma = suma+ i;
		}
		return suma;
	}

}
