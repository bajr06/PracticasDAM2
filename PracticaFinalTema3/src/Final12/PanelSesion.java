package Final12;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class PanelSesion extends JPanel {
    private JLabel letreroBienvenida, letreroPeticion, letreroUsuario, letreroContrasenya;
	protected static JTextField peticionUsuario;
	protected static JPasswordField peticionContrasenya;
	protected static JToggleButton verContrasenya;
	protected static JButton cerrarPrograma;
	private JButton verificarCredenciales;

	public PanelSesion() {
		setLayout(null);
		
		letreroBienvenida = new JLabel("Bienvenido al Recopilador de Noticias \"Galio Informativo\"");
		letreroBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 25));
		letreroBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		letreroBienvenida.setBounds(25, 50, 730, 40);
		add(letreroBienvenida);

		letreroPeticion = new JLabel("Por favor, inicio sesion con sus credenciales");
		letreroPeticion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		letreroPeticion.setHorizontalAlignment(SwingConstants.CENTER);
		letreroPeticion.setBounds(225, 120, 350, 14);
		add(letreroPeticion);

		letreroUsuario = new JLabel("Nombre de usuario o correo:");
		letreroUsuario.setBounds(200, 180, 400, 15);
		add(letreroUsuario);

		peticionUsuario = new JTextField();
		peticionUsuario.setBounds(200, 200, 400, 20);
		peticionUsuario.setColumns(10);
		add(peticionUsuario);

		letreroContrasenya = new JLabel("Contraseña:");
		letreroContrasenya.setBounds(200, 250, 400, 14);
		add(letreroContrasenya);

		peticionContrasenya = new JPasswordField();
		peticionContrasenya.setColumns(10);
		peticionContrasenya.setBounds(200, 270, 400, 20);
		add(peticionContrasenya);

		verContrasenya = new JToggleButton("Mostrar");
		verContrasenya.setBounds(610, 270, 80, 20);
		verContrasenya.addActionListener(new Eventos());
		add(verContrasenya);

		cerrarPrograma = new JButton("Cerrar");
		cerrarPrograma.setBounds(350, 400, 100, 20);
		cerrarPrograma.addActionListener(new Eventos());
		add(cerrarPrograma);

		verificarCredenciales = new JButton("Iniciar sesion");
		verificarCredenciales.setBounds(650, 400, 120, 20);
		verificarCredenciales.addActionListener(new Eventos());
		add(verificarCredenciales);
	}
}
