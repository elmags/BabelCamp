package modelo.persistencia.interfaces;

import modelo.datos.Usuario;

public interface DaoUsuario {

	public Usuario get(String username);
}
