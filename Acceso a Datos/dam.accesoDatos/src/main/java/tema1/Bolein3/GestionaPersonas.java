package tema1.Bolein3;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utils.ManejaFicheroPersona;

public class GestionaPersonas {
	private static final Logger logger = LogManager.getLogger(GestionaPersonas.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Nota> listaNotas = new ArrayList<Nota>();
		ManejaFicheroPersona p =new ManejaFicheroPersona();
		try {
			p.cargarLista(
					"C:\\Users\\alumno\\Desktop\\SegundoDAM\\Acceso a Datos\\dam.accesoDatos\\src\\main\\resources\\alumnosNotas");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
