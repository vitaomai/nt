package br.com.nettreinos.persistencia.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.Academia;
import br.com.nettreinos.persistencia.entidade.Atleta;
import br.com.nettreinos.persistencia.entidade.Prof;
import br.com.nettreinos.persistencia.entidade.AcademiaAtletaProf;


public class AcademiaAtletaProfDAO {
	private Connection con = FabConexao.getConnection();
	
	public List<AcademiaAtletaProf> buscarAcadAtlPrf_idadm(Integer idadm){
		String sql = "select academia.nome, atleta.nome, prof.nome from academia_atleta_prof " + 
					"inner join academia on academia_atleta_prof.id_academia = academia.id_academia " + 
					"inner join atleta on academia_atleta_prof.id_atleta = atleta.id_atleta " + 
					"inner join Prof on Academia_atleta_prof.id_prof = prof.id_prof " + 
					"where academia_atleta_prof.id_academia = ?";
		
		List<AcademiaAtletaProf> lista = new ArrayList<AcademiaAtletaProf>();
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idadm);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Academia acadRS = new Academia();
				Atleta atlRS = new Atleta();
				Prof prfRS = new Prof();
				AcademiaAtletaProf acadatlprfRS = new AcademiaAtletaProf();
				
				acadRS.setNome(rs.getString(1));
				atlRS.setNome(rs.getString(2));
				prfRS.setNome(rs.getString(3));
				acadatlprfRS.setAcademia(acadRS);
				acadatlprfRS.setAtleta(atlRS);
				acadatlprfRS.setProf(prfRS);
				
				lista.add(acadatlprfRS);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		} 
		
		
		return lista;
		
	}
}
