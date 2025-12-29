package Carga;

import java.io.File;
import java.io.IOException;

public class Comprobacion {
	private static boolean comprobacionExistenciaDirectorio(File fichero) throws IOException {
		boolean creacion = false;

		if(!fichero.exists()) {
			creacion = fichero.mkdir();
		}

		return creacion;
	}
	public static File comprobacionExistenciaFichero(File fichero) throws IOException {
		if(!fichero.exists() && comprobacionExistenciaDirectorio(fichero)) {
			fichero.createNewFile();

			System.out.println("Directorio o Fichero nuevo: Peligro de error.");
		}

		return fichero;
	}
}
