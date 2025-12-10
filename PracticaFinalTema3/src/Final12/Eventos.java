package Final12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Eventos implements ActionListener {
	private int i = 0;
	private String mensaje;
	
	public Eventos() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getID() == 0) {
			PanelCarga.barraCarga.setValue(i++);
			PanelCarga.mostrarCarga.setText("Cargando: " + i + "%");

			if(i >= 100 && VerificacionLecturaFicheros.verificacionExistencia()) {
				VerificacionLecturaFicheros.LecturaFicheros();
				Principal.reiniciarVentana();

				Ventana.pc.setVisible(false);
				Ventana.ps.setVisible(true);
				
				PanelCarga.tiempo.stop();
			} else if(i == 80 && !VerificacionLecturaFicheros.verificacionExistencia()) {
				mensaje = "Ha ocurrido un error de carga, se cerrara el programa.";
				JOptionPane.showMessageDialog(null, mensaje, "ERROR", 0);
				Principal.v.dispose();
				System.exit(1);
			}
		} else if(e.getID() == 1001) {
			Ventana.ps.setVisible(false);
			Ventana.pu.setVisible(true);
		}
	}
}
