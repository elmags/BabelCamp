package datos.personajes;

import datos.armas.Arma;

public abstract class Personaje {
	
	private Arma arma;
	private String nombre;
	private int vida;
	private String tipo;
	
	public Personaje () {
		this.vida = 100;
		if (this instanceof Mago) {
			this.tipo = "Mago";
		}
		else if (this instanceof Guerrero) {
			this.tipo = "Guerrero";
		}
		else if (this instanceof Curandero) {
			this.tipo = "Curandero";
		}
		else if (this instanceof Jefe) {
			this.tipo = "Jefe";
		}
	}
	
	public abstract int atacar(Arma arma, Personaje p);

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
