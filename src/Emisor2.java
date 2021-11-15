public class Emisor2 extends Thread{
	
	String soy = "Emisor 2";
	int puertoAlQueEnvia = 6500;
	int puertoPorElQueRecibe = 5000;
	String mensaje;
	
	public Emisor2() {
	}

	@Override
	public void run() {
		System.out.println(RecibeUDP.recibe(puertoPorElQueRecibe));
		EnviaUDP.Envia("Mensaje desde el emisor2", "localhost", puertoAlQueEnvia);

		System.out.println(RecibeUDP.recibe(puertoPorElQueRecibe));
		EnviaUDP.Envia("Otro mensaje desde el emisor2", "localhost", puertoAlQueEnvia);
		super.run();
	}
}
