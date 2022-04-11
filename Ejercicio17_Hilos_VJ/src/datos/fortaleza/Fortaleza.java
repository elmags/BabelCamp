package datos.fortaleza;

import datos.armas.Espada;
import datos.batalla.Batalla;
import datos.personajes.*;
import thread.TPersonaje;

public class Fortaleza {
	
	private Jefe jefe;

	public Fortaleza() {
		jefe = new Jefe();
		jefe.setNombre("Jefe");
		jefe.setArma(new Espada());
		System.out.println("Jefe: " + jefe.getNombre());
	}
	
	public synchronized void entrar(Personaje p) {
		System.out.println("--> " + Thread.currentThread().getName() + ": El personaje " + p.getNombre() + " entra a la fortaleza\n");
		if (jefe.getVida() > 0)
			new Batalla(p, jefe);		
	}
	
	public int getVidaJefe() {
		return jefe.getVida();
	}	
}
