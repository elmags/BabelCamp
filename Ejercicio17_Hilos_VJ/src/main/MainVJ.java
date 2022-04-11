package main;

import datos.armas.*;
import datos.fortaleza.Fortaleza;
import datos.personajes.Curandero;
import datos.personajes.Guerrero;
import datos.personajes.Jefe;
import datos.personajes.Mago;
import datos.personajes.Personaje;
import thread.TPersonaje;

public class MainVJ {

	private static int i;

	public static void main(String[] args) {
		
		/*
		 * Preguntar cuantos personajes se quieren crear y crearlos mediante un array de threads,
		 * cuando el jefe está muerto no entran los personajes a la fortaleza.
		 * 
		 * Habilidades jefe
		 */
		
		System.out.println("*************** FORTALEZA ***************");
//		System.out.println("Jefe: " + jefe.getNombre());
		Fortaleza f = new Fortaleza();
		
		Personaje p = pers_rand();
		p.setNombre("P1");
		p.setArma(arma_rand());
		Runnable p1 = new TPersonaje(p, f);
		
		p = pers_rand();
		p.setNombre("P2");
		p.setArma(arma_rand());
		Runnable p2 = new TPersonaje(p, f);
		
		p = pers_rand();
		p.setNombre("P3");
		p.setArma(arma_rand());
		Runnable p3 = new TPersonaje(p, f);
		
		p = pers_rand();
		p.setNombre("P4");
		p.setArma(arma_rand());
		Runnable p4 = new TPersonaje(p, f);
		
		p = pers_rand();
		p.setNombre("P5");
		p.setArma(arma_rand());
		Runnable p5 = new TPersonaje(p, f);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		Thread t4 = new Thread(p4);
		Thread t5 = new Thread(p5);
		
		t1.setName("Thread1");
		t2.setName("Thread2");
		t3.setName("Thread3");
		t4.setName("Thread4");
		t5.setName("Thread5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

//		System.out.println("*************** BATALLA ***************");
//		System.out.println("Personaje 1: " + p1.getNombre() + " es " + p1.getTipo() + " tiene " + p1.getArma().getTipo());
//		System.out.println("Personaje 2: " + p2.getNombre() + " es " + p2.getTipo() + " tiene " + p2.getArma().getTipo() + "\n");
//		
//		new Batalla(p1, p2);	
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
	
	private static Jefe crear_jefe() {
		Jefe jefe = new Jefe();
		jefe.setNombre("Jefe");
		jefe.setArma(null);
		return jefe;
	}
}
