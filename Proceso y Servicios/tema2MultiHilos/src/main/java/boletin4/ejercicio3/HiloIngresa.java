package boletin4.ejercicio3;

public class HiloIngresa extends Thread{
	
	private int ingreso;
	
	private Cuenta saldo;

	public HiloIngresa( Cuenta saldo) {
		super();
		this.ingreso = ((int)(Math.random()*500+1));
		this.saldo = saldo;
	}

	public int getIngreso() {
		return ingreso;
	}

	public void setIngreso(int ingreso) {
		this.ingreso = ingreso;
	}

	public Cuenta getSaldo() {
		return saldo;
	}

	public void setSaldo(Cuenta saldo) {
		this.saldo = saldo;
	}

	@Override
	public void run() {
		saldo.ingresa(ingreso);
		
		
		super.run();
	}
	
	

}
