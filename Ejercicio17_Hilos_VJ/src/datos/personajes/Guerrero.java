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
		int da�o_real = 0;
		if (arma instanceof Espada) {
			da�o_real = arma.getDa�o() + this.fuerza;
		}
		else if (arma instanceof Arco) {
			da�o_real = arma.getDa�o();
			// Probabilidad del 20% de lanzar 2 flechas
			if(Math.random() <= 0.2) {
				System.out.println("El personaje " + getNombre() + " utiliza 2 flechas. Hace el doble de da�o");
				da�o_real *= 2;
			}
			da�o_real += this.fuerza;
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

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
}
