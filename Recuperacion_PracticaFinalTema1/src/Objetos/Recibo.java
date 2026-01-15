package Objetos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Recibo {
	private File fichero;
	private int numeroTicket;
	private Empleado empleado;
	private Planta [] plantas;
	private int [] cantidades;
	private float precioTotal;
	private String encabezado = "Número Ticket: " + numeroTicket + "\n" + 
								"------------------------------//------------------------------\n" +
								"Identificador del Empleado que ha atendido: " + empleado.getIdentificacion() + "\n" + 
								"Nombre del empleado: " + empleado.getNombre() + "\n" + 
								"Codigo_Producto			Cantidad			Precio_Unitario\n";
	private String cuerpo = "";
	private String pie = 	"------------------------------//------------------------------\n" +
							"Total: " + precioTotal + "\n";

	
	public int getNumeroTicket() {
		return numeroTicket;
	}
	
	public File getFichero() {
		return fichero;
	}


	public Recibo(Empleado empleado, Planta [] plantas, int [] cantidades) {
		this.empleado = empleado;
		this.plantas = plantas;
		this.cantidades = cantidades;
	}


	private void advertencia(File fichero) {
		if(!fichero.exists()) {
			System.out.println("¡Cuidado! Parece ser que hay tickets que han sido eliminados...\n" + "Cerrando programa.");
			System.exit(1);
		}
	}

	private String imprimirVenta() {
		for(int i = 0; i < plantas.length; i++) {
			cuerpo += plantas[i].getCodigo() + "\t\t\t\t\t\t" + cantidades[i] + "\t\t\t\t\t" + (cantidades[i] * plantas[i].getPrecio()) + "\n";
			precioTotal += cantidades[i] * plantas[i].getPrecio();
			plantas[i].setCantidad(plantas[i].getCantidad() - cantidades[i]);
		}

		return cuerpo;
	}

	public void generarTicket(int numeroTicket, String nombreDirectorio) {
		precioTotal = 0;
		
		fichero = new File("Recuperacion_PracticaFinalTema1/" + nombreDirectorio + "/" + numeroTicket + ".txt");
		advertencia(fichero);

		try(PrintWriter pw = new PrintWriter(fichero)) {
			pw.print(encabezado);
			
			pw.print(imprimirVenta());

			pw.print(pie);
		} catch(IOException ioe) {
			System.err.println("Error: " + ioe + ": Directorio o fichero no existente.");
		}
	}

	private String imprimirDevolucion() {
		for(int i = 0; i < plantas.length; i++) {
			cuerpo += plantas[i].getCodigo() + "\t\t\t\t\t\t" + cantidades[i] + "\t\t\t\t\t-" + (cantidades[i] * plantas[i].getPrecio()) + "\n";
			precioTotal -= cantidades[i] * plantas[i].getPrecio();
			plantas[i].setCantidad(plantas[i].getCantidad() + cantidades[i]);
		}

		return cuerpo;
	}

	public void generarDevolucion(int numeroTicket, String nombreDirectorio) {
		precioTotal = 0;
		
		fichero = new File("Recuperacion_PracticaFinalTema1/" + nombreDirectorio + "/" + fichero.getName());
		advertencia(fichero);

		try(PrintWriter pw = new PrintWriter(fichero)) {
			pw.print(encabezado);

			pw.print(imprimirDevolucion());
			
			pw.print(pie);
		} catch(IOException ioe) {
		System.err.println("Error: " + ioe + ": Directorio o fichero no existente.");
		}
	}
}
