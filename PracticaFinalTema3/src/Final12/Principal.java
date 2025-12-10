package Final12;

import java.awt.EventQueue;

public class Principal {
	protected static Ventana v1;
	protected static Ventana v2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v1 = new Ventana(1);
					v1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }

	public static void reiniciarVentana() {
		v1.dispose();

		v2 = new Ventana(2);
		v2.setVisible(true);
	}
}
