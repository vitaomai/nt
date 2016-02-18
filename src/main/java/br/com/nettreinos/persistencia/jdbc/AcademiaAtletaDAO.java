package br.com.nettreinos.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.AcademiaAtleta;
import br.com.nettreinos.persistencia.entidade.Academia;
import br.com.nettreinos.persistencia.entidade.Atleta;


public class AcademiaAtletaDAO {
	private Connection con = FabConexao.getConnection();
	
	public List<AcademiaAtleta> buscarAcadAtl_iduadm(Integer id_uadm){
		String sql = "select academia.nome, atleta.nome, atleta.apelido from academia_atleta " + 
				"inner join academia on academia.id_academia = academia_atleta.id_academia " +
				"inner join atleta on atleta.id_atleta = academia_atleta.id_atleta " +
				//"inner join administrador on academia.id_academia = administrador.id_academia " + 
				"where academia.id_academia =?";

		List<AcademiaAtleta> lista = new ArrayList<AcademiaAtleta>();
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id_uadm);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Academia acadRS = new Academia();
				Atleta atlRS = new Atleta();
				AcademiaAtleta acadatlRS = new AcademiaAtleta();
				
				acadRS.setNome(rs.getString(1));
				atlRS.setNome(rs.getString(2));
				atlRS.setApelido(rs.getString(3));
				
				acadatlRS.setAtleta(atlRS);
				acadatlRS.setAcademia(acadRS);
				
				lista.add(acadatlRS);
			}
			
		} catch (SQLException e){
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
	
	public void inserir(AcademiaAtleta acadatl){
		String sql = "insert into academia_atleta (id_academia, id_atleta, ativo) " + 
					"values (?, ?, true);";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, acadatl.getAcademia().getId_Academia());
			stmt.setInt(2, acadatl.getAtleta().getId_atleta());
			
			stmt.execute();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
