package modelo;

import java.time.LocalTime;
import java.util.concurrent.Semaphore;

public class Pedido implements Runnable {

	private String id_cliente;
	private Zona zona;
	private LocalTime fecha_reparto;
	private Semaphore hayRepartidor;

	public Pedido(String id_cliente, Zona zona, Semaphore hayRepartidor) {
		super();
		this.id_cliente = id_cliente;
		this.zona = zona;
		this.hayRepartidor = hayRepartidor;
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public LocalTime getFecha_reparto() {
		return fecha_reparto;
	}

	public void setFecha_reparto(LocalTime localTime) {
		this.fecha_reparto = localTime;
	}

	public Semaphore getHayRepartidor() {
		return hayRepartidor;
	}

	public void setHayRepartidor(Semaphore hayRepartidor) {
		this.hayRepartidor = hayRepartidor;
	}

	@Override
	public void run() {
		try {
		if(this.zona.equals(zona.ZONA1)) {
	
				System.out.println(id_cliente + " esperando entrega de pedido");
				hayRepartidor.release();
				System.out.println("Realizando entrega de pedido");
				// cuando tienen repartidor se le asigna la hora
				setFecha_reparto(LocalTime.now());
				Thread.sleep(5000);
			
		}
		else if (this.zona.equals(zona.ZONA2)) {

				System.out.println(id_cliente + " esperando entrega de pedido");
				hayRepartidor.release();
				System.out.println("Realizando entrega de pedido");
				setFecha_reparto(LocalTime.now());
				Thread.sleep(5000);
		
		}
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}

	


