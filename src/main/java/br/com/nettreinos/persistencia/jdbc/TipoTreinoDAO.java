package br.com.nettreinos.persistencia.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.TipoTreino;

public class TipoTreinoDAO {
	private Connection  con = FabConexao.getConnection();

	public List<TipoTreino> buscarTodos(Integer id) {
		String sql = "select * from tipotreino;"; //where id_tipotreino!=?;";
		List<TipoTreino> lista = new ArrayList<TipoTreino>();
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			//stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				TipoTreino tpotreRS = new TipoTreino();
				
				tpotreRS.setId_Tipotreino(rs.getInt("id_tipotreino"));
				tpotreRS.setNome(rs.getString("nome"));
				tpotreRS.setDescr(rs.getString("descr"));
				
				lista.add(tpotreRS);
				
			}
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<TipoTreino> buscarTodosOutros(Integer id) {
		String sql = "select * from tipotreino where id_tipotreino!=?;";
		List<TipoTreino> lista = new ArrayList<TipoTreino>();
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				TipoTreino tpotreRS = new TipoTreino();
				
				tpotreRS.setId_Tipotreino(rs.getInt("id_tipotreino"));
				tpotreRS.setNome(rs.getString("nome"));
				tpotreRS.setDescr(rs.getString("descr"));
				
				lista.add(tpotreRS);
				
			}
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	
}
