package datos;

public class Usuario {

	private String username;
	private String password;
	private boolean validado;
	
	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
		this.validado = false;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}
}
