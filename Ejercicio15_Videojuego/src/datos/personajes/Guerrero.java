package datos.personajes;

import datos.armas.Arco;
import datos.armas.Arma;
import datos.armas.Espada;
import datos.armas.Hechizo;
import datos.armas.Rezo;

public class Guerrero extends Personaje {

	private int fuerza;
	private boolean bloqueado;
	
	public Guerrero () {
		this.fuerza = 5;
		this.bloqueado = false;
	}
	
	@Override
	public int atacar(Arma arma, Personaje p) {
		int daño_real = 0;
		if (arma instanceof Espada) {
			daño_real = arma.getDaño() + this.fuerza;
			if(Math.random() <= 1) this.bloqueado = true;
		}
		else if (arma instanceof Arco) {
			daño_real = arma.getDaño() + this.fuerza;
		}
		else if (arma instanceof Hechizo) {
			daño_real = arma.getDaño();
		}
		else if (arma instanceof Rezo) {
			daño_real = arma.getDaño();
		}
		p.setVida(p.getVida() - daño_real);
		return daño_real;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
}
