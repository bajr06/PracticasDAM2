package Menus;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuGestor {
	private static Scanner s = new Scanner(System.in);

	public static int seleccionOpcionG() throws NoSuchElementException {
		IO.println("Seleccione una de las siguientes opciones:");
		IO.println("1. Realizar acción en plantas");
		IO.println("2. Realizar acción en empleados");
		IO.println("3. Ver estadísticas");

		return s.nextInt();
	}

	public static int seleccionOpcionGP() throws NoSuchElementException {
		IO.println("Seleccione la opción a realizar sobre las plantas:");
		IO.println("1. Dar de alta");
		IO.println("2. Dar de baja");

		return s.nextInt();
	}

	public static int seleccionOpcionGE() throws NoSuchElementException {
		IO.println("Seleccione la opción a realizar sobre los empleados:");
		IO.println("1. Dar de alta");
		IO.println("2. Dar de baja");

		return s.nextInt();
	}
}
