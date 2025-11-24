package boletin3.ejercicio3;

public class MultiplosCooperativos2 extends Thread{

	private MultiplosCooperativos multiplo;

	// creamos los hilos desde aquí
	@Override
	public void run() {
		// TODO Auto-generated method stub
		multiplo.multiplicar(2);
		multiplo.multiplicar(3);
		multiplo.multiplicar(7);
	}
	
	

}
