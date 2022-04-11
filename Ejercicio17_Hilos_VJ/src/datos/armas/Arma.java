package datos.armas;

public abstract class Arma {

	private int da�o;
	private String tipo;
	
	protected int critico () {
		double rand = Math.random();
		if (rand <= 0.05) return 2;
		return 1;
	}
	
	public abstract void usar();

	public int getDa�o() {
		return da�o;
	}

	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
