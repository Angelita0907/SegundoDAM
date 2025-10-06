package tema1;

import java.io.IOException;

public class Ejemplo {

	public static void main(String[] args) {
		Runtime kernel = Runtime.getRuntime();
		
		System.out.println(kernel.totalMemory());
		System.out.println(kernel.maxMemory());
		System.out.println(kernel.freeMemory());
		String [] arguments = {"C:\\Users\\alumno\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"};
		try {
			Process proceso = kernel.exec(arguments);
			int codigoRetorno = proceso.waitFor();// espero a que termine
			System.out.println("----- Llego al final");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	
}
