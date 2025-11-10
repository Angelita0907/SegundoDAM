package Boletin1;

public class GestionaHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloServicio hilo1 = new HiloServicio();
		//System.out.println(hilo1.getState());
		hilo1.start();
		
		HiloProceso hilo2 = new HiloProceso();
		//System.out.println(hilo2.getState());
		hilo2.start();
	}

}
