package datos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Directivo extends Empleado {

	private List<Empleado> empleados = new ArrayList<>();
	
	public Directivo() { }

	@Override
	public int calcular_sueldo(int sueldo_base) {
		return sueldo_base + empleados.size()*100;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Empleado... empleado) {
		for (int i = 0; i < empleado.length; i++) {
			empleados.add(empleado[i]);
		}
	}	
	
	@Override
	public String toString() {
		String str = "Directivo [nombre=" + getNombre() + ", sueldo_base=" + getSueldo_base() + ", empleados= \n		{\n";
		for (Empleado e : empleados) {
			if (e instanceof Trabajador) str += "		 Trabajador [nombre= " + e.getNombre() + ", sueldo_base= " + e.getSueldo_base() +
												", valoracion= " + ((Trabajador) e).getValoracion() + "]\n";
			else if (e instanceof Jefe) str += "		 Jefe [nombre= " + getNombre() + ", sueldo base= " + getSueldo_base() +
											   ", incentivos= " + Arrays.toString(((Jefe) e).getIncentivos()) + "]\n";
			else if (e instanceof Directivo) str += toString();
		}
		return  str + "		}\n          ]";
	}
}
