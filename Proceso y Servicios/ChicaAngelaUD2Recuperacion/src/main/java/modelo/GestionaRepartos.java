package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaRepartos {

	public static void main(String[] args) {

		List<Thread> hilos = new ArrayList<>();

		Semaphore pedidos = new Semaphore(30);
		Semaphore repartidor = new Semaphore(1);

		/*
		 * int pedidoZona1 = 20; 
		 * int pedidoZona2 = 10;
		 */
		
		long t_comienzo = System.currentTimeMillis();

		Repartidor repartidorBici = new Repartidor("RepartidorBici", medio.BICI, 2, pedidos);
		Repartidor repartidorMoto = new Repartidor("RepartidorMoto", medio.MOTO, 4, pedidos);

		Thread hiloRepartidor1 = new Thread(repartidorBici);
		Thread hiloRepartidor2 = new Thread(repartidorMoto);

		for (int i = 0; i < 20; i++) {

			Pedido pedido = new Pedido("Pedido " + i, Zona.ZONA1, repartidor);
			Thread hiloZona1 = new Thread(pedido);
			hilos.add(hiloZona1);

		}

		for (int i = 0; i < 10; i++) {

			Pedido pedido = new Pedido("Pedido " + i, Zona.ZONA2, repartidor);
			Thread hiloZona2 = new Thread(pedido);
			hilos.add(hiloZona2);

		}

		hiloRepartidor1.start();
		hiloRepartidor2.start();
		
		for (Thread h : hilos) {
			h.start();
		}

		for (Thread thread : hilos) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		long t_final = System.currentTimeMillis();

		long t_total = t_final - t_comienzo;
		System.out.println("El tiempo de reparto ha sido de = " + t_total + "mseg");

	}

}
