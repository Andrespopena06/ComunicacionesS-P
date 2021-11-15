
public class Principal {
	public static void main(String[] args) {
		HiloVentana pant1 = new HiloVentana("Emisor 1");
		HiloVentana pant2 = new HiloVentana("Emisor 2");
		
		pant1.start();
		pant2.start();
	}
}
