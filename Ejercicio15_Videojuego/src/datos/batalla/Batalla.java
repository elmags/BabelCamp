package datos.batalla;

import datos.personajes.*;

public class Batalla {

	public Batalla (Personaje p1, Personaje p2) {
		start(p1, p2);
	}
	
	/* Especiales
	
	Espada: Probabilidad del 35% de bloquear el ataque y no recibir daño
	Arco: Probabilidad del 20% de lanzar 2 flechas -> daño*2
	Hechizo: Cada vez que golpea, carga 40 de una barra de 100, cuando carga >= 100 -> daño + 15
	Rezo: Cada vez que se utiliza cura al personaje 
	
	*/
	
	private void start(Personaje p1, Personaje p2) {
		int i = 1;
		while(p1.getVida() > 0 && p2.getVida() > 0) {
			System.out.println("----------------- RONDA " + i++ + " -----------------");
			
			System.out.println("El personaje " + p1.getNombre() + " ataca al personaje " + p2.getNombre() + 
					" con " + p1.getArma().getTipo());
			p1.getArma().usar();
			int daño_p1 = p1.atacar(p1.getArma(), p2);
			bloquear(p2);
			
			System.out.println("El personaje " + p1.getNombre() + " hace " + daño_p1 + 
						" puntos de daño");
			System.out.println("El personaje " + p2.getNombre() + " tiene " + p2.getVida() + " puntos de vida\n");
			
			System.out.println("El personaje " + p2.getNombre() + " ataca al personaje " + p1.getNombre() + 
					" con " + p2.getArma().getTipo());
			p2.getArma().usar();
			int daño_p2 = p2.atacar(p2.getArma(), p1);
			bloquear(p1);
			
			System.out.println("El personaje " + p2.getNombre() + " hace " + daño_p2 + 
					" puntos de daño");
			System.out.println("El pesonaje " + p1.getNombre() + " tiene " + p1.getVida() + " puntos de vida\n");
		}
		Personaje v = p1.getVida() > 0 ? p1 : p2;
		if (p1.getVida() <= 0 && p2.getVida() <= 0) v = p1;
		System.out.println("La batalla ha finalizado y el vencedor ha sido " + v.getNombre());
	}
	
	private void bloquear (Personaje p) {
		if (p instanceof Guerrero) 
			if (((Guerrero) p).isBloqueado()) 
				System.out.println("El personaje " + p.getNombre() + " se ha defendido y no pierde vida");
	}
}
