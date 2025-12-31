package Menus;

import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Acciones.AccionesVendedor;
import Objetos.Empleado;
import Objetos.Planta;

public class MenuGeneral {
	private static void ejecutarAccionesVendedor(int seleccion, ArrayList<Planta> plantas, File [] ficheros) {
		if(seleccion == 1) {
			AccionesVendedor.realizarVenta(plantas, ficheros[1]);
		} else if(seleccion == 2) {
			AccionesVendedor.realizarDevolucion(plantas, ficheros[2]);
		} else {
			System.out.println("Opción no existente, intentelo de nuevo");
		}
	}

	private static void ejecutarOpcionesVendedor(int seleccion, ArrayList<Planta> plantas, File [] ficheros) {
		if(seleccion == 1) {
			AccionesVendedor.mostrarPlantas(plantas);
		} else if(seleccion == 2) {
			ejecutarAccionesVendedor(MenuVendedor.seleccionAccionV(), plantas, ficheros);
		} else if(seleccion == 3) {

		} else {
			System.out.println("Opción no existente, intentelo de nuevo");
		}
	}

	private static void ejecutarOpcionesMenuGestor(int seleccion) {
		if(seleccion == 1) {

		} else if(seleccion == 2) {

		} else if(seleccion == 3) {

		} else {
			System.out.println("Opción no existente, intentelo de nuevo");
		}
	}

	public static void ejecutarMenu(Empleado tipoUsuario, ArrayList<Planta> plantas, ArrayList<Empleado> empleados, File [] ficheros) {
		try {
			switch (tipoUsuario.getCargo()) {
				case "vendedor":
					ejecutarOpcionesVendedor(MenuVendedor.seleccionOpcionV(), plantas, ficheros);					
					break;
				case "gestor":
					ejecutarOpcionesMenuGestor(MenuGestor.seleccionOpcionG());
					break;
				default:
					System.err.println("El empleado no tiene categoría existente, no se puede ejecutar.");
					break;
			}
		} catch(NoSuchElementException nsee) {
			System.err.println("Entrada incorrecta ha devuelto " + nsee.getMessage() + "\nInserte los datos según se le pida.");
		}
	}
}
