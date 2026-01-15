package Acciones;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Objetos.Planta;

public class AccionesGestor {
	static Scanner s = new Scanner(System.in);

	private static Object [] peticionDatos() throws NoSuchElementException {
		Object [] datos = new Object[5];

		IO.print("Escriba el nombre de la nueva planta: ");
		datos[0] = s.nextLine();

		IO.print("Escriba el nombre del fichero de la foto de la planta: ");
		datos[1] = s.nextLine();

		IO.print("Escriba su descripción: ");
		datos[2] = s.nextLine();

		IO.print("Escriba su precio: ");
		datos[3] = s.nextFloat();

		IO.print("Escriba su cantidad: ");
		datos[4] = s.nextInt();

		s.nextLine();

		return datos;
	}

	public static void darAlta(ArrayList<Planta> plantas) {
		try {
			Object [] datos = peticionDatos();

			plantas.add(new Planta(plantas.size() + 1, (String) datos[0], (String) datos[1], (String) datos[2], (float) datos[3], (int) datos[4]));

			IO.println("Nueva planta dada de alta correctamente\n");
		} catch(NoSuchElementException nsee) {
			System.err.println("Entrada incorrecta ha devuelto " + nsee.getMessage() + "\nInserte los datos según se le pida.\n");
		}
	}

	public static void darBaja(ArrayList<Planta> plantas) {
		
	}
}
