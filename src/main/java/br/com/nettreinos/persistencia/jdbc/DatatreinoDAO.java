package br.com.nettreinos.persistencia.jdbc;

import br.com.nettreinos.persistencia.entidade.Datatreino;
import br.com.nettreinos.persistencia.entidade.Treino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DatatreinoDAO {

	private Connection  con = FabConexao.getConnection();
	Calendar CalendDatanasc = Calendar.getInstance();
	
	public void inserir(Datatreino dtatre){
		String sql = "insert into datatreino (id_treino, datatreino, divisao) "
					+ "values (?, ?, ?);";
		CalendDatanasc = dtatre.getDatatreino();
		java.sql.Date datatreino = new java.sql.Date(CalendDatanasc.getTime().getTime());
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, dtatre.getTreino().getId_Treino());
			stmt.setDate(2, datatreino);
			stmt.setString(3, dtatre.getDivisao());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public List<Datatreino> buscarTodos(Integer id_treino){
		String sql = "Select * from datatreino " 
				+ "where id_treino=? order by datatreino;";
		
		List<Datatreino> listadt = new ArrayList<Datatreino>();
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id_treino);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				Datatreino dtatreRS = new Datatreino();
				Treino treRS = new Treino();
				Calendar CalendDatatreino = Calendar.getInstance();
				
				dtatreRS.setId_datatreino(rs.getInt("id_datatreino"));
				treRS.setId_Treino(rs.getInt("id_treino"));
					if (rs.getDate("datatreino")!=null){
						java.sql.Date DateDatatreino = rs.getDate("datatreino");
						CalendDatatreino.setTime(DateDatatreino);
					} 
					dtatreRS.setDatatreino(CalendDatatreino);
				dtatreRS.setDivisao(rs.getString("divisao"));

				dtatreRS.setTreino(treRS);
				
				listadt.add(dtatreRS);
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return listadt;
		
	}
	
}
