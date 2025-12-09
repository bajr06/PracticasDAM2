package Final12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerificacionFicheros {
	private static String [] nombreFicheros = {"Usuarios.txt", "Periodicos.txt"};

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

	public static void LecturaFicheros () {
		File fichero = new File("PracticaFinalTema3\\src\\Usuarios.txt");
		String linea;
		String [] datos;
		List<Usuario> lista = new ArrayList<>();

		try(BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			while((linea = br.readLine()) != null) {
				datos = linea.split(";");
				System.out.println(Arrays.asList(datos));
				
				Usuario usuario = new Usuario(TipoUsuario.valueOf(datos[0]), datos[1], datos[2], datos[3], Boolean.valueOf(datos[4]));	
				lista.add(usuario);
			}

			br.close();
		} catch (IOException ioe) {
			
		}
	}
}
