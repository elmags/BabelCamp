package negocio;

import datos.Coche;
import datos.Coches;
import peristencia.interfaces.DaoCoche;
import persistencia.DaoCocheMySql;

public class GestorCoche {

	private DaoCoche dc = new DaoCocheMySql();
	
	/* Muchas de estas cosas ya est�n controladas en la base de datos,
	 * pero tambien lo he hecho aqu�. */
	
	/**
	 * El m�todo da de alta un coche en una base de datos. Comprueba que
	 * la matr�cula tiene longitud 7 y no se encuentra ya insertada en la bbdd.
	 * El n�mero de kilometros no puede ser negativo.
	 * @param c -> Coche que se quiere dar de alta.
	 * @return 
	 * 			0 -> En caso de que el coche se cree con �xito.
	 * 			1 -> En caso de que la matr�cula ya se encuentre en la bbdd.
	 * 			2 -> En caso de no haberse podido establecer correctamente
	 * 				 la conexi�n con la bbdd.
	 * 			3 -> En caso de que la matr�cula del coche tenga una longitud
	 * 				 distinta de 7.
	 * 			4 -> En caso de que el n�mero de kilometros sea negativo.
	 */
	public int alta(Coche c) {
		if (c.getKm() < 0) return 4;
		String matricula = c.getMatricula();
		if (matricula.length() == 7) {
			Coches coches = dc.get();
			for (Coche coche : coches.getCoches())
				if (coche.getMatricula().equals(matricula))
					return 1;
			boolean creado = dc.alta(c);
			if (creado) return 0;
			else return 2;
		}
		return 3;
	}
	
	/**
	 * El m�todo da de baja un coche en una base de datos.
	 * @param id -> Identificador del coche que se quiere dar de baja.
	 * @return 
	 * 			true  -> En caso de que se haya podido establecer con �xito
	 * 				     la conexi�n con la bbdd y se haya dado de baja el coche.
	 * 			false -> En caso contrario.
	 */
	public boolean baja(int id) {
		boolean borrado = dc.baja(id);
		return borrado;
	}
	
	/**
	 * El m�todo modifica un coche de la bbdd. Comprueba que
	 * la matr�cula tiene longitud 7 y no se encuentra ya insertada en la bbdd.
	 * El n�mero de kilometros no puede ser negativo.
	 * @param c -> Coche que se quiere modificar.
	 * @return
	 * 			0 -> En caso de que el coche se modifique con �xito.
	 * 			1 -> En caso de que la matr�cula ya se encuentre en la bbdd.
	 * 			2 -> En caso de no haberse podido establecer correctamente
	 * 				 la conexi�n con la bbdd.
	 * 			3 -> En caso de que la matr�cula del coche tenga una longitud
	 * 				 distinta de 7.
	 * 			4 -> En caso de que el n�mero de kilometros sea negativo.
	 */
	public int modificar(Coche c) {
		if (c.getKm() < 0) return 4;
		String matricula = c.getMatricula();
		if (matricula.length() == 7) {
			Coches coches = dc.get();
			for (Coche coche : coches.getCoches())
				if (coche.getId() != c.getId() && coche.getMatricula().equals(matricula)) 
					return 1;
			boolean modificado = dc.modificar(c);
			if (modificado) return 0;
			else return 2;
		}
		return 3;
	}
	
	/**
	 * El m�todo busca en la base de datos un coche por id.
	 * @param id -> Identificador del coche que se quiere encontrar.
	 * @return Devuelve el coche si lo encuentra, en caso contario null.
	 */
	public Coche buscar(int id) {
		Coche coche = dc.buscar(id);
		return coche;
	}
	
	/**
	 * El m�todo busca en la base de datos un coche por matr�cula.
	 * @param matricula -> Matr�cula del coche que se quiere encontrar.
	 * @return Devuelve el coche si lo encuentra, en caso contario null.
	 */
	public Coche buscar_matricula(String matricula) {
		Coche coche = dc.buscar_matricula(matricula);
		return coche;
	}
	
	/**
	 * El m�todo busca en la base de datos coches por marca.
	 * @param marca -> Marca del coche que se quiere encontrar.
	 * @return Devuelve los coches encontrado, si no encuentra devuelve null.
	 */
	public Coches buscar_marca(String marca) {
		Coches coches = dc.buscar_marca(marca);
		return coches;
	}
	
	/**
	 * El m�todo busca en la base de datos coches por modelo.
	 * @param modelo -> Modelo del coche que se quiere encontrar.
	 * @return Devuelve los coches encontrado, si no encuentra devuelve null.
	 */
	public Coches buscar_modelo(String modelo) {
		Coches coches = dc.buscar_modelo(modelo);
		return coches;
	}

	/**
	 * El m�todo devuelve los coches de la bbdd.
	 * @return Devuelve el listado de coches, si no es posible devuelve null.
	 */
	public Coches get() {
		Coches coches = dc.get();
		return coches;
	}
}
