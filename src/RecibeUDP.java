import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class RecibeUDP extends Thread implements Runnable {
	
	private int puerto;
	private String recepcion;
	
	public RecibeUDP(int puerto) {
		this.puerto = puerto;
	}
	
	public String recibe() {
        DatagramSocket socket;
        DatagramPacket paquete = null;
        byte paraRecibir[] = new byte[1024];
        String IPRemota = "";
        int puertoRemoto;
        try {
            paquete = new DatagramPacket(paraRecibir, paraRecibir.length);
            socket = new DatagramSocket(puerto);
            socket.receive(paquete);

            IPRemota = paquete.getAddress().getHostName();
            puertoRemoto = paquete.getPort();
            System.out.println("El paquete llega de la IP " + paquete.getSocketAddress().toString());
            System.out.println("El paquete llega de " + IPRemota + "por el puerto " + puertoRemoto);
            socket.close();
        } catch (SocketException ex) {
            System.out.println("Error al asignar el socket");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error en la recepción del paquete");
            ex.printStackTrace();
        }
        return new String(paquete.getData()).trim();
    }
	
	public String getMensaje() {
		return recepcion;
	}
	
	@Override
	public void run() {
			recepcion = recibe();
	}
}

