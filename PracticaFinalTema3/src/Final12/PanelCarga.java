package Final12;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class PanelCarga extends JPanel {
    protected static JProgressBar barraCarga;
	protected static Timer tiempo;
	private static final long serialVersionUID = 1L;
	private BufferedImage fondo = null;
	private Image foto = fondo;

	private void buscarImagen() {
		try {
			fondo = ImageIO.read(new File("PracticaFinalTema3/src/Galio.jpg"));
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		foto = fondo;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(foto, 0, 0, 800, 500, null);
	}

	

	public PanelCarga() {
		setLayout(null);
		buscarImagen();

		barraCarga = new JProgressBar();
		barraCarga.setBounds(150, 400, 500, 30);
		add(barraCarga);

		tiempo = new Timer(1000, new Eventos());
		tiempo.start();
	}
}

