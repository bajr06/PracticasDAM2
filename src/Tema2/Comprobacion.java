package Tema2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Comprobacion {
    private static boolean comprobarTabla(String tabla, String id) {
		String comprobacion = "Select * from " + tabla + " where ? = 1;";

		try {
			PreparedStatement ps = Principal.conexion().prepareStatement(comprobacion);
			ps.setString(1, id);

			ResultSet resultado = ps.executeQuery();

			if(resultado.next()) {
				return true;
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}

		return false;
	}

	public static void comprobarTablas() {
		String[] tablas = {"Cambio", "Empleado", "Juguete", "Stand", "Venta", "Zona"};

		for(int i = 0; i < tablas.length; i++) {
			System.out.println("¿La tabla " + tablas[i] + " presenta datos? " + comprobarTabla(tablas[i], "ID_" + tablas[i]));
		}
	}
}
