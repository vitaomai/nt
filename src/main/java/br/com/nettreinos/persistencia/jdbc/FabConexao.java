package br.com.nettreinos.persistencia.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FabConexao {

	public static Connection getConnection() {
 
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/nettr", "postgres", "A@bc12po");
		} catch (SQLException e) {

			throw new RuntimeException(e);
	
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
