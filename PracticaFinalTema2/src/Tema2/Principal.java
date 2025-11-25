package Tema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
	static Scanner entrada = new Scanner(System.in);

	protected static Connection conexion() {
		String url = "jdbc:mysql://localhost:3306/jugueteria";
		String usuario = "root";
		String contrasenia = "songoku";
		Connection conexion = null; 

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, contrasenia);
		} catch(ClassNotFoundException | SQLException cnfsqle) {
			cnfsqle.printStackTrace();
		}

		return conexion;
	}

	public static void main(String[] args) {
		Comprobacion.comprobarTablas();

		System.out.println("Bienvenido a la CRM de la jugetería \"Juguetón\".");
		Opciones.opciones();
	}
}
