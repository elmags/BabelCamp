package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.datos.Usuario;
import modelo.persistencia.interfaces.DaoUsuario;

public class DaoUsuarioMySql implements DaoUsuario {

	private Connection conn;
	
	/*
	 * Para evitar problemas al conectar a la base de datos se debe cargar el Driver.
	 */
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Mysql8
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
		}
		
		System.out.println("Se ha cargado el Driver de MySQL");
	}
	
	@Override
	public Usuario get(String username) {
		conn = conectarConBBDD();
		Usuario usuario = null;
		if (conn != null) {
			try {
			String sql = "SELECT * FROM usuarios WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) usuario = usuarioFromRS(rs);
			else System.out.println("El usuario con nombre " + username + " no se ha encontrado");
			
			} catch (SQLException e) {
				System.out.println("No se pudo autenticar el nombre de usuario y la contraseña");
				e.printStackTrace();
			}
			cerrarConn();
		}
		return usuario;
	}
	
	/**
	 * Método que realiza la conexión con la base de datos.
	 * @return la conexión si se ha relizado correctamente, null en caso contrario.
	 */
	private Connection conectarConBBDD() {
		String serverAddress = "localhost:3306";
		String db = "ejercicio21";
		String user = "root";
		String pass = "";
		String url = "jdbc:mysql://" + serverAddress +"/" + db;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * Método que cierra la conexión.
	 */
	private void cerrarConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo auxiliar para obtener un Usuario de la base de datos.
	 * @param rs : Resultado de la busqueda en la base de datos.
	 * @return usuario encontrado en la base de datos.
	 * @throws SQLException
	 */
	private Usuario usuarioFromRS(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario(rs.getString("username"), rs.getString("password"));
		return usuario;
	}	
}
