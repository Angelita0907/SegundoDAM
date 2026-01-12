package boletin4.ejercicio3;

public class HiloRetira extends Thread{

	private int retirar;
	private Cuenta saldo;

	public HiloRetira(Cuenta saldo) {
		super();
		this.saldo = saldo;
		this.retirar = ((int)(Math.random()*500+1));
	}

	public Cuenta getSaldo() {
		return saldo;
	}

	public void setSaldo(Cuenta saldo) {
		this.saldo = saldo;
	}
	
	public int getRetirar() {
		return retirar;
	}

	public void setRetirar(int retirar) {
		this.retirar = retirar;
	}

	@Override
	public void run() {

		try {
			saldo.retirar(retirar);
		} catch (CuentaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.run();
	}

	
}
