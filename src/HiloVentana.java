
public class HiloVentana extends Thread{
	Emisor1 emisor1 = null;
	Emisor2 emisor2 = null;
	
	public HiloVentana(Emisor1 emisor) {
		emisor1 = emisor;
	}
	
	public HiloVentana(Emisor2 emisor) {
		emisor2 = emisor;
	}

	@Override
	public void run() {
		if(emisor1 != null) {
			Pantalla pant = new Pantalla(emisor1);
		} else if (emisor2 != null) {
			Pantalla pant = new Pantalla(emisor2);
		}
		super.run();
	}
	
	
}
