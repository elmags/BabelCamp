package datos.personajes;

import datos.armas.*;

public class Mago extends Personaje{
	
	private int inteligencia;
	private int carga;
	
	public Mago () {
		this.inteligencia = 5;
		this.carga = 0;
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
			if (getCarga() < 100) {
				setCarga(getCarga() + 40);
				System.out.println("Cada vez que el pesonaje " + getNombre() + " utiliza " + getArma().getTipo() + 
						" por ser " + getTipo() + " carga 40 puntos");
				System.out.println("La barra est� cargada al " + getCarga() + "%");
			}
			else {
				System.out.println("La barra est� cargada al " + getCarga() + "%, el personaje " + getNombre() + " hace 20 extra de da�o");
				da�o_real += 15;
				setCarga(0);
			}
			
		}
		else if (arma instanceof Rezo) {
			da�o_real = arma.getDa�o();
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

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}
}
