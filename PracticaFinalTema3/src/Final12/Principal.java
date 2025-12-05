package Final12;

import java.awt.EventQueue;

public class Principal {
	protected static Ventana v;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v = new Ventana();
					v.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
