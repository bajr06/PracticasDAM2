package Final12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManejoFicheros {
	private static String [] nombreFicheros = {"PracticaFinalTema3/src/Usuarios.txt", "PracticaFinalTema3/src/Periodicos.txt", "PracticaFinalTema3/src/Historico.txt"};

	public static boolean verificacionExistencia() {
		int existencia = 0;
		for(int i = 0; i < nombreFicheros.length; i++) {
			File fichero = new File(nombreFicheros[i]);

			if(fichero.exists()) {
				existencia++;
			} else {
				existencia--;
			}
		}

		if(existencia == nombreFicheros.length) {
			return true;
		} else {
			return false;
		}
	}

	public static List<String []> lectura(String rutaFichero) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(rutaFichero));
		String [] datos;
		List<String []> datosGuardados = new ArrayList<>();
		String linea;		

		while((linea = br.readLine()) != null) {
			datos = linea.split(";");
			datosGuardados.add(datos);
		}
		br.close();

		return datosGuardados;
	}

	public static List<Usuario> lecturaUsuarios() throws IOException {
		File fichero = new File("PracticaFinalTema3//src//Usuarios.txt");
		String linea;
		String [] datos;
		List<Usuario> lista = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(fichero));

		while((linea = br.readLine()) != null) {
			datos = linea.split(";");

			Usuario usuario = new Usuario(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], Boolean.valueOf(datos[4]), TipoUsuario.valueOf(datos[5]));	
			lista.add(usuario);
		}

		br.close();

		return lista;
	}

	public static List<Periodico> lecturaPeriodicos() throws IOException {
		File fichero = new File("PracticaFinalTema3/src/Periodicos.txt");
		String linea;
		String [] datos;
		List<Periodico> lista = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		Periodico periodico;

		while((linea = br.readLine()) != null) {
			datos = linea.split(";");
			periodico = new Periodico(Integer.parseInt(datos[0]), datos[1], datos[2], TipoNoticia.valueOf(datos[3]));

			lista.add(periodico);
		}

		br.close();

		return lista;
	}
}
