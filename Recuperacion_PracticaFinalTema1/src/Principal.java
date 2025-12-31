import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Carga.Carga;
import Carga.Comprobacion;
import Menus.MenuGeneral;
import Objetos.Empleado;
import Objetos.Planta;

public class Principal {
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
			System.err.println("Error en la carga de los ficheros.\n Valor devuelto: " + ioe.getMessage());
		}
	}

	private static void ejecucionMenu() {
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

	public static void main(String[] args) {
		cargaDatos();
		ejecucionMenu();
	}
}
