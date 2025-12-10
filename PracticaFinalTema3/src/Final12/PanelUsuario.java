package Final12;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelUsuario extends JPanel {
	private JLabel letreroNoticias;
	private JLabel letreroVida;

	public PanelUsuario() {
		setLayout(null);

		letreroNoticias = new JLabel("Noticias del Día");
		letreroNoticias.setFont(new Font("Tahoma", Font.PLAIN, 25));
		letreroNoticias.setHorizontalAlignment(SwingConstants.CENTER);
		letreroNoticias.setBounds(25, 50, 730, 40);
		add(letreroNoticias);

		letreroVida = new JLabel("Por favor, inicio sesion con sus credenciales");
		letreroVida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		letreroVida.setHorizontalAlignment(SwingConstants.CENTER);
		letreroVida.setBounds(225, 120, 350, 14);
		add(letreroVida);
	}
}
