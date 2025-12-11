package Final12;

import java.awt.CardLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Ventana extends JFrame {
	protected static PanelCarga pc;
	protected static PanelSesion ps;
	protected static PanelUsuario pu;
	protected static PanelPrimezaVez ppv;
	protected static PanelAdministrador pa;
	
	protected static JMenuBar barraMenu;
	protected static JButton datosAplicacion;

	public Ventana(int llamada) {
		setTitle("Noticias \"Galio Informativo\""); 
		setSize(800, 500);
		getContentPane().setLayout(new CardLayout(0, 0));
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Pantheon_Perfil.jpg")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		if(llamada == 1) {
			setUndecorated(true);
			pc = new PanelCarga();
			getContentPane().add(pc);
		} else if(llamada == 2) {
			barraMenu = new JMenuBar();
			setJMenuBar(barraMenu);

			datosAplicacion = new JButton("Acerca de");
			datosAplicacion.addActionListener(new Eventos());
			barraMenu.add(datosAplicacion);

			ps = new PanelSesion();
			add(ps);
			
			ppv = new PanelPrimezaVez();
			add(ppv);

			pa = new PanelAdministrador();
			add(pa);

			pu = new PanelUsuario();
			add(pu);
		}
	}
}
