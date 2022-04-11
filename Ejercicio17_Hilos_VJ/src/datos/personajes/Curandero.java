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
		int da�o_real = 0;
		if (arma instanceof Espada) {
			da�o_real = arma.getDa�o();
		}
		else if (arma instanceof Arco) {
			da�o_real = arma.getDa�o();
		}
		else if (arma instanceof Hechizo) {
			da�o_real = arma.getDa�o();
		}
		else if (arma instanceof Rezo) {
			da�o_real = arma.getDa�o() + this.sabiduria;
			setVida(getVida() + 5);
			System.out.println("El personaje " + getNombre() + " se ha curado 5 puntos de vida por ser " + 
					getTipo() + " y utilizar " + arma.getTipo() + ", ahora tiene " + getVida() + " puntos de vida");
		}
		
		if ((p.getArma() instanceof Espada) && (p instanceof Guerrero)) {
			((Guerrero) p).setBloqueado(false);
			if(Math.random() <= 0.35) {
				((Guerrero) p).setBloqueado(true);
				return 0;
			}
		}
		
		p.setVida(p.getVida() - da�o_real);
		return da�o_real;
	}

	public int getSabiduria() {
		return sabiduria;
	}

	public void setSabiduria(int sabiduria) {
		this.sabiduria = sabiduria;
	}
}
