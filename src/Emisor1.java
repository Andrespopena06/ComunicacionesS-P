public class Emisor1 extends Thread{
	
	String soy = "Emisor 1";
	int puertoAlQueEnvia = 5000;
	int puertoPorElQueRecibe = 6500;
	String mensaje;
	
	
	public Emisor1() {
	}

	@Override
	public void run() {
		EnviaUDP.Envia("Hola desde el emisor1", "localhost", puertoAlQueEnvia);
		System.out.println(RecibeUDP.recibe(puertoPorElQueRecibe));

		EnviaUDP.Envia("2º mensaje desde el emisor1", "localhost", puertoAlQueEnvia);
		System.out.println(RecibeUDP.recibe(puertoPorElQueRecibe));
		super.run();
	}
}
