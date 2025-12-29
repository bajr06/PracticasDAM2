package Carga;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Carga {
	public static ArrayList<Planta> cargaPlantasXML() {
		File ficheroXML = new File("Recuperacion_PracticaFinalTema1/src/FicherosCarga/plantas.xml");
		ArrayList<Planta> plantas = new ArrayList<>();

		try {
			Comprobacion.comprobacionExistenciaFichero(ficheroXML);
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder docB = dbf.newDocumentBuilder();
			Document doc = docB.parse(ficheroXML);

			doc.getDocumentElement().normalize();

			NodeList lista = doc.getElementsByTagName("planta");
			int cantidad = lista.getLength();

			for(int i = 0; i < cantidad; i++) {
				Node nodo = lista.item(i);

				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element planta = (Element) nodo;
					int codigo = Integer.parseInt(planta.getElementsByTagName("codigo").item(0).getTextContent());
					String nombre = planta.getElementsByTagName("nombre").item(0).getTextContent();
					String foto = planta.getElementsByTagName("foto").item(0).getTextContent();
					String descripcion = planta.getElementsByTagName("descripcion").item(0).getTextContent();

					plantas.add(new Planta(codigo, nombre, foto, descripcion));
				} else {
					IO.println("No se ha encontrado nada.");
				}
			}
		} catch(ParserConfigurationException | SAXException | IOException pcsaxioe) {
			pcsaxioe.printStackTrace();
		}

		return plantas;
	}

	public static void cargaPlantasDAT(ArrayList<Planta> plantas) {
		File ficheroDAT = new File("Recuperacion_PracticaFinalTema1/src/FicherosCarga/plantas.dat");

		try(RandomAccessFile raf = new RandomAccessFile(ficheroDAT, "r");) {
			Comprobacion.comprobacionExistenciaFichero(ficheroDAT);

			int posicion = 0;
			
			while(raf.getFilePointer() < raf.length()) {
				if(raf.readInt() == plantas.get(posicion).getCodigo()) {
					plantas.get(posicion).setPrecio(raf.readFloat());
					plantas.get(posicion).setCantidad(raf.readInt());;
				}

				posicion++;
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} 
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Empleado> cargaEmpleadosDAT() {
		File ficheroDAT = new File("Recuperacion_PracticaFinalTema1/src/FicherosCarga/empleados.dat");
		ArrayList<Empleado> empleados = new ArrayList<>();

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroDAT))) {
			Comprobacion.comprobacionExistenciaFichero(ficheroDAT);

			empleados = (ArrayList<Empleado>) ois.readObject();

		} catch (IOException | ClassNotFoundException iocnfe) {
			iocnfe.printStackTrace();
		}

		return empleados;
	}
}
