import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Pantalla extends JFrame {
	/**
	 * @author Andres Pena
	 */
	private static final long serialVersionUID = 1L;
	private String nombre = "";
	private EnviaUDP enviar;
	private RecibeUDP recibir;
	JButton btnEnviar;
	JTextField escritura;
	JTextArea texto;
	
	public Pantalla(String nombre) {
		this.nombre = nombre;
		initPartes();
		initAcciones();
		initPantalla(nombre);
		if (nombre.equals("Emisor 1")) {
			escuchadorMensajes(nombre, 6500);
		} else if (nombre.equals("Emisor 2")) {
			escuchadorMensajes(nombre, 5000);
		}
		
	}

	private void initPantalla(String nombre) {
		setTitle(nombre); // Título del JFrame
		setSize(240, 440); // Dimensiones del JFrame
		setResizable(false);// No se puede redimensionar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar proceso al cerrar ventana
		setVisible(true); // Mostrar JFrame
	}

	private void initPartes() {
		Color miColor = new Color(167, 210, 200);
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBackground(miColor);

		texto = new JTextArea();
		Border compound = new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(5, 10, 5, 10));
		texto.setEditable(false);
		texto.setBounds(10, 10, 200, 288);
		texto.setLayout(null);

		escritura = new JTextField();
		escritura.setBorder(compound);
		escritura.setBounds(10, 309, 200, 40);
		getContentPane().add(panel);

		panel.add(escritura);
		panel.add(texto);

		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(10, 360, 200, 30);
		panel.add(btnEnviar);

	}

	private void initAcciones() {
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!escritura.getText().equals("")) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
					String nuevaLinea = dtf.format(LocalDateTime.now()) + ": " + escritura.getText();
					escritura.setText("");
					texto.setText(texto.getText() + "\n" + nuevaLinea);

					if (nombre.equals("Emisor 1")) {
						enviar = new EnviaUDP(nuevaLinea, "localhost", 5000);
						enviar.start();
					} else if (nombre.equals("Emisor 2")) {
						enviar = new EnviaUDP(nuevaLinea, "localhost", 6500);
						enviar.start();
					}
				}
			}
		});
	}

	private synchronized void escuchadorMensajes(String emisor, int puerto) {
		while (true) {
			try {
				recibir = new RecibeUDP(puerto);
				recibir.start();
				recibir.join();
				texto.setText(texto.getText() + "\n" + emisor + " " + recibir.getMensaje());
			} catch (Exception e) {
			}
		}
	}
}
