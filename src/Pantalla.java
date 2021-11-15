import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Pantalla extends JFrame{
	/**
	 * @author Andres Pena
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * @wbp.parser.constructor
	 */
	public Pantalla(Emisor1 emisor) {
		initPartes();
		initPantalla();
//		emisor.run();
	}
	
	public Pantalla(Emisor2 emisor) {
		initPartes();
		initPantalla();
//		emisor.run();
	}
	
	private void initPantalla() {
		setTitle("Emisor/Receptor"); // Título del JFrame
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
		
		JTextArea texto = new JTextArea();
		Border compound = new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(5, 10, 5, 10));
		texto.setBorder(compound);
		texto.setBounds(10,10,200, 200);
		
		JTextField escritura = new JTextField();
		escritura.setBounds(10,220,200, 50);
		
		JButton botonConectar = new JButton("Conectar");
		botonConectar.setBounds(10,260, 90, 30);
		add(panel);
		panel.add(texto);
		panel.add(texto);
		panel.add(botonConectar);
	}
}
