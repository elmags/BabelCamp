package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import datos.Coche;
import peristencia.interfaces.DaoCoche;

public class DaoCocheMySql implements DaoCoche {

	private Connection conn;
	
	@Override
	public boolean alta(Coche c) {
		conn = conectarConBBDD();
		boolean creado = true;
		if (conn != null) {
			try {
			String sql = "INSERT INTO coches (matricula, marca, modelo, kilometros)" +
						   "VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKm());
			
			int affectedRows = ps.executeUpdate();
			if (affectedRows == 0) {
				creado = false;
			}
			
			} catch (SQLException e) {
				System.out.println("No se pudo dar de alta el coche con matricula: " + c.getMatricula());
				e.printStackTrace();
				creado = false;
			}
		}
		cerrarConn();
		return creado;
	}

	@Override
	public boolean baja(int id) {
		conn = conectarConBBDD();
		boolean borrado = true;
		if (conn != null) {
			try {
			String sql = "DELETE FROM coches WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int affectedRows = ps.executeUpdate();
			if (affectedRows == 0) {
				borrado = false;
			}
			
			} catch (SQLException e) {
				System.out.println("No se pudo eliminar el coche");
				e.printStackTrace();
				borrado = false;
			}
		}
		cerrarConn();
		return borrado;
	}

	@Override
	public boolean modificar(Coche c) {
		conn = conectarConBBDD();
		boolean modificado = true;
		if (conn != null) {
			try {
			String sql = "UPDATE coches SET matricula=? , marca=? , modelo=? , " +
					     "kilometros=? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKm());
			ps.setInt(5, c.getId());
			
			int affectedRows = ps.executeUpdate();
			if (affectedRows == 0) {
				modificado = false;
			}
			
			} catch (SQLException e) {
				System.out.println("No se pudo eliminar el coche");
				e.printStackTrace();
				modificado = false;
			}
		}
		cerrarConn();
		return modificado;
	}

	@Override
	public Coche buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Coche buscar_matricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Coche buscar_marca(String marca) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Coche buscar_modelo(String modelo) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Coche> get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Connection conectarConBBDD() {
		String serverAddress = "localhost:3306";
		String db = "coches";
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
	
	public void cerrarConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
