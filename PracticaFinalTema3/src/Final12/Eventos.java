package Final12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Eventos implements ActionListener {
	private char caracter;
	private int i = 0;
	private boolean verificacion = ManejoFicheros.verificacionExistencia();
	private static List<Usuario> listaUsuarios;
	private static List<Periodico> listaPeriodicos;

	protected static Usuario usuarioSesion;

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
			/*case "Testear Noticias":
				testearNoticias();
				break;
			*/
			case "Guardar Noticias en Historico":
				guardarNoticiasHistorial();
				break;
			case "Acerca de":
				mostrarDatosAplicacion();
				break;
			case "Atras":
				retroceder();
				break;
			case "Cerrar":
				confirmarCierre();
				break;
			default:
				error("Error de identificacion del botón.");
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

			error("Error en la carga de datos. Cerrando programa");

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
		boolean comprobacion = false;

		for(Usuario u : listaUsuarios) {
			if((u.getNombreUsuario().equals(PanelSesion.peticionUsuario.getText())) && (u.getContrasenia().equals(new String(PanelSesion.peticionContrasenya.getPassword())))) {
				comprobacion = true;
				usuarioSesion = u;

				if(u.getTu() == TipoUsuario.USUARIO && u.isPrimeraVez()) {
					Ventana.ps.setVisible(false);
					Ventana.ppv.setVisible(true);
				} else if(u.getTu() == TipoUsuario.USUARIO && !u.isPrimeraVez()) {
					Ventana.ps.setVisible(false);
					Ventana.pu.setVisible(true);
					cargarNoticiasUsuario(usuarioSesion);
				} else if(u.getTu() == TipoUsuario.ADMINISTRADOR) {
					Ventana.ps.setVisible(false);
					Ventana.pa.setVisible(true);
				} 
			}
		}
		
		if(!comprobacion) {
			JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos", "ERROR", 0);
		}
	}

	private void guardarSelecciones() {
		boolean seleccionHecha = false;

		for(i = 0; i < opciones.length; i++) {
			if (opciones[i].isSelected()) {
				Operaciones.anyadirSelecciones(i + 1, listaPeriodicos.get(i), usuarioSesion);
				seleccionHecha = true;
			} else {
				IO.println(i);
			}
		}

		if (seleccionHecha) {
			usuarioSesion.setPrimeraVez(false); 

			try {
				Operaciones.reescribirUsuarios(listaUsuarios);
				
				Ventana.ppv.setVisible(false);
				Ventana.pu.setVisible(true);
				cargarNoticiasUsuario(usuarioSesion);
			} catch (IOException e) {
				error("Error en la carga de las selecciones");
			}
        } else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fuente de noticias para continuar.", "Advertencia", 0);
		}
	}

	private void nuevoUsuario() {
		String nombreUsuario = JOptionPane.showInputDialog("Introduzca el Nombre: ");
		String contraseña = JOptionPane.showInputDialog("Introduzca la Contraseña: ");
		String correoElectronico = JOptionPane.showInputDialog("Introduzca un Correo Electrónico: ");

		while(!Operaciones.comprobacionCorreo(correoElectronico)) {
			correoElectronico = JOptionPane.showInputDialog("Por favor, introduzca un Correo Electrónico válido: ");
		}

		Usuario nuevoUsuario = new Usuario(listaUsuarios.size() + 1, nombreUsuario, contraseña, correoElectronico, true, TipoUsuario.USUARIO);
		listaUsuarios.add(nuevoUsuario);
		
		try {
			Operaciones.escribirUsuario(nuevoUsuario);
		} catch(Exception e) {
			error("Error a la hora de añadir nuevo usuario. Cerrando programa.");
			Principal.v.dispose();
			System.exit(1);
		}
	}

	private void borrarUsuario() {
		int idUsuarioBorrar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario a borrar: "));

		for(i = 0; i < listaUsuarios.size(); i++) {
			if(listaUsuarios.get(i).getIdUsuario() == idUsuarioBorrar) {
				listaUsuarios.remove(listaUsuarios.get(i));
				
				try {
					Operaciones.borrarUsuario(idUsuarioBorrar);
				} catch (IOException ioe) {
					error("Error a la hora de borrar el usuario.");
				}
			}
		}
	}


	/*
	private void testearNoticias() {		
		for (Periodico p : listaPeriodicos) {
			try {
				String cuerpo = Operaciones.prueba(p.getUrlPeriodico(), p.getContenedorNoticia());
				Operaciones.enviarEmailTest(cuerpo);
			} catch (IOException e) {

			}
		}
		
		JOptionPane.showMessageDialog(null, "Verificque su correo.", "Test de Noticias", 1);
	}
	*/

	public static void cargarNoticiasUsuario(Usuario usuario) {
		PanelUsuario.panelNoticias.removeAll(); 

		String [] noticiasMostrar = new String[listaPeriodicos.size()];
		String idUsuario = String.valueOf(usuario.getIdUsuario());
		int contador = 1, i = 0;

		if (listaPeriodicos != null) {
			for (Periodico p : listaPeriodicos) {
				String[] selecciones = p.getSelecciones();
                                
				if ((selecciones != null) && Arrays.asList(selecciones).contains(idUsuario)) {
					try {
						String titular = Operaciones.prueba(p.getUrlPeriodico(), p.getContenedorNoticia());
						noticiasMostrar[i] = titular;

						JLabel titularLabel = new JLabel(contador + ". [" + p.getTn().toString() + "] " + titular);
						PanelUsuario.panelNoticias.add(titularLabel);
						contador++;
						i++;
					} catch (IOException e) {
						error("Error en el cargado de noticias.");
					}
				}
			}
		}

		if (contador == 1) {
			error("Error, no hay noticias seleccionadas.");
		}
		
		PanelUsuario.panelNoticias.revalidate(); 
		PanelUsuario.panelNoticias.repaint();
    }

	public static void confirmarCierre() {
		int confirmacion = JOptionPane.showConfirmDialog(Principal.v, "¿Está seguro que desea cerrar la aplicación?", "Confirmación de Salida", JOptionPane.YES_NO_OPTION, 3);

		if (confirmacion == JOptionPane.YES_OPTION) {
			Principal.v.dispose();
			System.exit(0);
		}
	}

	private void guardarNoticiasHistorial() {
		int noticiasGuardadas = 0;
		String idUsuario = String.valueOf(usuarioSesion.getIdUsuario());
		
		for (Periodico p : listaPeriodicos) {
			String[] selecciones = p.getSelecciones();
			
			if ((selecciones != null) && Arrays.asList(selecciones).contains(idUsuario)) {
				try {
					String titular = Operaciones.prueba(p.getUrlPeriodico(), p.getContenedorNoticia());
					Operaciones.escribirHistorico(usuarioSesion, p, titular);
					noticiasGuardadas++;      
				} catch (IOException ioe) {
					error("Error en el guardado historico");
				}
			}
		}
		
		if (noticiasGuardadas > 0) {
			JOptionPane.showMessageDialog(null, "Se han guardado " + noticiasGuardadas + " noticias en su historial.",  "Guardado Completado", 2);
		} else {
			JOptionPane.showMessageDialog(null, "No hay noticias seleccionadas para guardar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void retroceder() {
		Ventana.pa.setVisible(false);
		Ventana.ppv.setVisible(false);
		Ventana.pu.setVisible(false);
		Ventana.ps.setVisible(true);
	}

	public static void error(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "ERROR", 0);
	}

	private void mostrarDatosAplicacion() {
		mensaje = "Versión: 1.0\nCreada por: Bryan Andreu Jiménez Rojas";
		JOptionPane.showMessageDialog(null, mensaje, "ACERCA DE", 1);
	}
}
