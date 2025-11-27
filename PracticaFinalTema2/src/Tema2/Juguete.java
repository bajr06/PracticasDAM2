package Tema2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Juguete {
	private static String [] columnas = {"Nombre", "Descripcion", "Precio", "Cantidad_Stock"};

	public static void nuevoJuguete(Connection conexion) {
		String nuevoJuguete = "insert into Juguete (Nombre, Descripcion, Precio, Cantidad_Stock) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(nuevoJuguete, Statement.RETURN_GENERATED_KEYS);

			Principal.sc.nextLine();
			ps.setString(1, Principal.sc.nextLine());
			ps.setString(2, Principal.sc.nextLine());
			ps.setFloat(3, Principal.sc.nextFloat());
			ps.setInt(4, Principal.sc.nextInt());

			int rs = ps.executeUpdate();

			if(rs == 0) {
				System.err.println("Ha ocurrido un problema grave.");
				System.exit(rs);
			} else {
				System.out.println("Se ha añadido correctamente el jueguete");
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static List<Object> modificacion(int tipoCambio) {
		List<Object> respuesta = new ArrayList<>();

		System.out.println("Introduzca el ID del juguete: ");
		respuesta.add(Principal.sc.nextInt());

		System.out.println("Introduce el nuevo dato: ");
		Principal.sc.nextLine();

		if(tipoCambio == 0 || tipoCambio == 1) {
			respuesta.add(Principal.sc.nextLine());
		} else if(tipoCambio == 2) {
			respuesta.add(Principal.sc.nextFloat());
		} else if(tipoCambio == 3) {
			respuesta.add(Principal.sc.nextInt());
		}

		return respuesta;
	}

	public static void modificarJuguete(Connection conexion) {
		int seleccion = Opciones.modificarJuguete();
		List<Object> cambios = modificacion(seleccion);

		String modificarJuguete = "update Juguete set " + columnas[seleccion] + " = \"" + cambios.get(1) + "\" where ID_Juguete = ?";

		try {
			PreparedStatement ps = conexion.prepareStatement(modificarJuguete);

			ps.setObject(1, cambios.get(0));

			int rs = ps.executeUpdate();
			
			if(rs <= 0) {
				System.err.println("Ha ocurrido un problema grave.");
				System.exit(rs);
			} else {
				System.out.println("Se ha modificado correctamente el jueguete");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void eliminarJuguete(Connection conexion) {
		String eliminarJuguete = "delete from Juguete where ID_Juguete = ?";

		try {
			PreparedStatement ps = conexion.prepareStatement(eliminarJuguete);

			ps.setInt(1, Principal.sc.nextInt());

			int rs = ps.executeUpdate();

			if(rs == 0) {
				System.err.println("Ha ocurrido un problema grave.");
				System.exit(rs);
			} else {
				System.out.println("Se ha eliminado correctamente el jueguete");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
