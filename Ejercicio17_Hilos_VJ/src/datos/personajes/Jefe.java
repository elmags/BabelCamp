package datos.personajes;

import datos.armas.Arma;

public class Jefe extends Personaje {
	
	private boolean death;

	public Jefe() {
		setTipo("Jefe");
		setVida(500);
		this.death = false;
	}
	@Override
	public int atacar(Arma arma, Personaje p) {
		p.setVida(p.getVida() - 50);
		return 50;
	}
	public boolean isDeath() {
		return death;
	}
	public void setDeath(boolean death) {
		this.death = death;
	}
}
