package Acciones;

import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Menus.MenuVendedor;
import Objetos.Planta;

public class AccionesVendedor {
	public static void mostrarPlantas(ArrayList<Planta> plantas) {
		for (Planta planta : plantas) {
			System.out.println(planta.toString());
		}
	}

	public static void realizarVenta(ArrayList<Planta> plantas, File fichero) {
		try {
			int seleccionPlanta = MenuVendedor.seleccionPlantaV();
			int seleccionCantidad = MenuVendedor.seleccionCantidadV();
			Planta plantaSeleccionada = null;
			
			for(Planta planta: plantas) {
				if(planta.getCodigo() == seleccionPlanta) {
					plantaSeleccionada = planta;
				}
			}

			if(plantaSeleccionada == null) {
				System.out.println("No existe esta planta, intentelo de nuevo");
				return;
			} else if(seleccionCantidad > plantaSeleccionada.getCantidad() || plantaSeleccionada.getCantidad() <= 0) {
				System.out.println("Planta sin disponibilidad, intentelo con otra planta.");
				return;
			}

			

		} catch(NoSuchElementException nsee) {
			System.err.println("Entrada incorrecta ha devuelto " + nsee.getMessage() + "\nInserte los datos según se le pida.");
		}
	}

	public static void realizarDevolucion(ArrayList<Planta> plantas, File fichero) {
	}

	public static void buscarTicket(File [] ficheros) {
		
	}
}
