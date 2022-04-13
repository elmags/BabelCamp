package modelo.negocio;

import modelo.datos.Usuario;
import modelo.persistencia.DaoUsuarioMySql;
import modelo.persistencia.interfaces.DaoUsuario;

public class GestorUsuario {
	
	private DaoUsuario du = new DaoUsuarioMySql();
	
	/**
	 * El método busca en la base de datos un usuario por username.
	 * 
	 * @param username : Nombre del usuario que se quiere buscar.
	 * @return Devuelve el usuario si lo encuentr, en caso contrario null.
	 */
	public Usuario get(String username) {
		Usuario usuario = du.get(username);
		return usuario;
	}
}
