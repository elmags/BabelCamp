package modelo.datos;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {

	private List<Usuario> usuarios;

	public Usuarios() {		
		this.usuarios = new ArrayList();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
