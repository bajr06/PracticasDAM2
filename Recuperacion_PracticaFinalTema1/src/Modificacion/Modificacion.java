package Modificacion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import Objetos.Empleado;
import Objetos.Planta;

public class Modificacion {
	public static void modificarPlantasXML(File fichero,ArrayList<Planta> plantas) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));

		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		bw.newLine();

		bw.write("<plantas>");
		bw.newLine();

		for(int i = 0; i < plantas.size(); i++) {
			bw.write("\t<planta>");
			bw.newLine();

			bw.write("\t\t<codigo>" + plantas.get(i).getCodigo() + "</codigo>");
			bw.newLine();

			bw.write("\t\t<nombre>" + plantas.get(i).getNombre() + "</nombre>");
			bw.newLine();

			bw.write("\t\t<foto>" + plantas.get(i).getFoto() + "</foto>");
			bw.newLine();

			bw.write("\t\t<descripcion>" + plantas.get(i).getDescripcion() + "</descripcion>");
			bw.newLine();

			bw.write("\t</planta>");
			bw.newLine();
		}
			
		bw.write("</plantas>");

		bw.close();
	}

	public static void modificarPlantasDAT(File fichero, ArrayList<Planta> plantas) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(fichero, "r");
		
		for(int i = 0; i < plantas.size(); i++) {
			raf.writeFloat(plantas.get(i).getPrecio());
			raf.writeInt(plantas.get(i).getCantidad());
		}

		raf.close();
	}

	public static void modificarEmpleadoDAT(File fichero, ArrayList<Empleado> empleados) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
		
		oos.writeObject(empleados);

		oos.close();
	}
}
