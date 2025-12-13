package Final12;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class PanelUsuario extends JPanel {
	private JLabel letreroNoticias;
	protected static JPanel panelNoticias;
	protected static JButton botonGuardar;
	protected static JButton retroceder;
	protected static JButton cerrarPrograma;

	public PanelUsuario() {
		setLayout(new BorderLayout());

		letreroNoticias = new JLabel("Noticias del Día");
		letreroNoticias.setFont(new Font("Tahoma", Font.PLAIN, 25));
		letreroNoticias.setHorizontalAlignment(SwingConstants.CENTER);
		letreroNoticias.setBounds(150, 25, 500, 40);
		add(letreroNoticias,BorderLayout.NORTH);

		panelNoticias = new JPanel();
		panelNoticias.setLayout(new BoxLayout(panelNoticias, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(panelNoticias);
		add(scrollPane, BorderLayout.CENTER);

		botonGuardar = new JButton("Guardar Noticias en Historico");
		botonGuardar.setBounds(300, 400, 150, 20);
		botonGuardar.addActionListener(new Eventos());
		add(botonGuardar, BorderLayout.SOUTH);


		retroceder = new JButton("Atras");
		retroceder.setBounds(150, 450, 100, 20);
		retroceder.addActionListener(new Eventos());
		add(retroceder, BorderLayout.WEST);

		
		cerrarPrograma = new JButton("Cerrar");
		cerrarPrograma.setBounds(350, 450, 100, 20);
		cerrarPrograma.addActionListener(new Eventos());
		add(cerrarPrograma, BorderLayout.EAST);
	}
}
