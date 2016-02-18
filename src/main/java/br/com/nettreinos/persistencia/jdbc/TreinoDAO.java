package br.com.nettreinos.persistencia.jdbc;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.nettreinos.persistencia.entidade.Prof;
import br.com.nettreinos.persistencia.entidade.TipoTreino;
import br.com.nettreinos.persistencia.entidade.Treino;
import br.com.nettreinos.persistencia.entidade.Treinomodelo;

public class TreinoDAO {

	private Connection  con = FabConexao.getConnection();

	public void vincular(Treino tre) {
		String sql = "Insert into treino (id_atleta, id_prof, id_tipotreino, nome, descr) "  
						+ "values (?,?,?,?,?);";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, tre.getAtleta().getId_atleta());
			stmt.setInt(2, tre.getProf().getId_prof());
			stmt.setInt(3, tre.getTipotreino().getId_Tipotreino());
			stmt.setString(4, tre.getNome());
			stmt.setString(5, tre.getDescr());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public Integer buscarMaxPorIdTreino(Treino tre) {
		String sql = "select max(id_treino) from treino where id_atleta=? and id_prof=?;";
		Integer idTreino = 0; //Treino tre = new Treino();
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, tre.getAtleta().getId_atleta());
			stmt.setInt(2, tre.getProf().getId_prof());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()){
				
				idTreino = rs.getInt("max"); 
			}
			
			stmt.close();
			return idTreino;
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return idTreino;
		
	}
	
	public List<Treino> buscarPorIdAtleta(Integer id){
		String sql = "select treino.id_treino, prof.nome, tipotreino.nome, treino.nome, treino.descr from treino "  
					+ "inner join prof on prof.id_prof = treino.id_prof "
					+ "inner join tipotreino on tipotreino.id_tipotreino = treino.id_tipotreino "
					+ "where id_atleta = ?;"; 
		
		List<Treino> listatre = new ArrayList<Treino>();
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				Treino treRS = new Treino();
				TipoTreino tpotreRS = new TipoTreino();
				Prof prfRS = new Prof();
				
				
				treRS.setId_Treino(rs.getInt(1));
				prfRS.setNome(rs.getString(2));
				tpotreRS.setNome(rs.getString(3));
				treRS.setNome(rs.getString(4));
				treRS.setDescr(rs.getString(5));
				
				treRS.setProf(prfRS);
				treRS.setTipotreino(tpotreRS);
				
				
				listatre.add(treRS);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return listatre;
	}
	
	
}
