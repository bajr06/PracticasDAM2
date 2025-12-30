package Carga;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Comprobacion {
	public static File [] comprobacionExistenciaFicheros() throws IOException {
		File [] ficheros = {
			new File("Recuperacion_PracticaFinalTema1/src/FicherosCarga/"),
			new File("Recuperacion_PracticaFinalTema1/src/FicherosCarga/plantas.xml"),
			new File("Recuperacion_PracticaFinalTema1/src/FicherosCarga/plantas.dat"),
			new File("Recuperacion_PracticaFinalTema1/src/FicherosCarga/empleados.dat")
		};

		for(File fichero: ficheros) {
			if(ficheros[0].exists()) {
				if(!fichero.exists()) {
					fichero.createNewFile();

					IO.println("Nuevos ficheros creados, posible error.");
				}
			} else {
				ficheros[0].mkdir();

				IO.println("Nuevo directorio creado, posible error.");
			}
		}

		return ficheros;
	}

	private static Object [] controlEntrada(Scanner s) throws NoSuchElementException {
		Object [] entrada = new Object[2];

		IO.print("Introduzca su identificacion de usuario: ");
		entrada[0] = s.nextInt();

		s.nextLine();
		
		IO.print("Introduzca su contraseña: ");
		entrada[1] = s.nextLine();

		return entrada;
	}

	public static Empleado comprobacionCredenciales(ArrayList<Empleado> empleados) {
		try {
			Object [] datos = controlEntrada(new Scanner(System.in));

			for(Empleado e: empleados) {
				if(e.getIdentificacion() == (int)datos[0] && e.getContrasenya().equals((String)datos[1])) {
					System.out.println("Sesión iniciado correctamente, bienvenid@ " + e.getNombre());							
					return e;
				}
			}

			IO.println("Usuario no existente, intentelo de nuevo");
		} catch(NoSuchElementException nsee) {
			System.err.println("Entrada incorrecta ha devuelto " + nsee.getMessage() + "\nInserte los datos según se le pida.");
		}

		return null;
	}
}
