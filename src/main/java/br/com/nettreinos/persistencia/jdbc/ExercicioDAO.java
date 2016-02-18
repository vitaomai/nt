package br.com.nettreinos.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.Exercicio;

public class ExercicioDAO {
	private Connection  con = FabConexao.getConnection();
	
	public List<Exercicio> buscarTodos(){
		
		String sql = "select * from exercicio order by nome;";
		List<Exercicio> lista = new ArrayList<Exercicio>();
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			//stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Exercicio exeRS = new Exercicio();
				
				exeRS.setId_Exercicio(rs.getInt("id_exercicio"));
				exeRS.setNome(rs.getString("nome"));
				exeRS.setLinkvideo1(rs.getString("linkvideo"));
				
				lista.add(exeRS);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
