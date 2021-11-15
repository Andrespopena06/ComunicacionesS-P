
public class Principal {
	public static void main(String[] args) {
		Emisor1 emisor1 = new Emisor1();
		Emisor2 emisor2 = new Emisor2();
		HiloVentana pant1 = new HiloVentana(emisor2);
		HiloVentana pant2 = new HiloVentana(emisor1);
		
		pant1.run();
		pant2.run();
	}
}
