package datos.armas;

public class Espada extends Arma {
	
	public Espada () {
		setTipo("Espada");
	}
	
	@Override
	public void usar() {
		setDaño((int)(Math.random()*6+15) * critico());
	}

}
