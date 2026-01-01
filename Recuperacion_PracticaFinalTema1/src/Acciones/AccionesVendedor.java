package Acciones;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Menus.MenuVendedor;
import Objetos.Empleado;
import Objetos.Planta;

public class AccionesVendedor {
	private static int contarFicherosVD(File directorioVentas, File directorioDevoluciones) {
		String [] listaVentas = directorioVentas.list();
		String [] listaDevoluciones = directorioDevoluciones.list();
		int cont1 = 0, cont2 =0;
		
		for(String ventas: listaVentas) {
			IO.println(ventas + " " + cont1);
			cont1++;
		}

		for(String devoluciones: listaDevoluciones) {
			IO.println(devoluciones);
			cont2++;
		}

		return cont1 + cont2;
	}

	public static void mostrarPlantas(ArrayList<Planta> plantas) {
		for (Planta planta : plantas) {
			System.out.println(planta.toString());
		}
	}

	private static void crearTicket(Empleado empleado, Planta [] plantas, int [] cantidades, File [] ficheros) {
		int cantidadFicheros = contarFicherosVD(ficheros[1], ficheros[2]);
		String ruta = "Recuperacion_PracticaFinalTema1/src/Ventas/" + "TicketV_" + cantidadFicheros + ".txt";
		File nuevoTicket = new File(ruta);
		float precioTotal = 0;

		try(PrintWriter pw = new PrintWriter(nuevoTicket)) {
			if(!nuevoTicket.createNewFile()) {
				System.out.println("¡Cuidado! Parece ser que hay tickets que han sido eliminados...");
				System.out.println("Cerrando programa.");
				System.exit(0);
			}

			pw.printf("Número Ticket: %d\n", cantidadFicheros);
			pw.printf("------------------------------//------------------------------\n");
			pw.printf("Identificador del Empleado que ha atendido: %s\n", empleado.getIdentificacion());
			pw.printf("Nombre del empleado: %s\n", empleado.getNombre());
			pw.printf("Codigo_Producto			Cantidad			Precio_Unitario\n");
			for(int i = 0; i < plantas.length; i++) {
				pw.println(plantas[i].getCodigo() + "\t\t\t\t\t\t" + cantidades[i] + "\t\t\t\t\t" + (cantidades[i] * plantas[i].getPrecio()));

				precioTotal += cantidades[i] * plantas[i].getPrecio();
				plantas[i].setCantidad(plantas[i].getCantidad() - cantidades[i]);
			}
			pw.printf("------------------------------//------------------------------\n");
			pw.printf("Total: %f\n", precioTotal);
		} catch(IOException ioe) {
			System.err.println("Error: " + ioe + ": Directorio o fichero no existente.");
		}

		IO.println("Venta realizada correctamente :)\n");
	}

	public static void realizarVenta(Empleado empleado, ArrayList<Planta> plantas, File [] directorio) {
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
			}

			crearTicket(empleado, plantasAVender, cantidades, directorio);
		} catch(NoSuchElementException nsee) {
			System.err.println("Entrada incorrecta ha devuelto " + nsee.getMessage() + "\nInserte los datos según se le pida.\n");
		}
	}

	public static void realizarDevolucion(ArrayList<Planta> plantas, File directorio) {
	}

	public static void buscarTicket(File [] ficheros) {
		
	}
}
