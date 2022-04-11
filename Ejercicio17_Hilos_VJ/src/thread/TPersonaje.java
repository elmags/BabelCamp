package thread;

import datos.armas.Arco;
import datos.armas.Arma;
import datos.armas.Espada;
import datos.armas.Hechizo;
import datos.armas.Rezo;
import datos.fortaleza.Fortaleza;
import datos.personajes.*;

public class TPersonaje implements Runnable {
	
	private Personaje p;
	private int vida;
	private Fortaleza f;
	
	public TPersonaje (Personaje p, Fortaleza f) {
		this.p = p;
		this.f = f;
	}
	
	public void run() {		
		f.entrar(p);
	}
}
