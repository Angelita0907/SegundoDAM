package servicio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.CentroLogistico;
import modelo.Trabajador;
import repositorio.RepositorioBancoAlimentos;

public class ServicioBanco {

	
	RepositorioBancoAlimentos repo;
	private static final Logger logger = LogManager.getLogger(RepositorioBancoAlimentos.class);

	public ServicioBanco(List <CentroLogistico> centrologisticos) {
		super();
		repo= new RepositorioBancoAlimentos(centrologisticos);
	}
	
	public List<Trabajador> getcolaboradoresportipo (String tipo){
		List<Trabajador> trabajadoresportipo= new ArrayList <>();
		
		if(tipo.equalsIgnoreCase("Asalariado")) {
			trabajadoresportipo= getcolaboradoresportipoasalariado();
		}
		else if(tipo.equalsIgnoreCase("Voluntario")) {
			trabajadoresportipo= getcolaboradosportipovoluntario();

		}
		
		
		
		
		return trabajadoresportipo;
		
	}
	public List<Trabajador> getcolaboradoresportipoasalariado() {
	    List<Trabajador> trabajadoresAsalariados = new ArrayList<>();

	    for (CentroLogistico centro : repo.getCentroslogisticos()) {
	        for (Trabajador trabajador : centro.getPersonal()) {
	            if (trabajador.isEsAsalariado()) {
	                trabajadoresAsalariados.add(trabajador);
	            }
	        }
	    }

	    return trabajadoresAsalariados;
	}

	public List<Trabajador> getcolaboradosportipovoluntario(){
		 List<Trabajador> trabajadoresvoluntarios= new ArrayList<>();

		    for (CentroLogistico centro : repo.getCentroslogisticos()) {
		        for (Trabajador trabajador : centro.getPersonal()) {
		            if (!trabajador.isEsAsalariado()) {
		            	trabajadoresvoluntarios.add(trabajador);
		            }
		        }
		    }

		    return trabajadoresvoluntarios;
	}
	
}
