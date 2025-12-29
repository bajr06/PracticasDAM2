package Principal;

import java.util.ArrayList;

import Carga.Carga;
import Carga.Empleado;
import Carga.Planta;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Planta> plantas = Carga.cargaPlantasXML(); // TODO Pendiente punto 1.4 del la rúbrica.
        ArrayList<Empleado> empleados = Carga.cargaEmpleadosDAT();

        Carga.cargaPlantasDAT(plantas);

        for(Empleado e: empleados) {
            IO.println(e.toString());
        }
    }
}
