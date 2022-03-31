package datos.personajes;

import datos.armas.Arco;
import datos.armas.Arma;
import datos.armas.Espada;
import datos.armas.Hechizo;
import datos.armas.Rezo;

public class Curandero extends Personaje {

	private int sabiduria;
	
	public Curandero () {
		this.sabiduria = 5;
	}
	
	@Override
	public int atacar(Arma arma, Personaje p) {
		int daño_real = 0;
		if (arma instanceof Espada) {
			daño_real = arma.getDaño();
		}
		else if (arma instanceof Arco) {
			daño_real = arma.getDaño();
		}
		else if (arma instanceof Hechizo) {
			daño_real = arma.getDaño();
		}
		else if (arma instanceof Rezo) {
			daño_real = arma.getDaño() + this.sabiduria;
		}
		p.setVida(p.getVida() - daño_real);
		return daño_real;
	}

	public int getSabiduria() {
		return sabiduria;
	}

	public void setSabiduria(int sabiduria) {
		this.sabiduria = sabiduria;
	}
}
