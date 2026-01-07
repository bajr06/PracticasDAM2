import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Carga.Carga;
import Carga.Comprobacion;
import Menus.MenuGeneral;
import Modificacion.Modificacion;
import Objetos.Empleado;
import Objetos.Planta;

public class Principal {
	public final static int EXIT_SUCCESS = 0, EXIT_FAILURE = 1;
	private static File [] ficheros;
	private static ArrayList<Planta> plantas;
	private static ArrayList<Empleado> empleados;

	private static void cargaDatos()  {
		try {
			ficheros = Comprobacion.comprobacionExistenciaFicheros();
		
			plantas = Carga.cargaPlantasXML(ficheros[3]);
			Carga.cargaPlantasDAT(plantas);

			empleados = Carga.cargaEmpleadosDAT(ficheros[5]);
		} catch(IOException ioe) {
			System.err.println("Error en la carga de los ficheros.\n Valor devuelto: \"" + ioe.getMessage() + "\"\n Cerrando programa\n");
			System.exit(EXIT_FAILURE);
		}
	}

	private static void ejecucionMenu() {
		IO.println("¡Bienvenido al vivero C+#!");

		try {
			Empleado tipoUsuario;

			do {
				tipoUsuario = Comprobacion.comprobacionCredenciales(empleados);
			} while(tipoUsuario == null);

			MenuGeneral.ejecutarMenu(tipoUsuario, plantas, empleados, ficheros);
		} catch(NoSuchElementException nsee) {
			System.err.println("Entrada incorrecta ha devuelto " + nsee.getMessage() + "\nInserte los datos según se le pida.");
		}
	}

	private static void modificacionDatos() {
		try {
			Modificacion.modificarPlantasXML(ficheros[3], plantas);
			Modificacion.modificarPlantasDAT(ficheros[4], plantas);
			Modificacion.modificarEmpleadoDAT(ficheros[5], empleados);
		} catch(IOException ioe) {
			System.err.println("Error en la carga de los datos cambiados en la aplicación: \"" + ioe.getMessage() + "\"\n Cerrando Programa.\n");
			System.exit(EXIT_FAILURE);
		}
	}

	public static void main(String[] args) {
		cargaDatos();

		ejecucionMenu();

		modificacionDatos();
	}
}
