package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.Enfrentamiento;

public class EnfrentamientoJson {
	
	public void escribeProductoAJson(List<Enfrentamiento> enfrentamiento , String ruta)
	{// Convertir el objeto a JSON
		
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 String json = gson.toJson(enfrentamiento);
		 FileWriter fichero = null;
		 try {
			fichero = new FileWriter(ruta);
			fichero.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fichero != null) {
				try {
					fichero.close();
				} catch (IOException e) {
					System.out.println("Error al escribir enfrentamiento");
				}			
				
			}		
			
		}	   
		 
	}

}
