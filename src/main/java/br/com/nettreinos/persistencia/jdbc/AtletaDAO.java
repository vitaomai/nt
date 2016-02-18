package br.com.nettreinos.persistencia.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.nettreinos.persistencia.entidade.Atleta;

public class AtletaDAO {
	private Connection con = FabConexao.getConnection();
	Calendar CalendDatanasc = Calendar.getInstance();

	public void salvar(Atleta Atle){
		if(Atle.getId_atleta()!=null && Atle.getId_atleta()!=0){
			alterar(Atle);			
		}
		else{
			inserir(Atle);
		}
	}
	
	public void inserir(Atleta Atle) {

		String sql = "insert into atleta (id_usuario,nome,sobrenome,apelido,ativo,telefone1,telefone2,cpf,foto,datanasc,email,facebook,endereco,cep,bairro,numero,id_cidade,id_estado) "+ 
						"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
			CalendDatanasc = Atle.getDatanasc();
			java.sql.Date DateDatanasc = new java.sql.Date(CalendDatanasc.getTime().getTime());

		try (PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setInt(1, Atle.getId_usuario());
			stmt.setString(2, Atle.getNome());
			stmt.setString(3, Atle.getSobrenome());
			stmt.setString(4, Atle.getApelido());
			stmt.setBoolean(5, Atle.getAtivo());
			stmt.setString(6, Atle.getTelefone1());
			stmt.setString(7, Atle.getTelefone2());
			stmt.setString(8, Atle.getCpf());
			stmt.setString(9, Atle.getFoto());
			stmt.setDate(10, DateDatanasc);
			stmt.setString(11, Atle.getEmail());
			stmt.setString(12, Atle.getFacebook());
			stmt.setString(13, Atle.getEndereco());
			stmt.setString(14, Atle.getCep());
			stmt.setString(15, Atle.getBairro());
			stmt.setString(16, Atle.getNumero());
			stmt.setInt(17, Atle.getId_cidade());
			stmt.setInt(18, Atle.getId_estado());

			stmt.execute();
			stmt.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void alterar(Atleta Atle){
		String sql ="update atleta set id_usuario=?, nome=?, sobrenome=?, apelido=?, ativo=?, telefone1=?, telefone2=?," + 
					"cpf=?, foto=?, datanasc=?, email=?, facebook=?, endereco=?, cep=?, bairro=?, numero=?, id_cidade=?, id_estado=? where id_atleta=?";
		
		CalendDatanasc = Atle.getDatanasc();
		java.sql.Date DateDatanasc = new java.sql.Date(CalendDatanasc.getTime().getTime());
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, Atle.getId_usuario());
			stmt.setString(2, Atle.getNome());
			stmt.setString(3, Atle.getSobrenome());
			stmt.setString(4, Atle.getApelido());
			stmt.setBoolean(5, Atle.getAtivo());
			stmt.setString(6, Atle.getTelefone1());
			stmt.setString(7, Atle.getTelefone2());
			stmt.setString(8, Atle.getCpf());
			stmt.setString(9, Atle.getFoto());
			stmt.setDate(10, DateDatanasc);
			stmt.setString(11, Atle.getEmail());
			stmt.setString(12, Atle.getFacebook());
			stmt.setString(13, Atle.getEndereco());
			stmt.setString(14, Atle.getCep());
			stmt.setString(15, Atle.getBairro());
			stmt.setString(16, Atle.getNumero());
			stmt.setInt(17, Atle.getId_cidade());
			stmt.setInt(18, Atle.getId_estado());
			stmt.setInt(19, Atle.getId_atleta());

			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
	public void desativar(Atleta Atle){
		String sql = "update atleta set ativo=? where id_atleta=?";
		
		try{ 
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setBoolean(1, Atle.getAtivo());
			stmt.setInt(2, Atle.getId_atleta());

			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<Atleta> buscarTodos(){
		String sql = "select * from atleta;";
		List<Atleta> lista = new ArrayList<Atleta>();
		
		Calendar CalendDatanasc = Calendar.getInstance();
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
		
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
		}
		return lista;
	}
	
	
	
	public Atleta buscarPorId(Integer id){		
		String sql = "Select * from atleta where id_atleta=?";
		Calendar CalendDatanasc = Calendar.getInstance();
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
						
			if(rs.next()){
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
				return AtleRS;
			}			
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
		return null;
	}
	
	public Atleta buscarPorIdUsuario(Integer idusuario){
		String sql = "Select * from atleta where id_usuario=?";
		Calendar CalendDatanasc = Calendar.getInstance();
		try (PreparedStatement smtm = con.prepareStatement(sql)){
			smtm.setInt(1, idusuario);
			
			ResultSet rs = smtm.executeQuery();
						
			if(rs.next()){
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
				
				return AtleRS;
			}			
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
		return null;
	}

	
	
	public void inserirNovoUsuario(Integer id_usr) {
		String sql = "insert into atleta (id_usuario) values (?)";

		try (PreparedStatement stmt = con.prepareStatement(sql)){
		
			stmt.setInt(1, id_usr);

			stmt.execute();
			stmt.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
