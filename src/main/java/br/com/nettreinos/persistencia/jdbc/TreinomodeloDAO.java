package br.com.nettreinos.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.Atleta;
import br.com.nettreinos.persistencia.entidade.Prof;
import br.com.nettreinos.persistencia.entidade.Treinomodelo;
import br.com.nettreinos.persistencia.entidade.TipoTreino;;

public class TreinomodeloDAO {
	private Connection  con = FabConexao.getConnection();

	public void salvar(Treinomodelo tremod){
		if(tremod.getId_Treinomodelo()!=null && tremod.getId_Treinomodelo()!=0){
			alterar(tremod);			
		}
		else{
			inserir(tremod);
		}
	}
	
	public void alterar(Treinomodelo tremod){
		String sql = "update treinomodelo set id_tipotreino=?, nome=?, descr=? " + 
					"where id_treinomodelo=?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, tremod.getTipotreino().getId_Tipotreino());
			stmt.setString(2, tremod.getNome());
			stmt.setString(3, tremod.getDescr());
			stmt.setInt(4, tremod.getId_Treinomodelo());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void inserir(Treinomodelo Tremod){
		String sql = "insert into treinomodelo (nome, descr, id_tipotreino, id_prof) " + 
					"values (?, ?, ?, ?); ";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, Tremod.getNome());
			stmt.setString(2, Tremod.getDescr());
			stmt.setInt(3, Tremod.getTipotreino().getId_Tipotreino());
			stmt.setInt(4, Tremod.getProf().getId_prof());
						
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Treinomodelo> buscarTodosProf(Integer id_prof) {
		String sql = "select treinomodelo.id_treinomodelo, tipotreino.nome, treinomodelo.nome, treinomodelo.descr from treinomodelo " + 
						"inner join prof on prof.id_prof = treinomodelo.id_prof " +
						"inner join tipotreino on tipotreino.id_tipotreino = treinomodelo.id_tipotreino " +
						"where treinomodelo.id_prof=? " + 
						"order by 1;";
		List<Treinomodelo> lista = new ArrayList<Treinomodelo>();
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id_prof);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				//Prof prfRS = new Prof();
				Treinomodelo tremodRS = new Treinomodelo();
				TipoTreino tpotreRS = new TipoTreino();
				
				tremodRS.setId_Treinomodelo(rs.getInt(1));
				
				tpotreRS.setNome(rs.getString(2));
				
				tremodRS.setNome(rs.getString(3));
				tremodRS.setDescr(rs.getString(4));
								
				tremodRS.setTipotreino(tpotreRS);
				
				lista.add(tremodRS); 
			
				
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return lista;
	}

	public Treinomodelo buscarPorIdTreino(Integer id) {
		String sql = "select treinomodelo.id_treinomodelo, tipotreino.id_tipotreino, tipotreino.nome, treinomodelo.nome, treinomodelo.descr from treinomodelo " + 
						"inner join tipotreino on tipotreino.id_tipotreino = treinomodelo.id_tipotreino " + 
						"where id_treinomodelo=?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				Treinomodelo TremodRS = new Treinomodelo();
				TipoTreino tpotreRS = new TipoTreino();
				
				TremodRS.setId_Treinomodelo(rs.getInt(1));
				
				tpotreRS.setId_Tipotreino(rs.getInt(2));
				tpotreRS.setNome(rs.getString(3));
				
				
				TremodRS.setNome(rs.getString(4));
				TremodRS.setDescr(rs.getString(5));
				
				TremodRS.setTipotreino(tpotreRS);
				
				stmt.close();
				return TremodRS;
			}	
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
		return null;
	}
}
