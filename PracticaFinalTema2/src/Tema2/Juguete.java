package Tema2;

import java.sql.PreparedStatement;
// import java.sql.ResultSet;
import java.sql.SQLException;

public class Juguete {
	public static void nuevoJuguete() {
		String nuevoJuguete = "Insert Into Juguete (Nombre, Descripcion, Precio, Cantidad, Categoria) Values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = Principal.conexion().prepareStatement(nuevoJuguete);

			ps.setString(1, Principal.entrada.nextLine());
			ps.setString(2, Principal.entrada.nextLine());
			ps.setFloat(3, Principal.entrada.nextFloat());
			ps.setInt(4, Principal.entrada.nextInt());
			ps.setString(5, Principal.entrada.nextLine());

			// int rs = ps.executeUpdate();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
