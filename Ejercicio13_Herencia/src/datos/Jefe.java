package datos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jefe extends Empleado {
	
	private int[] incentivos;
	
	public Jefe() {
	}

	@Override
	public int calcular_sueldo(int sueldo_base) {
		int suma_incentivos = 0;
		for (int i = 0; i < incentivos.length; i++) 
			suma_incentivos += incentivos[i];
		return sueldo_base + suma_incentivos;
	}

	public int[] getIncentivos() {
		return incentivos;
	}

	public void setIncentivos(int... incentivo) {
		int index = 0;
		
		if (incentivos != null) 
			index = this.incentivos.length;
		else incentivos = new int[incentivo.length];
		
		for (int i = 0; i < incentivo.length; i++) {
			incentivos[index] = incentivo[i];
			index++;
		}
	}

	@Override
	public String toString() {
		return "Jefe [nombre= " + getNombre() + ", sueldo base= " + getSueldo_base() +
				", incentivos= " + Arrays.toString(incentivos) + "]";
	}
}
