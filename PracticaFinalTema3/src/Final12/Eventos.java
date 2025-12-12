package Final12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class Eventos implements ActionListener {
	private char caracter;
	private int i = 0;
	private boolean verificacion = ManejoFicheros.verificacionExistencia();
	private static List<Usuario> listaUsuarios;
	private static List<Periodico> listaPeriodicos;

	private JCheckBox [] opciones = {
		PanelPrimezaVez.seleccionEconomia_1,
		PanelPrimezaVez.seleccionEconomia_2,
		PanelPrimezaVez.seleccionEconomia_3,
		PanelPrimezaVez.seleccionDeporte_1,
		PanelPrimezaVez.seleccionDeporte_2,
		PanelPrimezaVez.seleccionDeporte_3,
		PanelPrimezaVez.seleccionNacional_1,
		PanelPrimezaVez.seleccionNacional_2,
		PanelPrimezaVez.seleccionNacional_3,
		PanelPrimezaVez.seleccionInternacional_1,
		PanelPrimezaVez.seleccionInternacional_2,
		PanelPrimezaVez.seleccionInternacional_3,
		PanelPrimezaVez.seleccionTecnologia_1,
		PanelPrimezaVez.seleccionTecnologia_2,
		PanelPrimezaVez.seleccionTecnologia_3,
		PanelPrimezaVez.seleccionVideojuego_1,
		PanelPrimezaVez.seleccionVideojuego_2,
		PanelPrimezaVez.seleccionVideojuego_3
	};
	
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
				cambioPanel();
				break;
			case "Confirmar":
				guardarSelecciones();
				break;
			case "Crear Usuario":
				nuevoUsuario();
				break;
			case "Borrar Usuario":
				borrarUsuario();
				break;
			case "Testear Noticias":
				testearNoticias();
				break;
			case "Acerca de":
				mostrarDatosAplicacion();
				break;
			default:
				IO.println(e.getActionCommand());
				mensaje = "Accion no reconocida. Cerrando programa.";
				JOptionPane.showMessageDialog(null, mensaje, "ERROR", 0);
				break;
		}
	}

	private void lecturaFicheros() {
		try {
			listaUsuarios = ManejoFicheros.LecturaUsuarios();
			listaPeriodicos = ManejoFicheros.LecturaPeriodicos();
		} catch(Exception ex) {
			captura = ex;
		}
	}

	private void eventoCarga() {
		PanelCarga.barraCarga.setValue(i++);
		PanelCarga.mostrarCarga.setText("Cargando: " + i + "%");

		if(i == 80) {
			lecturaFicheros();
		}

		if(i == 100 && (verificacion || captura == null)) {
			Principal.reiniciarVentana();
			Ventana.pc.setVisible(false);
			Ventana.ps.setVisible(true);
			PanelCarga.tiempo.stop();
		} else if(i == 80 && (!verificacion || captura != null)) {
			PanelCarga.tiempo.stop();

			error();

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

	private void cambioPanel() {
		for(Usuario u : listaUsuarios) {
			if((u.getNombreUsuario().equals(PanelSesion.peticionUsuario.getText())) && (u.getContrasenia().equals(new String(PanelSesion.peticionContrasenya.getPassword())))){
				if(u.getTu() == TipoUsuario.USUARIO && u.isPrimeraVez()) {
					Ventana.ps.setVisible(false);
					Ventana.ppv.setVisible(true);
				} else if(u.getTu() == TipoUsuario.USUARIO && !u.isPrimeraVez()) {
					Ventana.ps.setVisible(false);
					Ventana.pu.setVisible(true);
				} else if(u.getTu() == TipoUsuario.ADMINISTRADOR) {
					Ventana.ps.setVisible(false);
					Ventana.pa.setVisible(true);
				} 
			}/* else {
				JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos", "ERROR", 0);

			}*/
		}
	}

	private void guardarSelecciones() {
		for(i = 0; i < opciones.length; i++) {
			if (opciones[i].isSelected()) {
				
			} else {

			}
		}
	}

	private void nuevoUsuario() {
		String nombreUsuario = JOptionPane.showInputDialog("Introduzca el Nombre: ");
		String contraseña = JOptionPane.showInputDialog("Introduzca la Contraseña: ");
		String correoElectronico = JOptionPane.showInputDialog("Introduzca un Correo Electrónico: ");

		Usuario nuevoUsuario = new Usuario(listaUsuarios.size() + 1, nombreUsuario, contraseña, correoElectronico, true, TipoUsuario.USUARIO);
		listaUsuarios.add(nuevoUsuario);
		
		try {
			Operaciones.escribirUsuario(nuevoUsuario);
		} catch(Exception e) {
			error();
			Principal.v.dispose();
			System.exit(1);
		}
	}

	private void borrarUsuario() {
		int idUsuarioBorrar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario a borrar: "));
		Usuario buscar = null;

		for(Usuario u : listaUsuarios) {
			if(u.getIdUsuario() == idUsuarioBorrar) {
				buscar = u;

				try {
					Operaciones.borrarUsuario(u, idUsuarioBorrar);
				} catch (IOException ioe) {
					error();
				}
			}
		}

		listaUsuarios.remove(buscar);
	}

	private void testearNoticias() {}

	private void error() {
		mensaje = "Ha ocurrido un error grave. Cerrando Programa";
		JOptionPane.showMessageDialog(null, mensaje, "ERROR", 0);

	}

	private void mostrarDatosAplicacion() {
		mensaje = "Versión: 1.0\nCreada por: Bryan Andreu Jiménez Rojas";
		JOptionPane.showMessageDialog(null, mensaje, "ACERCA DE", 1);
	}
}
