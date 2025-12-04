package tema12;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ventana12 {

	private JFrame ventana;
	
	private JPanel carga;
	private JProgressBar barraCarga;
	private Timer tiempo;
	private int i = 0;
	
	private JPanel inicioSesion;
	private JLabel letreroBienvenida;
	private JLabel letreroPeticion;
	private JLabel letreroUsuario;
	private JTextField peticionUsuario;
	private JLabel letreroContrasenya;
	private JTextField peticionContrasenya;
	private JButton verificarCredenciales;
	
	private JPanel usuario;
	private JPanel administrador;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana12 window = new Ventana12();
					window.ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ventana12() {
		initialize();
	}
	
	private Component buscarImagen() {
		BufferedImage fondo = null;
		
		try {
			fondo = ImageIO.read(new File("PracticaFinalTema3/src/Galio.jpg"));
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		final Image foto = fondo;
		carga = new JPanel() {
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(foto, 0, 0, 800, 500, null);
			}
		};
		
		return carga;
	}
	
	private void initialize() {
		ventana = new JFrame();
		ventana.setSize(800, 500);
		ventana.getContentPane().setLayout(new CardLayout(0, 0));
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana12.class.getResource("/Pantheon_Perfil.jpg")));
		
		barraCarga = new JProgressBar();
		barraCarga.setBounds(150, 400, 500, 30);
		ventana.getContentPane().add(buscarImagen());
		
		carga.setLayout(null);
		carga.add(barraCarga);
		
		inicioSesion = new JPanel();
		ventana.getContentPane().add(inicioSesion, "name_548010225700");
		inicioSesion.setLayout(null);
		
		letreroBienvenida = new JLabel("Bienvenido al Recopilador de Noticias \"Galio informativo\"");
		letreroBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 25));
		letreroBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		letreroBienvenida.setBounds(25, 50, 730, 40);
		inicioSesion.add(letreroBienvenida);
		
		letreroPeticion = new JLabel("Por favor, inicio sesion con sus credenciales");
		letreroPeticion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		letreroPeticion.setHorizontalAlignment(SwingConstants.CENTER);
		letreroPeticion.setBounds(225, 120, 350, 14);
		inicioSesion.add(letreroPeticion);
		
		letreroUsuario = new JLabel("Nombre de usuario o correo:");
		letreroUsuario.setBounds(200, 180, 400, 15);
		inicioSesion.add(letreroUsuario);
		
		letreroContrasenya = new JLabel("Nombre de usuario o correo:");
		letreroContrasenya.setBounds(200, 250, 400, 14);
		inicioSesion.add(letreroContrasenya);
		
		peticionUsuario = new JTextField();
		peticionUsuario.setBounds(200, 200, 400, 20);
		inicioSesion.add(peticionUsuario);
		peticionUsuario.setColumns(10);
		
		peticionContrasenya = new JTextField();
		peticionContrasenya.setColumns(10);
		peticionContrasenya.setBounds(200, 270, 400, 20);
		inicioSesion.add(peticionContrasenya);
		
		verificarCredenciales = new JButton("Iniciar sesion");
		verificarCredenciales.setBounds(633, 427, 122, 23);
		inicioSesion.add(verificarCredenciales);
		
		usuario = new JPanel();
		ventana.getContentPane().add(usuario, "name_566054957900");
		usuario.setLayout(null);
		
		administrador = new JPanel();
		ventana.getContentPane().add(administrador, "name_753379944100");
		administrador.setLayout(null);
		
		tiempo = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				barraCarga.setValue(i += 20);
				
				if(i > 100) {
					carga.setVisible(false);
					inicioSesion.setVisible(true);
					tiempo.stop();
				}
			}
		});
		tiempo.start();
		
		verificarCredenciales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicioSesion.setVisible(false);
				usuario.setVisible(true);
			}
		});
	}
}

