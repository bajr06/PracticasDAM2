package Acciones;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Menus.MenuVendedor;
import Modificacion.Baja;
import Objetos.Empleado;
import Objetos.Planta;
import Objetos.Recibo;

public class AccionesVendedor {
	public static void mostrarPlantas(ArrayList<Planta> plantas) {
		for (Planta planta : plantas) {
			System.out.println(planta.toString());
		}

		IO.println();
	}

	private static int contarFicherosVD(File [] directorios) {
		String [] listaVentas = directorios[2].list();
		String [] listaDevoluciones = directorios[3].list();
		int cont1, cont2;
		
		for(cont1 = 0; cont1 < listaVentas.length; cont1++);
		for(cont2 = 0; cont2 < listaDevoluciones.length; cont2++);

		return cont1 + cont2;
	}

	public static void realizarVenta(Empleado empleado, ArrayList<Planta> plantas, File [] directorios) {
		int cantidadPlantasVendidas = MenuVendedor.cantidadPlantasVenta();
		int [] cantidades = new int[cantidadPlantasVendidas];
		Planta [] plantasAVender = new Planta[cantidadPlantasVendidas];
		int seleccionPlanta;

		try {
			for(int i = 0; i < cantidadPlantasVendidas; i++) {
				seleccionPlanta = MenuVendedor.seleccionPlantaV();
				
				for(Planta planta: plantas) {
					if(planta.getCodigo() == seleccionPlanta) {
						plantasAVender[i] = planta;
					}
				}

				if(plantasAVender[i] == null) {
					System.out.println("No existe esta planta");
					System.out.println("Revise primero si el código de la planta existe e intente realizar una venta nuevamente.\n");
					return;
				}
				
				cantidades[i] = MenuVendedor.seleccionCantidadV();

				if(cantidades[i] > plantasAVender[i].getCantidad() || plantasAVender[i].getCantidad() <= 0) {
					System.out.println("Planta sin disponibilidad");
					System.out.println("Revise primero si hay disponibilidad de la planta a vender e intenta realizar una venta nuevamente.\n");
					return;
				}

				IO.println();

			}

			if(MenuVendedor.confirmar()) {
				Recibo ticket = new Recibo(empleado, plantasAVender, cantidades);
				ticket.generarTicket(contarFicherosVD(directorios), directorios[2].getName());
			} else {
				System.out.println("Operación cancelada\n");
			}

			Baja.darBajaPlantas(plantas);
		} catch(NoSuchElementException nsee) {
			System.err.println("Entrada incorrecta ha devuelto " + nsee.getMessage() + "\nInserte los datos según se le pida.\n");
		}
	}

	public static void realizarDevolucion(Recibo ticket) {
		try {
			if(ticket.getFichero().exists()) {
				if(MenuVendedor.confirmar()) {
					ticket.generarDevolucion(ticket.getNumeroTicket(), null);
				} else {
					System.out.println("Operación cancelada\n");
				}
			} else {
				System.out.println("El ticket con la numeración que usted busca, no existe.");
			}

			IO.println();

		} catch(NoSuchElementException nsee) {
			System.err.println("Entrada incorrecta ha devuelto " + nsee.getMessage() + "\nInserte los datos según se le pida.\n");
		}
	}

	public static void buscarTicket(File [] ficheros) {
		try {
			int busqueda = MenuVendedor.seleccionTicket();
			File ficheroBuscadoV = new File("Recuperacion_PracticaFinalTema1/src/Ventas/" + busqueda + ".txt");
			File ficheroBuscadoD = new File("Recuperacion_PracticaFinalTema1/src/Devoluciones/" + busqueda + ".txt");

			if(ficheroBuscadoV.exists()) {
				AccionesGenerales.leerFichero(ficheroBuscadoV);
			} else if(ficheroBuscadoD.exists()) {
				AccionesGenerales.leerFichero(ficheroBuscadoD);
			} else if(!ficheroBuscadoV.exists() && !ficheroBuscadoD.exists()) {
				System.out.println("El ticket con la numeración que usted busca, no existe.");
			}

			IO.println();
			
		} catch(NoSuchElementException nsee) {
			System.err.println("Entrada incorrecta ha devuelto " + nsee.getMessage() + "\nInserte los datos según se le pida.\n");
		} catch(IOException ioe) {
			System.err.println("Error en la lectura del fichero: " + ioe.getMessage() + "\n");
		}
	}
}
