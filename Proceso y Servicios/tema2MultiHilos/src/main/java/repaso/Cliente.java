package repaso;

import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {

	private String cliente;

	// recurso compartido
	private Semaphore plato;

	public Cliente(Semaphore plato) {
		super();
		this.plato = plato;
	}

	public Semaphore getPlato() {
		return plato;
	}

	public void setPlato(Semaphore plato) {
		this.plato = plato;
	}

	@Override
	public void run() {

		/*
		 * los clientes llegan por orden y los que quepan cogen el turno que hay una vez
		 * el cocinero avisa de que hay plato suelta la comida y cliente suelta el
		 * testigo para el siguiente y pueda empezar a comer
		 * 
		 */

		try {
			plato.acquire();
			System.out.println("empieza a comer");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

}
