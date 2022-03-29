package datos;

public abstract class Empleado {
	
	private String nombre;
	private int sueldo_base;

	public abstract int calcular_sueldo(int sueldo_base);
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSueldo_base() {
		return sueldo_base;
	}

	public void setSueldo_base(int sueldo_base) {
		this.sueldo_base = sueldo_base;
	}
}
