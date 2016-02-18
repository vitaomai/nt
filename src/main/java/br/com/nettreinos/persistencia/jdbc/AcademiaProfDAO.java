package br.com.nettreinos.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import br.com.nettreinos.persistencia.entidade.AcademiaProf;
import br.com.nettreinos.persistencia.entidade.Academia;
import br.com.nettreinos.persistencia.entidade.Prof;

public class AcademiaProfDAO {
	private Connection con = FabConexao.getConnection();
	
	public List<AcademiaProf> buscarAcadProf_idprf(Integer id_uprof){
		String sql = "select prof.nome, prof.apelido, academia.nome from academia_prof " + 
					"inner join prof on prof.id_prof = academia_prof.id_prof " + 
					"inner join academia on academia.id_academia = academia_prof.id_academia " +
					"where prof.id_prof=? ";

		List<AcademiaProf> lista = new ArrayList<AcademiaProf>();
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id_uprof);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Academia acadRS = new Academia();
				Prof prfRS = new Prof();
				AcademiaProf acadprfRS = new AcademiaProf();
				
				prfRS.setNome(rs.getString(1));
				prfRS.setApelido(rs.getString(2));
				acadRS.setNome(rs.getString(3));
				acadprfRS.setProf(prfRS);
				acadprfRS.setAcademia(acadRS);
				
				lista.add(acadprfRS);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} 
		return lista;
	}
	
	
	public List<AcademiaProf> buscarAcadProf_idadm(Integer id_uadm){
		String sql = "select academia.nome, prof.nome, prof.apelido from academia_prof " +
					"inner join prof on prof.id_prof = academia_prof.id_prof " +
					"inner join academia on academia.id_academia = academia_prof.id_academia " +
					//"inner join administrador on administrador.id_academia = academia.id_academia " + 
					"where academia.id_academia= ? ";

		List<AcademiaProf> lista = new ArrayList<AcademiaProf>();
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id_uadm);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Academia acadRS = new Academia();
				Prof prfRS = new Prof();
				AcademiaProf acadprfRS = new AcademiaProf();
				
				acadRS.setNome(rs.getString(1));
				
				prfRS.setNome(rs.getString(2));
				prfRS.setApelido(rs.getString(3));
				
				
				
				acadprfRS.setProf(prfRS);
				acadprfRS.setAcademia(acadRS);
				
				lista.add(acadprfRS);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} 
		return lista;
	}
	
	public List<Prof> buscarProf_nome(String nome){
		String sql = "select prof.id_prof, prof.nome, prof.apelido from prof " +
						"where prof.nome=? ";

		List<Prof> lista = new ArrayList<Prof>();
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				
				Prof prfRS = new Prof();
				
				prfRS.setId_prof(rs.getInt(1));			
				prfRS.setNome(rs.getString(2));
				prfRS.setApelido(rs.getString(3));
			
				lista.add(prfRS);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} 
		return lista;
	}
	
	public void inserir(AcademiaProf acadprf){
		String sql = "insert into academia_prof (id_academia, id_prof, ativo) " + 
					" values (?,?, true);";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, acadprf.getAcademia().getId_Academia());
			stmt.setInt(2, acadprf.getProf().getId_prof());
			
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}


