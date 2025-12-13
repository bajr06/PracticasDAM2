package Final12;

import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame {
	protected static PanelCarga pc;
	protected static PanelSesion ps;
	protected static PanelUsuario pu;
	protected static PanelPrimezaVez ppv;
	protected static PanelAdministrador pa;
	
	protected static JMenuBar barraMenu;
	private JMenu menu;
	protected JMenuItem datosAplicacion;

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
			barraMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			setJMenuBar(barraMenu);

			menu = new JMenu("Ayuda");
			barraMenu.add(menu);

			datosAplicacion = new JMenuItem("Acerca de");
			datosAplicacion.addActionListener(new Eventos());
			menu.add(datosAplicacion);

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
