package Acciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AccionesGenerales {
	public static void leerFichero(File ficheroALeer) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(ficheroALeer));
		String linea;

		IO.println();
		while((linea = br.readLine()) != null) {
			System.out.println(linea);
		}

		br.close();
	}
}