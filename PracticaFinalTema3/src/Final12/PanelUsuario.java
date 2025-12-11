package Final12;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class PanelUsuario extends JPanel {
	private JLabel letreroNoticias;

	protected JPanel panelNoticias;

	public PanelUsuario() {
		setLayout(null);

		letreroNoticias = new JLabel("Noticias del Día");
		letreroNoticias.setFont(new Font("Tahoma", Font.PLAIN, 25));
		letreroNoticias.setHorizontalAlignment(SwingConstants.CENTER);
		letreroNoticias.setBounds(150, 25, 500, 40);
		add(letreroNoticias);

		panelNoticias = new JPanel();
		panelNoticias.setLayout(new BoxLayout(panelNoticias, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(panelNoticias);
		add(scrollPane, BorderLayout.CENTER);
	}
}
