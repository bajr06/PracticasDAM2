package Final12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VerificacionLecturaFicheros {
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

	public static void LecturaUsuarios() throws IOException {
		File fichero = new File("PracticaFinalTema3\\src\\Usuarios.txt");
		String linea;
		String [] datos;
		List<Usuario> lista = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(fichero));

		while((linea = br.readLine()) != null) {
			datos = linea.split(";");
								
			Usuario usuario = new Usuario(TipoUsuario.valueOf(datos[0]), datos[1], datos[2], datos[3], Boolean.valueOf(datos[4]));	
			lista.add(usuario);

			// IO.println(usuario.toString());
		}

		br.close();
	}

	public static void LecturaPeriodicos() throws IOException {
		File fichero = new File("PracticaFinalTema3/src/Periodicos.txt");
		String linea;
		String [] datos;
		List<Periodicos> lista = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(fichero));

		while((linea = br.readLine()) != null) {
			datos = linea.split(";");
				
			Periodicos periodico = new Periodicos(Integer.parseInt(datos[0]), datos[1], datos[2], TipoNoticia.valueOf(datos[3]));
			lista.add(periodico);

			// IO.println(periodico.toString());
		}

		br.close();
	}
}
