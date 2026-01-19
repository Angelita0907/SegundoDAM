package modelo;

import java.util.concurrent.Semaphore;

public class Repartidor implements Runnable {

	private String id_repartidor;
	private medio medio;
	//pedidos que realiza cada repartidor
	private int numPedidos;
	private Semaphore repartir;

	public Repartidor(String id_repartidor, medio medio, int numPedidos, Semaphore repartir) {
		super();
		this.id_repartidor = id_repartidor;
		this.medio = medio;
		this.numPedidos = numPedidos;
		this.repartir = new Semaphore(numPedidos);
	}

	public String getId_repartidor() {
		return id_repartidor;
	}

	public void setId_repartidor(String id_repartidor) {
		this.id_repartidor = id_repartidor;
	}

	public medio getMedio() {
		return medio;
	}

	public void setMedio(medio medio) {
		this.medio = medio;
	}

	public int getNumPedidos() {
		return numPedidos;
	}

	public void setNumPedidos(int numPedidos) {
		this.numPedidos = numPedidos;
	}

	public Semaphore getRepartir() {
		return repartir;
	}

	public void setRepartir(Semaphore repartir) {
		this.repartir = repartir;
	}

	@Override
	public void run() {
		
		// aunque está puesto 5 segundos lo hice por comprobar funcionamiento 
		// pero se debe poner 15 como en el ejercicio

		while (true) {

			try {
				if (medio.equals(medio.BICI)) {
					repartir.acquire();
					Thread.sleep(5000);
					System.out.println("Repartidor: " + id_repartidor + " asignando pedido ");
				} else if (medio.equals(medio.MOTO)) {
					repartir.acquire();
					Thread.sleep(5000);
					System.out.println("Repartidor: " + id_repartidor + " asignando pedido");
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
