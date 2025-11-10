package Boletin1;

public class HiloServicio extends Thread{
private String nombreHilo;
	
	
	public HiloServicio() {
		super();
		this.nombreHilo = "SERVICIO";
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	@Override
	public void run() {
		
		try {
			while (true) {
				System.out.println(this.nombreHilo                                                                                        );
				sleep(500);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Termina hilo: "+ this.nombreHilo);
	}

}
