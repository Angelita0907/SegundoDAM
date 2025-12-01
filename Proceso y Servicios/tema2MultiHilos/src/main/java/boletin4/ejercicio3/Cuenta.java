package boletin4.ejercicio3;

public class Cuenta {

	private int saldo;

	public Cuenta(int saldo) {
		super();
		this.saldo = saldo;
	}

	public synchronized int getSaldo() {
		return saldo;
	}

	public synchronized void ingresa(int ingreso) {
		System.out.println("Ingresando: " + ingreso + " El saldo ahora es: " + this.saldo);
		this.saldo = this.saldo + ingreso;

		System.out.println("Se ha ingresado: " + this.saldo + " Ingresando:" + ingreso);

	}

	public synchronized void retirar(int retirar) throws CuentaException {

		if (this.saldo == 0) {
			throw new CuentaException("No tienes dinero, pobre");
		} else {
			System.out.println("Retirando: " + retirar + " El saldo ahora es: " + this.saldo);
			this.saldo = this.saldo - retirar;

			System.out.println("Se ha retirado: " + this.saldo + " Retirando:" + retirar);

		}

		System.out.println("retirado");
	}

}
