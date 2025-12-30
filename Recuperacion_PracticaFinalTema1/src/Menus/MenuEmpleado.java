package Menus;

import java.util.Scanner;

public class MenuEmpleado {
	private static Scanner s = new Scanner(System.in);
	
	public static int seleccionOpcionE() {
		IO.println("Seleccione una de las siguientes opciones:");
		IO.println("1. Ver catálogo");
		IO.println("2. Realizar acción");
		IO.println("3. Buscar ticket");

		return s.nextInt();
	}

	public static int seleccionAccionE() {
		IO.println("¿Qué acción deseas hacer?");
		IO.println("Venta");
		IO.println("Compra");

		return s.nextInt();
	}
}
