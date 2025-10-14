package tema1.Boletin2;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DiffFolder {
	private static final Logger logger = LogManager.getLogger(DiffFolder.class);

	private File directorio1;
	private File directorio2;
	private Set<ResultadoComparacion> comparacion;
	
	public DiffFolder(File directorio1, File directorio2) {
		super();
		this.directorio1 = directorio1;
		this.directorio2 = directorio2;
		this.comparacion = new HashSet<>();
	}

	public File getDirectorio1() {
		return directorio1;
	}

	public void setDirectorio1(File directorio1) {
		this.directorio1 = directorio1;
	}

	public File getDirectorio2() {
		return directorio2;
	}

	public void setDirectorio2(File directorio2) {
		this.directorio2 = directorio2;
	}
	
	public Set<ResultadoComparacion> getComparacion() {
		return comparacion;
	}

	public void setComparacion(Set<ResultadoComparacion> comparacion) {
		this.comparacion = comparacion;
	}

	private Set<ResultadoComparacion> comparaListaFicheros(File[] dir1, File[] dir2){
		//recorro dichero1, para cada uno busco fichero2
		//si esta llamo a comparaficheros que recibe fichero1 y fichero2
		//si no esta:
			//si esPrimero:
				//añado objeto resultado(nombre, fichero, FALTA_EN_1)
			//otro
				//añado objeto resultado (nombre, fichero, FALTA_EN_2)
		
		
		
		return comparacion;
	};
	
	public Set<ResultadoComparacion> compara(){
		
		//metodo para quien tiene mas ficheros
		//llamar metodo que es comparaListaFicheros(File[] file1, File[] file2)
		//devuelve set de resultador se añade a con AddAll a la variable resultado
		// llamo a comparaListaFicheros, lo del segundo pero al reves
		
		
		Set<DiffFolder> ficheros = new HashSet<>();
		
		File[] dir1 = directorio1.listFiles();
		File[] dir2 = directorio2.listFiles();
		
		
		
		return null;
	};
	

	private ResultadoComparacion comparaFichero(File file1, File file2) {
		
		//si la fecha de fichero1 es antes que la de fichero2:
			//
		//otro:
			//
		return null;
		
	}
	
	
	}
