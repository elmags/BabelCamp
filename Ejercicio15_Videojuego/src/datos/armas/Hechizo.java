package datos.armas;

public class Hechizo extends Arma {
	
	public Hechizo () {
		setTipo("Hechizo");
	}
	
	@Override
	public void usar() {
		setDaño((int)(Math.random()*8+16) * critico());
	}
	
	
}
