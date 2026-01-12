package tema0;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
	/*	
		int[] array = {1,2,3};
		
		Padre p = new Padre();
		
		System.out.println(p.metodo1(array));
		
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(3);

		System.out.println(p.metodo1(lista));
	 */
		
		Padre p = new Padre();
		int[] array = {1,2,3};

		try {
			p.metodo1(array);
		} catch (MiExcepcion e) {
			System.out.println("En el catch");
		}
		finally {
			System.out.println("Esto se ejecuta siempre");
		}
		

	}

}
