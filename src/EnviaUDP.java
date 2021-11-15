import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EnviaUDP {
    static void Envia(String texto, String hostdestino, int puerto) {
        DatagramSocket socket;
        DatagramPacket paquete;
        byte paraEnviar[];
        try {
            paraEnviar = texto.getBytes();
            paquete =
                  new DatagramPacket(paraEnviar, paraEnviar.length,InetAddress.getByName(hostdestino), puerto);
            
            socket = new DatagramSocket();
            socket.send(paquete);

            socket.close();
        } catch (SocketException ex) {
            System.out.println("Error al asignar el socket");
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            System.out.println("Error al crear el paquete");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error en el envío del paquete");
            ex.printStackTrace();
        }
    }
}

