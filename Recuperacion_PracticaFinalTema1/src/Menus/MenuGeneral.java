package Menus;

import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Acciones.AccionesVendedor;
import Objetos.Empleado;
import Objetos.Planta;

public class MenuGeneral {
	private static void ejecutarAccionesVendedor(Empleado empleado, int seleccion, ArrayList<Planta> plantas, File [] ficheros) {
		if(seleccion == 1) {
			AccionesVendedor.realizarVenta(empleado, plantas, ficheros);
		} else if(seleccion == 2) {
			AccionesVendedor.realizarDevolucion(plantas, ficheros);
		} else {
			System.out.println("Opción no existente, intentelo de nuevo");
		}
	}

	private static void ejecutarOpcionesVendedor(Empleado empleado, int seleccion, ArrayList<Planta> plantas, File [] ficheros) {
		do {
			if(seleccion == 1) {
				AccionesVendedor.mostrarPlantas(plantas);
			} else if(seleccion == 2) {
				ejecutarAccionesVendedor(empleado, MenuVendedor.seleccionAccionV(), plantas, ficheros);
			} else if(seleccion == 3) {
				AccionesVendedor.buscarTicket(ficheros);
			} else {
				System.out.println("Opción no existente, intentelo de nuevo");
			}

			seleccion = MenuVendedor.seleccionOpcionV();
		} while(seleccion >= 1 && seleccion <= 3);
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
					ejecutarOpcionesVendedor(tipoUsuario, MenuVendedor.seleccionOpcionV(), plantas, ficheros);					
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
