package datos.armas;

public class Arco extends Arma {

	public Arco () {
		setTipo("Arco");
	}
	
	@Override
	public void usar() {
		setDa�o((int)(Math.random()*6+12) * critico());
	}
	
}
