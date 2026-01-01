package Menus;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuVendedor {
	private static Scanner s = new Scanner(System.in);
	
	public static int seleccionOpcionV() throws NoSuchElementException {
		IO.println("Seleccione una de las siguientes opciones:");
		IO.println("1. Ver catálogo");
		IO.println("2. Realizar acción");
		IO.println("3. Buscar ticket");

		return s.nextInt();
	}

	public static int seleccionAccionV() throws NoSuchElementException {
		IO.println("¿Qué acción deseas hacer?");
		IO.println("1. Venta");
		IO.println("2. Devolucion");

		return s.nextInt();
	}

	public static int seleccionPlantaV() throws NoSuchElementException {
		IO.println("¿Qué planta vas a vender?");

		return s.nextInt();
	}

	public static int seleccionCantidadV() throws NoSuchElementException {
		IO.println("¿Qué cantidad vas a vender?");

		return s.nextInt();
	}

	public static int cantidadPlantasVenta() throws NoSuchElementException {
		IO.println("¿Qué cantidad de plantas vas a vender?");

		return s.nextInt();
	}
}