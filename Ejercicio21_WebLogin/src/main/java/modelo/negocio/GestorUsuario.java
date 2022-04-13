package modelo.negocio;

import modelo.datos.Usuario;
import modelo.persistencia.DaoUsuarioMySql;
import modelo.persistencia.interfaces.DaoUsuario;

public class GestorUsuario {
	
	private DaoUsuario du = new DaoUsuarioMySql();
	
	public Usuario get(String username) {
		Usuario usuario = du.get(username);
		return usuario;
	}
}
