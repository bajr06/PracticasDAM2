package Tema2;

import java.sql.Connection;

public class Opciones {
    public static int opciones() {
        System.out.println("Bienvenido a la CRM de la jugetería \"Juguetón\".");
		System.out.println("¿Operación referente a que objeto quiere realizar?");
		IO.println("1.- Juguetes");
		IO.println("2.- Empleado");
		IO.println("3.- Ventas");
		IO.println("4.- Datos de la Tienda");

        return Principal.sc.nextInt();
	}

    public static void opcionesJuguetes(Connection conexion) {
        System.out.println("Escoja la operación a realizar: ");
        IO.println("1. Registrar el nuevo juguete");
        IO.println("2. Modificar los datos de los juguetes");
        IO.println("3. Eliminar juguetes");

        switch (Principal.sc.nextInt()) {
            case 1 -> Juguete.nuevoJuguete(conexion);
            case 2 -> Juguete.modificarJuguete(conexion);
            case 3 -> Juguete.eliminarJuguete(conexion);
            default -> System.err.println("Opción escogida no existente");
        }
    }

    public static int modificarJuguete() {
        System.out.println("Introduzca el dato a cambiar del Juguete: ");
        IO.println("0. Nombre");
        IO.println("1. Descripción");
        IO.println("2. Precio");
        IO.println("3. Cantidad");

        return Principal.sc.nextInt();
    }

    public static void opcionesEmpleados() {
        System.out.println("Escoja la operación a realizar: ");
        IO.println("1. Registrar nuevo empleado");
        IO.println("2. Modificar los datos de un empleado");
        IO.println("3. Eliminar el empleado");

        Principal.sc.nextInt();
    }

    public static void opcionesVentas() {
        System.out.println("Escoja la operación a realizar: ");
        IO.println("1. Realizar una venta");
        IO.println("2. Realizar una devolución");
        IO.println("3. Producto más vendido");
        IO.println("4. Los empleados más vendidos");

        Principal.sc.nextInt();
    }

    public static void opcionesDatosTienda() {
        System.out.println("Escoja la operación a realizar");
        IO.println("1. Juguetes disponibles");
        IO.println("2. Ventas realizados en un mes");
        IO.println("3. Ventas realizados por un empleado en un mes");
        IO.println("4. Cambios de los empleados y motivos");
        IO.println("5. Juguetes ordenados por precio");

        Principal.sc.nextInt();
    }

    public static void opciones(Connection conexion) {
        int opcion1 = opciones();
		    do {
			    switch (opcion1) {
				    case 1 -> opcionesJuguetes(conexion);
				    case 2 -> opcionesEmpleados();
				    case 3 -> opcionesVentas();
				    case 4 -> opcionesDatosTienda();
				    case 5 -> IO.println("Usted ha salido del programa");
				    default -> IO.println("Número de opción incorrecto.");
			    }
		    } while(opcion1 <= 0 && opcion1 >= 5);
        }
}
