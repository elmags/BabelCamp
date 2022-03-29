package datos;

public class Trabajador extends Empleado {

	private int valoracion;
	
	public Trabajador() { }

	@Override
	public int calcular_sueldo(int sueldo_base) {
		int sueldo_final = 0;
		if (valoracion >=0 && valoracion <= 4)
			sueldo_final = sueldo_base;
		else if (valoracion >= 5 && valoracion <= 6)
			sueldo_final = sueldo_base + 50;
		else if (valoracion >= 7 && valoracion <= 8)
			sueldo_final = sueldo_base + 100;
		else if (valoracion >= 9 && valoracion <= 10)
			sueldo_final = sueldo_base + 200;
		return sueldo_final;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	@Override
	public String toString() {
		return "Trabajador [nombre= " + getNombre() + ", sueldo base= " + getSueldo_base() + 
			   ", valoracion= " + valoracion + "]";
	}
}
