
public class HiloVentana extends Thread implements Runnable {

	String nombre;
	public HiloVentana(String string) {
		nombre = string;
	}

	@Override
	public void run() {
		@SuppressWarnings("unused")
		Pantalla pant2 = new Pantalla(nombre);
		super.run();
	}

}
