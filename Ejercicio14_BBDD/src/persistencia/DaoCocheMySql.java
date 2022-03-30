package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import datos.Coche;
import datos.Coches;
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
		conn = conectarConBBDD();
		Coche coche = null;
		if (conn != null) {
			try {
			String sql = "SELECT * FROM coches WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) coche = cocheFromRS(rs);
			
			} catch (SQLException e) {
				System.out.println("No se pudo encontrar el coche");
				e.printStackTrace();
			}
		}
		cerrarConn();
		return coche;
	}



	@Override
	public Coche buscar_matricula(String matricula) {
		conn = conectarConBBDD();
		Coche coche = null;
		if (conn != null) {
			try {
			String sql = "SELECT * FROM coches WHERE matricula = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, matricula);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) coche = cocheFromRS(rs);
			
			} catch (SQLException e) {
				System.out.println("No se pudo encontrar el coche");
				e.printStackTrace();
			}
		}
		cerrarConn();
		return coche;
	}



	@Override
	public Coche buscar_marca(String marca) {
		conn = conectarConBBDD();
		Coche coche = null;
		if (conn != null) {
			try {
			String sql = "SELECT * FROM coches WHERE marca = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, marca);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) coche = cocheFromRS(rs);
			
			} catch (SQLException e) {
				System.out.println("No se pudo encontrar el coche");
				e.printStackTrace();
			}
		}
		cerrarConn();
		return coche;
	}



	@Override
	public Coche buscar_modelo(String modelo) {
		conn = conectarConBBDD();
		Coche coche = null;
		if (conn != null) {
			try {
			String sql = "SELECT * FROM coches WHERE modelo = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, modelo);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) coche = cocheFromRS(rs);
			
			} catch (SQLException e) {
				System.out.println("No se pudo encontrar el coche");
				e.printStackTrace();
			}
		}
		cerrarConn();
		return coche;
	}



	@Override
	public Coches get() {
		conn = conectarConBBDD();
		Coches coches = new Coches();
		if (conn != null) {
			try {
			String sql = "SELECT * FROM coches";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Coche coche;
			
			while (rs.next()) {
				coche = cocheFromRS(rs);
				coches.addCoche(coche);
			}			
			
			} catch (SQLException e) {
				System.out.println("No se pudo encontrar el coche");
				e.printStackTrace();
			}
		}
		cerrarConn();
		return coches;
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
	
	private void cerrarConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Coche cocheFromRS(ResultSet rs) throws SQLException {
		Coche coche = new Coche(rs.getString("matricula"), rs.getString("marca"), rs.getString("modelo"), rs.getDouble("kilometros"));
		coche.setId(rs.getInt("id"));
		return coche;
	}
}
