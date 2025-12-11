package Final12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Eventos implements ActionListener {
	private char caracter;
	private int i = 0;
	private boolean verificacion = VerificacionLecturaFicheros.verificacionExistencia();
	private String mensaje;
	private Exception captura = null;
	
	public Eventos() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case null:
				eventoCarga();
				break;
			case "Mostrar":
				mostrarContrasenya();
				break;
			case "Iniciar sesion":
				cambioPanel1();
				break;
			default:
				IO.println(e.getActionCommand());
				mensaje = "Accion no reconocida. Cerrando programa.";
				JOptionPane.showMessageDialog(null, mensaje, "ERROR", 0);
				break;
		}
	}

	private void eventoCarga() {
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

			mensaje = "Ha ocurrido un error de carga de los ficheros, se cerrara el programa.";
			JOptionPane.showMessageDialog(null, mensaje, "ERROR", 0);

			Principal.v.dispose();
			System.exit(1);
		}
	}

	private void mostrarContrasenya() {
		
		if(PanelSesion.verContrasenya.isSelected()) {
			caracter = PanelSesion.peticionContrasenya.getEchoChar();
			PanelSesion.peticionContrasenya.setEchoChar((char)0);
		} else {
			PanelSesion.peticionContrasenya.setEchoChar(caracter);
		}
	}


	private void cambioPanel1() {
		Ventana.ps.setVisible(false);
		Ventana.ppv.setVisible(true);
	}
}
