package boletin4.ejercicio1;

public class GestionaVocales {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String texto = "";
		
		CuentaVocales cuenta = new CuentaVocales(null, 0);
		
		HiloVocales a = new HiloVocales((char) 'a', cuenta, texto);
		HiloVocales e = new HiloVocales((char) 'e', cuenta, texto);
		HiloVocales i = new HiloVocales((char) 'i', cuenta, texto);
		HiloVocales o = new HiloVocales((char) 'o', cuenta, texto);
		HiloVocales u = new HiloVocales((char) 'u', cuenta, texto);
		
		a.start();
		e.start();
		i.start();
		o.start();
		u.start();
		
		a.join();
		e.join();
		i.join();
		o.join();
		u.join();
		

	}

}
