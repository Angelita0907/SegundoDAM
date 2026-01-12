package tema1.Boletin2;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class DiffFolder {

	private String ruta = "src\\main\\resources";
	private File directorio = new File(ruta);
	private File carpeta1 = new File(ruta, "carpeta1");
	private File carpeta2 = new File(ruta, "carpeta2");
	private Set<ResultadoComparacion> comparacion;

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public File getDirectorio() {
		return directorio;
	}

	public void setDirectorio(File directorio) {
		this.directorio = directorio;
	}
	
	public void setCarpetas(File carpeta1, File carpeta2) throws GestionFicherosException {
		if(!carpeta1.isDirectory() || !carpeta2.isDirectory()) {
			throw new GestionFicherosException("Los archivos que indican no son directorios");
		}
		this.carpeta1 = carpeta1;
		this.carpeta2= carpeta2;
	}

	public File getCarpeta1() {
		return carpeta1;
	}

	public void setCarpeta1(File carpeta1) {
		this.carpeta1 = carpeta1;
	}

	public File getCarpeta2() {
		return carpeta2;
	}

	public void setCarpeta2(File carpeta2) {
		this.carpeta2 = carpeta2;
	}

	public Set<ResultadoComparacion> getComparacion() {
		return comparacion;
	}

	public void setComparacion(Set<ResultadoComparacion> comparacion) {
		this.comparacion = comparacion;
	}

public Set<ResultadoComparacion> compare() {
		
		Set<ResultadoComparacion> resultado= new HashSet<ResultadoComparacion> ();
		boolean carpeta1mayor=  carpeta1tienemasficheroscarpeta2 ();
		if(carpeta1mayor)
		{
			resultado.addAll(recorreFicheros(carpeta1, carpeta2, carpeta1mayor)) ;
			resultado.addAll(recorreFicheros(carpeta2, carpeta1, carpeta1mayor)) ;
		}
		else
		{
			resultado.addAll(recorreFicheros(carpeta2, carpeta1, carpeta1mayor)) ;
			resultado.addAll(recorreFicheros(carpeta1, carpeta2, carpeta1mayor)) ;
			
		}


		//llama al metodo que es compararlistaficheros y recibe File[1], File2 []
		//Devuelve un set de resultados, se lo añado a variable (AddAll) comparacion
		//llamo a comparaListaFicheros, lo del segundo pero al reves
		//log comparacion

	
		return resultado;

	}
	
	
	
	public Set<ResultadoComparacion> comparame () {
		
		Set<ResultadoComparacion> resultados = new HashSet<ResultadoComparacion> ();
		boolean carpeta1esmayor=  carpeta1tienemasficheroscarpeta2 ();
		
		if(carpeta1esmayor) {
		
			resultados.addAll(recorreFicheros(this.carpeta1,  this.carpeta2, carpeta1esmayor));
			resultados.addAll(recorreFicheros(this.carpeta2,  this.carpeta1, carpeta1esmayor));
		}
		else
		{
			resultados.addAll(recorreFicheros(this.carpeta2,this.carpeta1, carpeta1esmayor));
			resultados.addAll(recorreFicheros(this.carpeta1,  this.carpeta2, carpeta1esmayor));
		}
		
		return resultados;

		}
//primera funcion papu
	private boolean carpeta1tienemasficheroscarpeta2() {
		File [] archivoscarpeta1= carpeta1.listFiles();
		File [] archivoscarpeta2= carpeta2.listFiles();

		return archivoscarpeta1.length>archivoscarpeta2.length;
		
	}
	
	Set<ResultadoComparacion> recorreFicheros(File directorio1, File directorio2, boolean carpeta1esmayor)
	{
		Set<ResultadoComparacion> resultado = new HashSet<ResultadoComparacion> ();
		for(File fichero :  directorio1.listFiles())
		{
			resultado.add(comparFicheroConCarpeta(fichero, directorio2, carpeta1esmayor));
		}
		
		return resultado;
	}
		
	//segunda funcion papu

	
	public ResultadoComparacion comparFicheroConCarpeta(File fichero, File carpeta2, boolean carpeta1esmayor) {
	   
	    boolean encontrado = false;
	    File[] ficherosDirectorio= carpeta2.listFiles() ;
	    int i = 0;
	    ValorComparacion valorcomparacion= null;
	    
	    while (i <ficherosDirectorio.length && !encontrado)
	    {
	    	File archivoiteradocarpeta2 = ficherosDirectorio[i];
	    	
	    	if (fichero.getName().equals(archivoiteradocarpeta2.getName())) 
	    	{
	    		encontrado = true;
	            if (fichero.lastModified() > archivoiteradocarpeta2.lastModified()) {
	                valorcomparacion = ValorComparacion.MENOS_NUEVO_EN_1;
	            } else if (fichero.lastModified() < archivoiteradocarpeta2.lastModified()) {
	            	valorcomparacion = ValorComparacion.MENOS_NUEVO_EN_2;
	            }
	            else if (fichero.lastModified() == archivoiteradocarpeta2.lastModified()) {
	            	valorcomparacion = ValorComparacion.IGUALES;
	            }
	        }
	        else {		    	
	        	i= i+1;
	        }
	    	
	    }
	    //HOLA PAPU, ENTRA CUANDO HA MIRADO TODOS LOS FICHEROS DE LA CARPETA 
	    if(!encontrado)
	    {
	    	if(carpeta1esmayor)
	    	valorcomparacion = ValorComparacion.FALTA_EN_2;
	    	else
	    		valorcomparacion = ValorComparacion.FALTA_EN_1;
	    		
	    }

	    ResultadoComparacion resultado= new ResultadoComparacion(fichero.getName(), valorcomparacion);
	    return resultado;
	}





}
