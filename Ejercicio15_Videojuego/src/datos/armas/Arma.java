package datos.armas;

public abstract class Arma {

	private int daño;
	private String tipo;
	
	protected int critico () {
		double rand = Math.random();
		if (rand <= 0.05) return 2;
		return 1;
	}
	
	public abstract void usar();

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
