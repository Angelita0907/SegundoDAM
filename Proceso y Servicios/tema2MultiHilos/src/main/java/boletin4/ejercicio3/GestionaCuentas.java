package boletin4.ejercicio3;

public class GestionaCuentas {
	

	public static void main(String[] args) {
		
		Cuenta cuenta = new Cuenta(5200);
		
		HiloIngresa i1 = new HiloIngresa(cuenta);
		HiloIngresa i2 = new HiloIngresa(cuenta);
		
		HiloRetira r1 = new HiloRetira(cuenta);
		HiloRetira r2 = new HiloRetira(cuenta);
		
		System.out.println("Saldo inicial: "+cuenta.getSaldo());
		
		i1.start();
		i2.start();
		
		r1.start();
		r2.start();
		
		try {
			i1.join();
			i2.join();
			
			r1.join();
			r2.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Saldo final: "+cuenta.getSaldo());
		
	}

}
