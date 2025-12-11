package Final12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Eventos implements ActionListener {
	private int i = 0;
	private boolean verificacion = VerificacionLecturaFicheros.verificacionExistencia();
	private Exception captura = null;
	
	public Eventos() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getID() == 0) {
			PanelCarga.barraCarga.setValue(i++);
			PanelCarga.mostrarCarga.setText("Cargando: " + i + "%");

			try {
				VerificacionLecturaFicheros.LecturaUsuarios();
				VerificacionLecturaFicheros.LecturaPeriodicos();
			} catch(Exception ex) {
				captura = ex;
			}
			
			if(i == 100 && (verificacion || captura == null)) {
				Principal.reiniciarVentana();
				Ventana.pc.setVisible(false);
				Ventana.ps.setVisible(true);
				PanelCarga.tiempo.stop();
			} else if(i == 80 && (!verificacion || captura != null)) {
				PanelCarga.tiempo.stop();

				String mensaje = "Ha ocurrido un error de carga de los ficheros, se cerrara el programa.";
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
