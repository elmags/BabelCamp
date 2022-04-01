package datos.personajes;

import datos.armas.*;

public class Mago extends Personaje{
	
	private int inteligencia;
	
	public Mago () {
		this.inteligencia = 5;
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
			da�o_real = arma.getDa�o() + this.inteligencia;
		}
		else if (arma instanceof Rezo) {
			da�o_real = arma.getDa�o();
		}
		
		if (p instanceof Guerrero && p.getArma() instanceof Espada)
			((Guerrero) p).setBloqueado(false);
			if(Math.random() <= 0.35) {
				((Guerrero) p).setBloqueado(true);
				return 0;
			}
		
		p.setVida(p.getVida() - da�o_real);
		return da�o_real;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
}
