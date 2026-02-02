package modelo;

public class LanzadorClientes {

	public static void main(String[] args) {
		ClienteHilo cliente = new ClienteHilo();

		for (int i = 0; i < 9; i++) {
			Thread hiloCliente = new Thread(cliente);
			hiloCliente.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
