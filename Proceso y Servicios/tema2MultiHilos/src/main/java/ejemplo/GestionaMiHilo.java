package ejemplo;

import Boletin1.HiloProceso;
import Boletin1.HiloServicio;

public class GestionaMiHilo {

    public static void main(String[] args) {

        // Tiempo de inicio del hilo padre
        long inicio = System.currentTimeMillis();

        // Crear hilos hijos
        HiloProceso hilo1 = new HiloProceso();
        HiloServicio hilo2 = new HiloServicio();

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();

        System.out.println("Hilo padre esperando a que terminen los hijos...");

        try {
            // Esperar a que los hijos terminen
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tiempo final
        long fin = System.currentTimeMillis();

        System.out.println("Todos los hilos hijos han terminado.");
        System.out.println("Tiempo total de ejecución del hilo padre: " + (fin - inicio) + " ms");
    }
}
