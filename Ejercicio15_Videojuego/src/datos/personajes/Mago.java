package datos.personajes;

import datos.armas.*;

public class Mago extends Personaje{
	
	private int inteligencia;
	
	public Mago () {
		this.inteligencia = 5;
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
			daño_real = arma.getDaño() + this.inteligencia;
		}
		else if (arma instanceof Rezo) {
			daño_real = arma.getDaño();
		}
		p.setVida(p.getVida() - daño_real);
		return daño_real;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
}
