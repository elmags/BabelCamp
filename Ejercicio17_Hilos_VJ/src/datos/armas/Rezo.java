package datos.armas;

public class Rezo extends Arma {
	
	public Rezo () {
		setTipo("Rezo");
	}
	
	@Override
	public void usar() {
		setDa�o((int)(Math.random()*10+12) * critico());
	}
	
	
}
