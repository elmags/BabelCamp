package modelo.datos;

/*
 * Esta clase ayuda a la creación del JSON que devuelve el servicio REST 
 */

public class Validado {
	private boolean validado;
	
	public Validado( ) {
		this.validado = false;
	}

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	
	
}
