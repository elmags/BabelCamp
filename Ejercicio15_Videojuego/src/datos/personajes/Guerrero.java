package datos.personajes;

import datos.armas.Arco;
import datos.armas.Arma;
import datos.armas.Espada;
import datos.armas.Hechizo;
import datos.armas.Rezo;

public class Guerrero extends Personaje {

	private int fuerza;
	
	public Guerrero () {
		this.fuerza = 5;
	}
	
	@Override
	public int atacar(Arma arma, Personaje p) {
		int da�o_real = 0;
		if (arma instanceof Espada) {
			da�o_real = arma.getDa�o() + this.fuerza;
		}
		else if (arma instanceof Arco) {
			da�o_real = arma.getDa�o() + this.fuerza;
		}
		else if (arma instanceof Hechizo) {
			da�o_real = arma.getDa�o();
		}
		else if (arma instanceof Rezo) {
			da�o_real = arma.getDa�o();
		}
		p.setVida(p.getVida() - da�o_real);
		return da�o_real;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
}
