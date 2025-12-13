package Final12;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelAdministrador extends JPanel{
	private JLabel bienvenidaAdministrador, explicacion;
	protected static JButton crearUsuario, borrarUsuario, testeoNoticias;
	protected static JButton cerrarPrograma;
	protected static JButton retroceder;

	public PanelAdministrador() {
		setLayout(null);
		setVisible(true);

		bienvenidaAdministrador = new JLabel("Bienvenido al Menu de Administrador");
		bienvenidaAdministrador.setBounds(125, 50, 550, 30);
		bienvenidaAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bienvenidaAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		add(bienvenidaAdministrador);

		explicacion = new JLabel("Seleccione la opcion a realizar:");
		explicacion.setBounds(125, 125, 550, 20);
		explicacion.setHorizontalAlignment(SwingConstants.CENTER);
		add(explicacion);

		crearUsuario = new JButton("Crear Usuario");
		crearUsuario.setBounds(125, 200, 140, 20);
		crearUsuario.addActionListener(new Eventos());
		add(crearUsuario);

		borrarUsuario = new JButton("Borrar Usuario");
		borrarUsuario.setBounds(325, 200, 140, 20);
		borrarUsuario.addActionListener(new Eventos());
		add(borrarUsuario);

		testeoNoticias = new JButton("Testear Noticias");
		testeoNoticias.setBounds(525, 200, 140, 20);
		testeoNoticias.addActionListener(new Eventos());
		add(testeoNoticias);

		cerrarPrograma = new JButton("Cerrar");
		cerrarPrograma.setBounds(350, 400, 100, 20);
		cerrarPrograma.addActionListener(new Eventos());
		add(cerrarPrograma);

		retroceder = new JButton("Atras");
		retroceder.setBounds(150, 400, 100, 20);
		retroceder.addActionListener(new Eventos());
		add(retroceder);
	}
}
