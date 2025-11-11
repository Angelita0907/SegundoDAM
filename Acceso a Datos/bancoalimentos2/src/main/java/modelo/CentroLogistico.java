package modelo;

import java.util.ArrayList;
import java.util.List;

public class CentroLogistico {
	  private String id; 
	    private String nombre;
	    private String ciudad;
	    private int numeroComedores; 
	    private List<Trabajador> personal; 
		public CentroLogistico(String id, String nombre, String ciudad, int numeroComedores,
				List<Trabajador> personal) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.ciudad = ciudad;
			this.numeroComedores = numeroComedores;
			this.personal = new ArrayList<>();
		}
		
		
		public CentroLogistico() {
			super();
			this.personal = new ArrayList<>();
		}


		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCiudad() {
			return ciudad;
		}
		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}
		public int getNumeroComedores() {
			return numeroComedores;
		}
		public void setNumeroComedores(int numeroComedores) {
			this.numeroComedores = numeroComedores;
		}
		public List<Trabajador> getPersonal() {
			return personal;
		}
		public void setPersonal(List<Trabajador> personal) {
			this.personal = personal;
		}


		@Override
		public String toString() {
			return "CentroLogistico [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", numeroComedores="
					+ numeroComedores + ", personal=" + personal + "]";
		}
	    
	    
	    
	    
}




