package main;

import datos.armas.*;
import datos.batalla.Batalla;
import datos.personajes.*;

public class MainVJ {

	public static void main(String[] args) {
		
		Personaje p1 = pers_rand();
		p1.setNombre("P1");
		p1.setArma(arma_rand());
		
		Personaje p2 = pers_rand();
		p2.setNombre("P2");
		p2.setArma(arma_rand());
		
		System.out.println("*************** BATALLA ***************");
		System.out.println("Personaje 1: " + p1.getNombre() + " es " + p1.getTipo() + " tiene " + p1.getArma().getTipo());
		System.out.println("Personaje 2: " + p2.getNombre() + " es " + p2.getTipo() + " tiene " + p2.getArma().getTipo() + "\n");
		
		new Batalla(p1, p2);		
	}
	
	private static Personaje pers_rand () {
		int rand = (int)(Math.random()*3+1);
		if (rand == 1) return new Mago();
		else if (rand == 2)	return new Guerrero();
		else return new Curandero();
	}
	
	private static Arma arma_rand () {
		int rand = (int)(Math.random()*4+1);
		if (rand == 1) return new Espada();
		else if (rand == 2)	return new Arco();
		else if (rand == 3) return new Hechizo();
		else return new Rezo();
	}
}
