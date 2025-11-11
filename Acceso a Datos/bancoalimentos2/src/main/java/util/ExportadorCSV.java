package util; // (ajusta el paquete si hace falta)

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.CentroLogistico;
import modelo.Trabajador;
import repositorio.RepositorioBancoAlimentos;

public class ExportadorCSV {

	RepositorioBancoAlimentos repo;

    // 🔹 Constructor: recibe directamente la lista de centros
    public ExportadorCSV(List<CentroLogistico> centros) {
        this.repo = new RepositorioBancoAlimentos(centros);
    }

    public void escribeCentrosYTrabajadoresCSV(String nombreArchivo) {
        PrintWriter out = null;
        FileWriter fichero = null;

        try {
            // 🗂️ Crear carpeta "src/main/resources" si no existe
            File carpeta = new File("src/main/resources");
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            // 📄 Crear el archivo dentro de esa carpeta
            String rutaCompleta = "src/main/resources/" + nombreArchivo;
            fichero = new FileWriter(rutaCompleta);
            out = new PrintWriter(fichero);


            // 🔁 Escribir datos
            for (CentroLogistico centro : repo.getCentroslogisticos()) {
                if (centro.getPersonal() == null || centro.getPersonal().isEmpty()) {
                    // Centro sin personal
                    out.printf(Locale.US, "%s,%s,%s,%d,\n",
                            centro.getId(),
                            centro.getNombre(),
                            centro.getCiudad(),
                            centro.getNumeroComedores());
                } else {
                    // Centro con trabajadores
                    for (Trabajador t : centro.getPersonal()) {
                        out.printf(Locale.US, "%s,%s,%s,%d,%s,%s,%s,%s,%b\n",
                                centro.getId(),
                                centro.getNombre(),
                                centro.getCiudad(),
                                centro.getNumeroComedores(),
                                t.getId(),
                                t.getNombre(),
                                t.getDni(),
                                t.getFechaNacimiento(),
                                t.isEsAsalariado());
                    }
                }
            }

            System.out.println("CSV generado en: " + rutaCompleta);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el fichero CSV");
                }
            }
        }
    }
	public void generaJSONnoenventa(List<CentroLogistico> centroslogisticos) throws Exception {

	    String rutaSalida = "src/main/resources/" + "jsoncontros.json";
		
	    Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
	    
	    try (FileWriter writer = new FileWriter(rutaSalida)) {
	        gson.toJson(centroslogisticos, writer);
	        System.out.println(("CREADO"));
	       
	    } catch (IOException e) {
	    	 System.out.println(("no CREADO"));	    }
	}
}
