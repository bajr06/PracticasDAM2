package Final12;

import java.awt.EventQueue;

public class Principal {
	protected static Ventana v;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v = new Ventana(1);
					v.setVisible(true);

					Operaciones.prueba();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }

	public static void reiniciarVentana() {
		v.dispose();

		v = new Ventana(2);
		v.setVisible(true);
	}
}
