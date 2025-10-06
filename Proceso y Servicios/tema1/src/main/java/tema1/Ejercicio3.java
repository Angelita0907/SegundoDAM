package tema1;

import java.io.IOException;

public class Ejercicio3 {

	public static void main(String[] args) {

		//String [] chrome = {"C:\\Users\\alumno\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"};
		String [] cmd = {"cmd.exe","/C" ,"start","cmd.exe","/K","tasklist"};
		
		//ProcessBuilder pb = new ProcessBuilder(chrome);
		ProcessBuilder pb2 = new ProcessBuilder(cmd);
			    try {
					//Process p = pb.start();
					pb2.start();
					System.out.println("Termina cmd");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	}

}
