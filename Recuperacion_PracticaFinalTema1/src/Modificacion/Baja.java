package Modificacion;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import Objetos.Planta;

public class Baja {
	public static void comprobarFicherosBaja() {
		File [] ficherosBaja = {
			new File("Recuperacion_PracticaFinalTema1/src/FicherosBaja/empleadosBaja.dat"),
			new File("Recuperacion_PracticaFinalTema1/src/FicherosBaja/plantasBaja.dat")
		};

		try {
			for(File f: ficherosBaja) {
				if(!f.exists()) {
					f.createNewFile();
				}
			}
		} catch(IOException ioe) {
			System.err.println("Error en la creación del fichero\nCerrando programa\n");
			System.exit(1);
		}
	}

	public static void darBajaPlantas(ArrayList<Planta> plantas) {
		comprobarFicherosBaja();

		try(RandomAccessFile raf = new RandomAccessFile("Recuperacion_PracticaFinalTema1/src/FicherosBaja/plantasBaja.dat", "rw")) {
			for (int i = 0; i < plantas.size(); i++) {
				if(plantas.get(i).getCantidad() == 0) {
					raf.writeInt(plantas.get(i).getCodigo());
					raf.writeFloat(plantas.get(i).getPrecio());

					plantas.get(i).setPrecio(0);
				}
		}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
}
