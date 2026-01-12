package boletin2;

public class Mascota implements Runnable {

	private String nombre;
	private int vecesCome;

	public Mascota() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mascota(String nombre, int vecesCome) {
		super();
		this.nombre = nombre;
		this.vecesCome = vecesCome;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVecesCome() {
		return vecesCome;
	}

	public void setVecesCome(int vecesCome) {
		this.vecesCome = vecesCome;
	}
	
	public void comer() throws InterruptedException {
		//System.out.println(Thread.currentThread().getName());
		System.out.println("La mascota con nombre "+nombre +" ha empezado de comer: "+Thread.currentThread().getName());	
		vecesCome = vecesCome + 1;
		Thread.sleep(1*vecesCome);
			

	}

	@Override
	public void run() {
		try {
			comer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("La mascota con nombre "+nombre +" ha termiando de comer: "+Thread.currentThread().getName());

	}

}
