import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Carga.Carga;
import Carga.Comprobacion;
import Carga.Empleado;
import Carga.Planta;
import Menus.MenuEmpleado;

public class Principal {
	public static void main(String[] args) {
		try {
			File [] ficheros = Comprobacion.comprobacionExistenciaFicheros();
			
			ArrayList<Planta> plantas = Carga.cargaPlantasXML(ficheros[1]);
			Carga.cargaPlantasDAT(plantas);

			ArrayList<Empleado> empleados = Carga.cargaEmpleadosDAT(ficheros[3]);
			Empleado tipoUsuario;

			do {
				tipoUsuario = Comprobacion.comprobacionCredenciales(empleados);
			} while(tipoUsuario == null);

			if(tipoUsuario.getCargo() == "vendedor") {
				MenuEmpleado.seleccionOpcionE();
			} else if(tipoUsuario.getCargo() == "gestor") {
				MenuGestor.seleccionOpcionG();

			}
		} catch(IOException ioe) {
			ioe.getMessage();
		}
	}
}
