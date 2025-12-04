package Final12;

import java.awt.CardLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

import tema12.Ventana12;

public class Ventana extends JFrame {
	protected static PanelCarga pc;
	protected static PanelSesion ps;
	protected static PanelUsuario pu;

	// Tenemos estos métodos dentro del constructor porue heredamos las clases del padre, si quisieramos sobreescribir algún método, tendremos que usar el @Override.
	public Ventana() {
		setTitle("Noticias \"Galio Informativo\""); 
		setSize(800, 500); // El tamaño a dar.
		getContentPane().setLayout(new CardLayout(0, 0));
		setLocationRelativeTo(null); // Te lo localiza en el punto medio de tu pantalla.
		setResizable(false); // Impide modificar el tamaño de la ventana.
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana12.class.getResource("/Pantheon_Perfil.jpg")));

		pc = new PanelCarga();
		getContentPane().add(pc);

		ps = new PanelSesion();
		add(ps);

		pu = new PanelUsuario();
		add(pu);
	}
}
