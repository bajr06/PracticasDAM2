package Final12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Operaciones {
	private static File ficheroUsuario =  new File("PracticaFinalTema3\\\\src\\\\Usuarios.txt");

	public static String prueba(String periodico, String seccionTitular) throws IOException {
		Document document = Jsoup.connect(periodico).get();
		Element titular = document.select(seccionTitular).get(0);
		
		return (1) + ". " + titular.text();
	}

	public static void escribirUsuario(Usuario nuevoUsuario) throws IOException {
		BufferedWriter pw = new BufferedWriter(new FileWriter(ficheroUsuario, true));
		
		pw.newLine();
		pw.write(nuevoUsuario.getIdUsuario() + ";" + nuevoUsuario.getNombreUsuario() + ";" + nuevoUsuario.getContrasenia() + ";" + nuevoUsuario.getCorreoElectronico() + ";" + nuevoUsuario.isPrimeraVez() + ";" + nuevoUsuario.getTu());

		pw.close();
	}

	public static void borrarUsuario(Usuario usuarioBorrar, int idUsuarioBorrar) throws IOException {
		BufferedReader pr = new BufferedReader(new FileReader(ficheroUsuario));
		BufferedWriter pw = new BufferedWriter(new FileWriter(ficheroUsuario));

		String linea;
		String [] datos;
		int idUsuario;

		while((linea = pr.readLine()) != null) {
			datos = linea.split(";");

			IO.println(datos.toString());
/*
			if(idUsuario == idUsuarioBorrar) {
				pw.write(linea);
				pw.newLine();
			}
*/
		}

		pr.close();
		pw.close();
	}
}

