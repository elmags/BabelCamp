package datos;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
	
	private List<Usuario> usuarios;

	public Usuarios() {
		Usuario u1 = new Usuario();
		Usuario u2 = new Usuario();
		Usuario u3 = new Usuario();
		
		u1.setUsername("username1");
		u1.setPassword("passwd1");
		
		u2.setUsername("username2");
		u2.setPassword("passwd2");
		
		u3.setUsername("username3");
		u3.setPassword("passwd2");
		
		usuarios = new ArrayList();
		
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}	
}
