package Final12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventoTraducir implements ActionListener {
    JTextField miTextoATraducir;
	JLabel miEtiquetaTraducida3;
	
	
	public EventoTraducir(JTextField miTextoATraducir, JLabel miEtiquetaTraducida3) {
		this.miTextoATraducir = miTextoATraducir;
		this.miEtiquetaTraducida3 = miEtiquetaTraducida3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. Control de errores -> En función privada.
		if (!miTextoATraducir.getText().isEmpty()) {
			try {
				miEtiquetaTraducida3.setText(Operaciones.traducir(miTextoATraducir.getText()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha introducido el texto correcto", "ERROR", 0);
		}
    }
}
