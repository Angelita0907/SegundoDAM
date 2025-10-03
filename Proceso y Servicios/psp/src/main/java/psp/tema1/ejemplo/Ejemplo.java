package psp.tema1.ejemplo;

import java.io.IOException;

public class Ejemplo {

	public static void main(String[] args) {
		
		Runtime kernel = Runtime.getRuntime();
		
		System.out.println(kernel.totalMemory());
		System.out.println(kernel.maxMemory());
		System.out.println(kernel.freeMemory());
		
		String [] informacionProceso = {"C:\\Users\\alumno\\AppData\\Local\\Google\\Chrome\\Application\\chrome"};
		Process proceso;
		
		try {
			proceso = kernel.exec(informacionProceso);
			kernel.exec(informacionProceso);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
