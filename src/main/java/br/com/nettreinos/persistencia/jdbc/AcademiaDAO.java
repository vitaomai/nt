package br.com.nettreinos.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.Academia;
public class AcademiaDAO {

	private Connection con = FabConexao.getConnection();
	Calendar CalendDataCad = Calendar.getInstance();

	public void salvar(Academia Acad){
		if(Acad.getId_Academia()!=null && Acad.getId_Academia()!=0){
			alterar(Acad);			
		}
		else{
			inserir(Acad);
		}
	}
	
	public void inserir(Academia Acad) {

		String sql = "Insert into academia (nome,razaosocial,telefone1,telefone2,cnpj,datacad,responsavel,email,site,facebook," + 
			"endereco,cep,bairro,numero,id_cidade,id_estado,ativo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
			CalendDataCad = Acad.getDataCad();
			java.sql.Date DateDatacad = new java.sql.Date(CalendDataCad.getTime().getTime());

		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, Acad.getNome());  
			stmt.setString(2, Acad.getRazaoSocial());
			stmt.setString(3, Acad.getTelefone1());
			stmt.setString(4, Acad.getTelefone2());
			stmt.setString(5, Acad.getCNPJ());
			stmt.setDate(6, DateDatacad);
			stmt.setString(7, Acad.getResponsavel());
			stmt.setString(8, Acad.getEmail());
			stmt.setString(9, Acad.getSite());
			stmt.setString(10, Acad.getFacebook());
			stmt.setString(11, Acad.getEndereco());
			stmt.setString(12, Acad.getCep());
			stmt.setString(13, Acad.getBairro());
			stmt.setString(14, Acad.getNumero());
			stmt.setInt(15, Acad.getId_Cidade());
			stmt.setInt(16, Acad.getId_Estado());
			stmt.setBoolean(17, Acad.isAtivo());

			stmt.execute();
			stmt.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Academia Acad){
		String sql ="update academia set nome=?, razaosocial=?, telefone1=?, telefone2=?, cnpj=?, datacad=?, responsavel=?, email=?, " + 
					"site=?, facebook=?, endereco=?, cep=?, bairro=?, numero=?, id_cidade=?, id_estado=?, ativo=? where id_academia=?";

		CalendDataCad = Acad.getDataCad();
		java.sql.Date DateDataCad = new java.sql.Date(CalendDataCad.getTime().getTime());
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, Acad.getNome());
			stmt.setString(2, Acad.getRazaoSocial());
			stmt.setString(3, Acad.getTelefone1());
			stmt.setString(4, Acad.getTelefone2());
			stmt.setString(5, Acad.getCNPJ());
			stmt.setDate(6, DateDataCad);
			stmt.setString(7, Acad.getResponsavel());
			stmt.setString(8, Acad.getEmail());
			stmt.setString(9, Acad.getSite());
			stmt.setString(10, Acad.getFacebook());
			stmt.setString(11, Acad.getEndereco());
			stmt.setString(12, Acad.getCep());
			stmt.setString(13, Acad.getBairro());
			stmt.setString(14, Acad.getNumero());
			stmt.setInt(15, Acad.getId_Cidade());
			stmt.setInt(16, Acad.getId_Estado());
			stmt.setBoolean(17, Acad.isAtivo());
			stmt.setInt(18, Acad.getId_Academia());

			//id_academia
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void desativar(Academia Acad){
		String sql = "update academia set ativo=false where id_academia=?";
		
		try{ 
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, Acad.getId_Academia());
	
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public List<Academia> buscarTodos(){
		String sql = "select * from academia;";
		List<Academia> lista = new ArrayList<Academia>();
		
		Calendar CalendDataCad = Calendar.getInstance();
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet resultado = stmt.executeQuery();
//			String A;			
			while(resultado.next()){
				Academia Acad = new Academia();
				
				Acad.setId_Academia(resultado.getInt("id_academia"));
				Acad.setNome(resultado.getString("nome"));
				Acad.setRazaoSocial(resultado.getString("razaosocial"));
				Acad.setTelefone1(resultado.getString("telefone1"));
				Acad.setTelefone2(resultado.getString("telefone2"));
				Acad.setCNPJ(resultado.getString("cnpj"));

				java.sql.Date DateDataCad = resultado.getDate("datacad");
				CalendDataCad.setTime(DateDataCad);
				Acad.setDataCad(CalendDataCad);				

				Acad.setResponsavel(resultado.getString("responsavel"));
				Acad.setEmail(resultado.getString("email"));
				Acad.setSite(resultado.getString("site"));
				Acad.setFacebook(resultado.getString("facebook"));
				Acad.setEndereco(resultado.getString("endereco"));
				Acad.setNumero(resultado.getString("numero"));
				Acad.setCep(resultado.getString("cep"));
				Acad.setBairro(resultado.getString("bairro"));
				Acad.setId_Cidade(resultado.getInt("id_cidade"));
				Acad.setId_Estado(resultado.getInt("id_estado"));
				Acad.setAtivo(resultado.getBoolean("ativo"));
				//Adicionando o usuario na lista
				lista.add(Acad);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return lista;
	}

	public Academia buscarPorId(Integer id){		
		String sql = "Select * from academia where id_academia=?";
		Calendar CalendDataCad = Calendar.getInstance();
		try (PreparedStatement smtm = con.prepareStatement(sql)){
			smtm.setInt(1, id);
			
			ResultSet resultado = smtm.executeQuery();
						
			if(resultado.next()){
				Academia AcadResult = new Academia();
				
				AcadResult.setId_Academia(resultado.getInt("id_academia"));
				AcadResult.setNome(resultado.getString("nome"));
				AcadResult.setRazaoSocial(resultado.getString("razaosocial"));
				AcadResult.setTelefone1(resultado.getString("telefone1"));
				AcadResult.setTelefone2(resultado.getString("telefone2"));
				AcadResult.setCNPJ(resultado.getString("cnpj"));

				java.sql.Date DateDataCad = resultado.getDate("datacad");
				CalendDataCad.setTime(DateDataCad);
				AcadResult.setDataCad(CalendDataCad);				

				AcadResult.setResponsavel(resultado.getString("responsavel"));
				AcadResult.setEmail(resultado.getString("email"));
				AcadResult.setSite(resultado.getString("site"));
				AcadResult.setFacebook(resultado.getString("facebook"));
				AcadResult.setEndereco(resultado.getString("endereco"));
				AcadResult.setNumero(resultado.getString("numero"));
				AcadResult.setCep(resultado.getString("cep"));
				AcadResult.setBairro(resultado.getString("bairro"));
				AcadResult.setId_Cidade(resultado.getInt("id_cidade"));
				AcadResult.setId_Estado(resultado.getInt("id_estado"));
				AcadResult.setAtivo(resultado.getBoolean("ativo"));
				return AcadResult;
			}			
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
		return null;
	}
	
	/*public Academia buscarPorIdAdm(Integer id){		
		String sql = "select * from academia " + 
					"left join administrador on academia.id_academia = administrador.id_academia " +  
					"where administrador.id_usuario = ?";
		Calendar CalendDataCad = Calendar.getInstance();
		try (PreparedStatement smtm = con.prepareStatement(sql)){
			smtm.setInt(1, id);
			
			ResultSet resultado = smtm.executeQuery();
						
			if(resultado.next()){
				Academia AcadResult = new Academia();
				
				AcadResult.setId_Academia(resultado.getInt("id_academia"));
				AcadResult.setNome(resultado.getString("nome"));
				AcadResult.setRazaoSocial(resultado.getString("razaosocial"));
				AcadResult.setTelefone1(resultado.getString("telefone1"));
				AcadResult.setTelefone2(resultado.getString("telefone2"));
				AcadResult.setCNPJ(resultado.getString("cnpj"));

				java.sql.Date DateDataCad = resultado.getDate("datacad");
				CalendDataCad.setTime(DateDataCad);
				AcadResult.setDataCad(CalendDataCad);				

				AcadResult.setResponsavel(resultado.getString("responsavel"));
				AcadResult.setEmail(resultado.getString("email"));
				AcadResult.setSite(resultado.getString("site"));
				AcadResult.setFacebook(resultado.getString("facebook"));
				AcadResult.setEndereco(resultado.getString("endereco"));
				AcadResult.setNumero(resultado.getString("numero"));
				AcadResult.setCep(resultado.getString("cep"));
				AcadResult.setBairro(resultado.getString("bairro"));
				AcadResult.setId_Cidade(resultado.getInt("id_cidade"));
				AcadResult.setId_Estado(resultado.getInt("id_estado"));
				AcadResult.setAtivo(resultado.getBoolean("ativo"));
				return AcadResult;
			}			
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
		return null;
	}*/
	
	
}
