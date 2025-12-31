package Carga;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Objetos.Empleado;

public class Comprobacion {
	private static File [] ficheros = {
		new File("Recuperacion_PracticaFinalTema1/src/FicherosCarga"),
		new File("Recuperacion_PracticaFinalTema1/src/Ventas"),
		new File("Recuperacion_PracticaFinalTema1/src/Devoluciones"),
		new File("Recuperacion_PracticaFinalTema1/src/FicherosCarga/plantas.xml"),
		new File("Recuperacion_PracticaFinalTema1/src/FicherosCarga/plantas.dat"),
		new File("Recuperacion_PracticaFinalTema1/src/FicherosCarga/empleados.dat"),
	};

	public static File [] comprobacionExistenciaFicheros() throws IOException {
			for(int i = 3; i < ficheros.length; i++) {
				if(ficheros[0].exists()) {
					if(!ficheros[i].exists()) {
						ficheros[i].createNewFile();

						IO.println("Nuevos ficheros creados, posible error.");
					} else if(!ficheros[0].exists()){
						ficheros[0].mkdir();
						IO.println("Nuevo directorio creado, posible error.");
						comprobacionExistenciaFicheros();
					} else if(!ficheros[1].exists()) {
						ficheros[1].mkdir();
						comprobacionExistenciaFicheros();
					} else if(!ficheros[2].exists()) {
						ficheros[2].mkdir();
						comprobacionExistenciaFicheros();
					}
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
