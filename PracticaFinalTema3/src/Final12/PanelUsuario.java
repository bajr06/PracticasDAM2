package Final12;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelUsuario extends JPanel {
	private JLabel letreroNoticias;

	public PanelUsuario() {
		setLayout(null);

		letreroNoticias = new JLabel("Noticias del Día");
		letreroNoticias.setFont(new Font("Tahoma", Font.PLAIN, 25));
		letreroNoticias.setHorizontalAlignment(SwingConstants.CENTER);
		letreroNoticias.setBounds(25, 25, 730, 40);
		add(letreroNoticias);
	}
}
