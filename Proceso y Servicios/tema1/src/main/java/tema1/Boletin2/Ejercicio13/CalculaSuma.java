package tema1.Boletin2.Ejercicio13;

public class CalculaSuma {

	public static void main(String[] args) {

		String par = args[0];

		int num = Integer.parseInt(args[1]);

		CalculaSuma calcula = new CalculaSuma();

		System.out.println(calcula.calularSuma(par, num));

	}

	public int calularSuma(String par, int num) {

		int suma = 0;
		if (par.equals("par")) {
			for (int i = 0; i <= num; i++) {

				if (i % 2 == 0) {
					suma = suma + i;
				}
			}
		}

		else if (par.equals("impar")) {
			for (int i = 0; i <= num; i++) {
				if (i % 2 != 0) {
					suma = suma + 1;
				}
			}
		}

		return suma;

	}

}
