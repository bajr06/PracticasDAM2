package Final12;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	// Tenemos estos métodos dentro del constructor porue heredamos las clases del padre, si quisieramos sobreescribir algún método, tendremos que usar el @Override.
	public Ventana() {
		setTitle("Traductor Inglés - Español"); 
		setSize(800, 600); // El tamaño a dar.
		setResizable(false); // Impide modificar el tamaño de la ventana.
		setLocationRelativeTo(null); // Te lo localiza en el punto medio de tu pantalla.
		
		Panel miPanel = new Panel();
		add(miPanel);
	}
}
