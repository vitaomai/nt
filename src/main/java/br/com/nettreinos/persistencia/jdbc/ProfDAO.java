package br.com.nettreinos.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.Prof;

public class ProfDAO {
	private Connection con = FabConexao.getConnection();
	Calendar CalendDatanasc = Calendar.getInstance();
	
	
	public void salvar(Prof Prf){
		if(Prf.getId_prof()!=null && Prf.getId_prof()!=0){
			alterar(Prf);			
		}
		else{
			inserir(Prf);
		}
	}
	
	
	public void inserir(Prof Prf) {

		String sql = "insert into prof (id_usuario, nome, sobrenome, apelido, telefone1, telefone2," + 
					" cpf, foto, datanasc, email, site, facebook, endereco, numero, cep, bairro, id_cidade, id_estado, numconselho, ativo) "+ 
						"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
			CalendDatanasc = Prf.getDatanasc();
			java.sql.Date DateDatanasc = new java.sql.Date(CalendDatanasc.getTime().getTime());

		try (PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setInt(1, Prf.getId_usuario());
			stmt.setString(2, Prf.getNome());
			stmt.setString(3, Prf.getSobrenome());
			stmt.setString(4, Prf.getApelido());
			stmt.setString(5, Prf.getTelefone1());
			stmt.setString(6, Prf.getTelefone2());
			stmt.setString(7, Prf.getCpf());
			stmt.setString(8, Prf.getFoto());
			stmt.setDate(9, DateDatanasc);
			stmt.setString(10, Prf.getEmail());
			stmt.setString(11, Prf.getSite());
			stmt.setString(12, Prf.getFacebook());
			stmt.setString(13, Prf.getEndereco());
			stmt.setString(14, Prf.getNumero());
			stmt.setString(15, Prf.getCep());
			stmt.setString(16, Prf.getBairro());
			stmt.setInt(17, Prf.getId_cidade());
			stmt.setInt(18, Prf.getId_estado());
			stmt.setInt(19, Prf.getNumconselho());
			stmt.setBoolean(20, Prf.getAtivo());

			stmt.execute();
			stmt.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Prof Prf){
		String sql ="update prof set id_usuario=?, nome=?, sobrenome=?, apelido=?, telefone1=?, telefone2=?, cpf=?, foto=?, datanasc=?," + 
					" email=?, site=?, facebook=?, endereco=?, numero=?, cep=?, bairro=?, id_cidade=?, id_estado=?, numconselho=?, ativo=? where id_prof=?";
		
		CalendDatanasc = Prf.getDatanasc();
		java.sql.Date DateDatanasc = new java.sql.Date(CalendDatanasc.getTime().getTime());
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setInt(1, Prf.getId_usuario());
			stmt.setString(2, Prf.getNome());
			stmt.setString(3, Prf.getSobrenome());
			stmt.setString(4, Prf.getApelido());
			stmt.setString(5, Prf.getTelefone1());
			stmt.setString(6, Prf.getTelefone2());
			stmt.setString(7, Prf.getCpf());
			stmt.setString(8, Prf.getFoto());
			stmt.setDate(9, DateDatanasc);
			stmt.setString(10, Prf.getEmail());
			stmt.setString(11, Prf.getSite());
			stmt.setString(12, Prf.getFacebook());
			stmt.setString(13, Prf.getEndereco());
			stmt.setString(14, Prf.getNumero());
			stmt.setString(15, Prf.getCep());
			stmt.setString(16, Prf.getBairro());
			stmt.setInt(17, Prf.getId_cidade());
			stmt.setInt(18, Prf.getId_estado());
			stmt.setInt(19, Prf.getNumconselho());
			stmt.setBoolean(20, Prf.getAtivo());
			stmt.setInt(21, Prf.getId_prof());


			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void desativar(Prof Prf){
		String sql = "update prof set ativo=? where id_prof=?";
		
		try{ 
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setBoolean(1, Prf.getAtivo());
			stmt.setInt(2, Prf.getId_prof());

			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Prof> buscarTodos(){
		String sql = "select * from prof;";
		List<Prof> lista = new ArrayList<Prof>();
		
		Calendar CalendDatanasc = Calendar.getInstance();
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()){
				Prof PrfRS = new Prof();
				
				PrfRS.setId_prof(rs.getInt("id_prof"));
				PrfRS.setId_usuario(rs.getInt("id_usuario"));
				PrfRS.setNome(rs.getString("nome"));
				PrfRS.setSobrenome(rs.getString("sobrenome"));
				PrfRS.setApelido(rs.getString("apelido"));
				PrfRS.setTelefone1(rs.getString("telefone1"));
				PrfRS.setTelefone2(rs.getString("telefone2"));
				PrfRS.setCpf(rs.getString("cpf"));
				PrfRS.setFoto(rs.getString("foto"));
				
				if (rs.getDate("datanasc")!=null){
					java.sql.Date DateDatanasc = rs.getDate("datanasc");
					CalendDatanasc.setTime(DateDatanasc);
				} 
					PrfRS.setDatanasc(CalendDatanasc);
				
				PrfRS.setEmail(rs.getString("email"));
				PrfRS.setSite(rs.getString("site"));
				PrfRS.setFacebook(rs.getString("facebook"));
				PrfRS.setEndereco(rs.getString("endereco"));
				PrfRS.setNumero(rs.getString("numero"));
				PrfRS.setCep(rs.getString("cep"));
				PrfRS.setBairro(rs.getString("bairro"));
				PrfRS.setId_cidade(rs.getInt("id_cidade"));
				PrfRS.setId_estado(rs.getInt("id_estado"));
				PrfRS.setNumconselho(rs.getInt("numconselho"));
				PrfRS.setAtivo(rs.getBoolean("ativo"));

				lista.add(PrfRS);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public Prof buscarPorId(Integer id){		
		String sql = "Select * from prof where id_prof=?";
		Calendar CalendDatanasc = Calendar.getInstance();
		try (PreparedStatement smtm = con.prepareStatement(sql)){
			smtm.setInt(1, id);
			
			ResultSet rs = smtm.executeQuery();
						
			if(rs.next()){
				Prof PrfRS = new Prof();
				
				PrfRS.setId_prof(rs.getInt("id_prof"));
				PrfRS.setId_usuario(rs.getInt("id_usuario"));
				PrfRS.setNome(rs.getString("nome"));
				PrfRS.setSobrenome(rs.getString("sobrenome"));
				PrfRS.setApelido(rs.getString("apelido"));
				PrfRS.setTelefone1(rs.getString("telefone1"));
				PrfRS.setTelefone2(rs.getString("telefone2"));
				PrfRS.setCpf(rs.getString("cpf"));
				PrfRS.setFoto(rs.getString("foto"));
				
				if (rs.getDate("datanasc")!=null){
					java.sql.Date DateDatanasc = rs.getDate("datanasc");
					CalendDatanasc.setTime(DateDatanasc);
				} 
					PrfRS.setDatanasc(CalendDatanasc);
				
				PrfRS.setEmail(rs.getString("email"));
				PrfRS.setSite(rs.getString("site"));
				PrfRS.setFacebook(rs.getString("facebook"));
				PrfRS.setEndereco(rs.getString("endereco"));
				PrfRS.setNumero(rs.getString("numero"));
				PrfRS.setCep(rs.getString("cep"));
				PrfRS.setBairro(rs.getString("bairro"));
				PrfRS.setId_cidade(rs.getInt("id_cidade"));
				PrfRS.setId_estado(rs.getInt("id_estado"));
				PrfRS.setNumconselho(rs.getInt("numconselho"));
				PrfRS.setAtivo(rs.getBoolean("ativo"));
				
				return PrfRS;
			}			
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
		return null;
	}
	
	public Prof buscarPorIdUsuario (Integer idusuario){
		String sql = "Select * from prof where id_usuario=?";
		Calendar CalendDatanasc = Calendar.getInstance();
		try (PreparedStatement smtm = con.prepareStatement(sql)){
			smtm.setInt(1, idusuario);
			
			ResultSet rs = smtm.executeQuery();
						
			if(rs.next()){
				Prof PrfRS = new Prof();
				
				PrfRS.setId_prof(rs.getInt("id_prof"));
				PrfRS.setId_usuario(rs.getInt("id_usuario"));
				PrfRS.setNome(rs.getString("nome"));
				PrfRS.setSobrenome(rs.getString("sobrenome"));
				PrfRS.setApelido(rs.getString("apelido"));
				PrfRS.setTelefone1(rs.getString("telefone1"));
				PrfRS.setTelefone2(rs.getString("telefone2"));
				PrfRS.setCpf(rs.getString("cpf"));
				PrfRS.setFoto(rs.getString("foto"));
				
				if (rs.getDate("datanasc")!=null){
					java.sql.Date DateDatanasc = rs.getDate("datanasc");
					CalendDatanasc.setTime(DateDatanasc);
				} 
					PrfRS.setDatanasc(CalendDatanasc);
				
				
				PrfRS.setEmail(rs.getString("email"));
				PrfRS.setSite(rs.getString("site"));
				PrfRS.setFacebook(rs.getString("facebook"));
				PrfRS.setEndereco(rs.getString("endereco"));
				PrfRS.setNumero(rs.getString("numero"));
				PrfRS.setCep(rs.getString("cep"));
				PrfRS.setBairro(rs.getString("bairro"));
				PrfRS.setId_cidade(rs.getInt("id_cidade"));
				PrfRS.setId_estado(rs.getInt("id_estado"));
				PrfRS.setNumconselho(rs.getInt("numconselho"));
				PrfRS.setAtivo(rs.getBoolean("ativo"));
				
				return PrfRS;
			}			
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
		return null;	
	}
	
	public void inserirNovoUsuario(Integer id_usr) {

		String sql = "insert into prof (id_usuario) values (?);";
		
			//CalendDatanasc = Prf.getDatanasc();
			//java.sql.Date DateDatanasc = new java.sql.Date(CalendDatanasc.getTime().getTime());

		try (PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setInt(1, id_usr);
			stmt.execute();
			stmt.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
