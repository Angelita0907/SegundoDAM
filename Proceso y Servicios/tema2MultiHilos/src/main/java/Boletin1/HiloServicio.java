package Boletin1;

public class HiloServicio extends Thread {
    private String nombreHilo;

    public HiloServicio() {
        super();
        this.nombreHilo = "SERVICIO";
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(this.nombreHilo + " ejecutándose (" + i + ")");
                sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Termina hilo: " + this.nombreHilo);
    }
}
