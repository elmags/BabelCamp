package main;

import datos.Trabajador;
import datos.Jefe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datos.Directivo;
import datos.Empleado;

public class MainEmpleado {

	public static void main(String[] args) {
		
		List<Empleado> empleados = new ArrayList<>();
		
		Directivo d = new Directivo();
		d.setNombre("Directivo");
		d.setSueldo_base(1750);
		
		Trabajador t1 = new Trabajador();
		t1.setNombre("Trabajador 1");
		t1.setSueldo_base(500);
		t1.setValoracion(3);
		empleados.add(t1);
		
		d.setEmpleados(t1);
		
		t1 = new Trabajador();
		t1.setNombre("Trabajador 2");
		t1.setSueldo_base(750);
		t1.setValoracion(7);
		empleados.add(t1);
		
		t1 = new Trabajador();
		t1.setNombre("Trabajador 3");
		t1.setSueldo_base(1000);
		t1.setValoracion(9);
		empleados.add(t1);
		
		Jefe j1 = new Jefe();
		j1.setNombre("Jefe 1");
		j1.setSueldo_base(1250);
		j1.setIncentivos(200);
		empleados.add(j1);
		
		d.setEmpleados(t1, j1);
		empleados.add(d);
		
		j1 = new Jefe();
		j1.setNombre("Jefe 2");
		j1.setSueldo_base(1500);
		j1.setIncentivos(200, 300, 400);
		empleados.add(j1);
		
		Map<Integer, Integer> sueldos_finales = new HashMap<Integer, Integer>(); 
		int index = 0;
		for (Empleado e : empleados) {
			int sueldo_final = 0;
			if (e instanceof Trabajador) 
				sueldo_final = ((Trabajador)e).calcular_sueldo(e.getSueldo_base());
			else if (e instanceof Jefe) 
				sueldo_final = ((Jefe)e).calcular_sueldo(e.getSueldo_base());
			else if (e instanceof Directivo) 
				sueldo_final = ((Directivo)e).calcular_sueldo(e.getSueldo_base());
			sueldos_finales.put(index++, sueldo_final);
		}
		
		System.out.println("------------------------------------- Empleados -------------------------------------\n");
		for(int i = 0; i < empleados.size(); i++) {
			System.out.println(empleados.get(i).toString() + 
					" El sueldo final de " + empleados.get(i).getNombre() + " es de: " +
					sueldos_finales.get(i));
		}
	}

}
