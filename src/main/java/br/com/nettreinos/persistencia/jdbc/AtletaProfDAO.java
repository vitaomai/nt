package br.com.nettreinos.persistencia.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.AtletaProf;
import br.com.nettreinos.persistencia.entidade.Atleta;
import br.com.nettreinos.persistencia.entidade.Prof;

public class AtletaProfDAO {
	private Connection con = FabConexao.getConnection();
			
	public List<AtletaProf> buscarTodos(){
		String sql = "select prof.nome, prof.apelido, atleta.nome from atleta_prof " + 
					"inner join prof on prof.id_prof = atleta_prof.id_prof " + 
					"inner join atleta on atleta.id_atleta = atleta_prof.id_atleta;";
		
		List<AtletaProf> lista = new ArrayList<AtletaProf>();

		try (PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				Atleta atlRS = new Atleta();
				Prof prfRS = new Prof();
				AtletaProf atlPrfRS = new AtletaProf();
				
				prfRS.setNome(rs.getString(1));
				prfRS.setApelido(rs.getString(2));
				
				atlRS.setNome(rs.getString(3));
				
				atlPrfRS.setAtleta(atlRS);
				atlPrfRS.setProf(prfRS);
				
				lista.add(atlPrfRS);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<AtletaProf> buscarAtleProf_idprf(Integer id_prof){
		String sql = "select prof.nome, prof.apelido, atleta.id_atleta, atleta.nome from atleta_prof " + 
					"inner join prof on prof.id_prof = atleta_prof.id_prof " + 
					"inner join atleta on atleta.id_atleta = atleta_prof.id_atleta " + 
					"where prof.id_prof=?;";
		List<AtletaProf> lista = new ArrayList<AtletaProf>();

		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id_prof);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				Atleta atlRS = new Atleta();
				Prof prfRS = new Prof();
				AtletaProf atlPrfRS = new AtletaProf();
				
				prfRS.setNome(rs.getString(1));
				prfRS.setApelido(rs.getString(2));
				atlRS.setId_atleta(rs.getInt(3));
				atlRS.setNome(rs.getString(4));
				
				atlPrfRS.setAtleta(atlRS);
				atlPrfRS.setProf(prfRS);
				
				lista.add(atlPrfRS);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return lista;
	}

	public List<Atleta> buscarPorNome(String nome){
		
		String sql = "Select * from atleta where nome=?";
		List<Atleta> lista = new ArrayList<Atleta>();
		Calendar CalendDatanasc = Calendar.getInstance();
		try (PreparedStatement smtm = con.prepareStatement(sql)){
			smtm.setString(1, nome);
			
			ResultSet rs = smtm.executeQuery();
						
			while(rs.next()){
				Atleta AtleRS = new Atleta();
				
				AtleRS.setId_atleta(rs.getInt("id_atleta"));
				AtleRS.setId_usuario(rs.getInt("id_usuario"));
				AtleRS.setNome(rs.getString("nome"));
				AtleRS.setSobrenome(rs.getString("sobrenome"));
				AtleRS.setApelido(rs.getString("apelido"));
				AtleRS.setAtivo(rs.getBoolean("ativo"));
				AtleRS.setTelefone1(rs.getString("telefone1"));
				AtleRS.setTelefone2(rs.getString("telefone2"));
				AtleRS.setCpf(rs.getString("cpf"));
				AtleRS.setFoto(rs.getString("foto"));

				if (rs.getDate("datanasc")!=null){
					java.sql.Date DateDatanasc = rs.getDate("datanasc");
					CalendDatanasc.setTime(DateDatanasc);
				} 
				AtleRS.setDatanasc(CalendDatanasc);
					
				AtleRS.setEmail(rs.getString("email"));
				AtleRS.setFacebook(rs.getString("facebook"));
				AtleRS.setEndereco(rs.getString("endereco"));
				AtleRS.setCep(rs.getString("cep"));
				AtleRS.setBairro(rs.getString("bairro"));
				AtleRS.setNumero(rs.getString("numero"));
				AtleRS.setId_cidade(rs.getInt("id_cidade"));
				AtleRS.setId_estado(rs.getInt("id_estado"));
				
				lista.add(AtleRS);
			}			
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
		return lista;
	}
	
	public void inserir(AtletaProf atlprf){
		String sql = "insert into atleta_prof (id_atleta, id_prof, ativo) " + 
					"values (?, ?, true);";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, atlprf.getAtleta().getId_atleta());
			stmt.setInt(2, atlprf.getProf().getId_prof());
			
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
