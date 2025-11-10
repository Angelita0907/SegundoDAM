package Boletin1;

public class HiloProceso extends Thread{
	
	private String nombreHilo ;

	
	public HiloProceso() {
		super();
		this.nombreHilo = "PROCESO";
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	@Override
	public void run() {
		
		System.out.println(this.nombreHilo);
		try {
			
			while (true) {
				System.out.println(this.nombreHilo);
				sleep(500);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Termina hilo: "+ this.nombreHilo);
	}

}
