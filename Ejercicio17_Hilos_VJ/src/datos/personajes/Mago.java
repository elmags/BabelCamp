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
		int daño_real = 0;
		if (arma instanceof Espada) {
			daño_real = arma.getDaño();
		}
		else if (arma instanceof Arco) {
			daño_real = arma.getDaño();
		}
		else if (arma instanceof Hechizo) {
			daño_real = arma.getDaño() + this.inteligencia;
			if (getCarga() < 100) {
				setCarga(getCarga() + 40);
				System.out.println("Cada vez que el pesonaje " + getNombre() + " utiliza " + getArma().getTipo() + 
						" por ser " + getTipo() + " carga 40 puntos");
				System.out.println("La barra está cargada al " + getCarga() + "%");
			}
			else {
				System.out.println("La barra está cargada al " + getCarga() + "%, el personaje " + getNombre() + " hace 20 extra de daño");
				daño_real += 15;
				setCarga(0);
			}
			
		}
		else if (arma instanceof Rezo) {
			daño_real = arma.getDaño();
		}
		
		if ((p.getArma() instanceof Espada) && (p instanceof Guerrero)) {
			((Guerrero) p).setBloqueado(false);
			if(Math.random() <= 0.35) {
				((Guerrero) p).setBloqueado(true);
				return 0;
			}
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

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}
}
