package Tema2;

public class Opciones {
    public static void opciones() {
		System.out.println("¿Operación referente a que objeto quiere realizar?");
		IO.println("1.- Juguetes");
		IO.println("2.- Empleado");
		IO.println("3.- Ventas");
		IO.println("4.- Datos de la Tienda");
	}

    public static void opcionesJuguetes() {
        System.out.println("Escoja la operación a realizar: ");
        IO.println("1. Registrar el nuevo juguete");
        IO.println("2. Modificar los datos de los juguetes");
        IO.println("3. Eliminar juguetes");
    }

    public static void opcionesEmpleados() {
        System.out.println("Escoja la operación a realizar: ");
        IO.println("1. Registrar nuevo empleado");
        IO.println("2. Modificar los datos de un empleado");
        IO.println("3. Eliminar el empleado");
    }

    public static void opcionesVentas() {
        System.out.println("Escoja la operación a realizar: ");
        IO.println("1. Realizar una venta");
        IO.println("2. Realizar una devolución");
        IO.println("3. Producto más vendido");
        IO.println("4. Los empleados más vendidos");
    }

    public static void opcionesDatosTienda() {
        System.out.println("Escoja la operación a realizar");
        IO.println("1. Juguetes disponibles");
        IO.println("2. Ventas realizados en un mes");
        IO.println("3. Ventas realizados por un empleado en un mes");
        IO.println("4. Cambios de los empleados y motivos");
        IO.println("5. Juguetes ordenados por precio");
    }
}
