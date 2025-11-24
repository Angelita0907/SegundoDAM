package ejemplo;

class Contador {
	private int valor = 0;

	// asi solo uno va a estar llamando al metodo por obejto que lo vaya a usar
	public synchronized void incrementar() {
		valor++;
	}

	public int getValor() {
		return valor;
	}
}

class TareaIncremento implements Runnable {

	private Contador contador;

	public TareaIncremento(Contador contador) {
		this.contador = contador;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			contador.incrementar();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
