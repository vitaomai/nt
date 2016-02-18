package br.com.nettreinos.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.Administrador;

public class AdministradorDAO {
	
	private Connection con = FabConexao.getConnection();
	
	public void salvar(Administrador Adm){
		if(Adm.getId_admin()!=null && Adm.getId_admin()!=0){
			alterar(Adm);			
		}
		else{
			inserir(Adm);
		}
	}
	
	public void inserir(Administrador Adm) {

		String sql = "insert into administrador (id_academia,nome,sobrenome,matricula,ativo,id_usuario) "+ 
						"values (?,?,?,?,?,?)";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setInt(1, Adm.getId_academia());
			stmt.setString(2, Adm.getNome());
			stmt.setString(3, Adm.getSobrenome());
			stmt.setInt(4, Adm.getMatricula());
			stmt.setBoolean(5, Adm.getAtivo());
			stmt.setInt(6, Adm.getId_usuario());


			stmt.execute();
			stmt.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Administrador Adm){
		String sql ="update administrador set id_academia=?, nome=?, sobrenome=?, matricula=?, ativo=?, id_usuario=? where id_admin=?";
	
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setInt(1, Adm.getId_academia());
			stmt.setString(2, Adm.getNome());
			stmt.setString(3, Adm.getSobrenome());
			stmt.setInt(4, Adm.getMatricula());
			stmt.setBoolean(5, Adm.getAtivo());
			stmt.setInt(6, Adm.getId_usuario());
			stmt.setInt(7, Adm.getId_admin());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void desativar(Administrador Adm){
		String sql = "update administrador set ativo=? where id_admin=?";
		
		try{ 
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setBoolean(1, Adm.getAtivo());
			stmt.setInt(2, Adm.getId_admin());

			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Administrador> buscarTodos(){
		String sql = "select * from administrador;";
		List <Administrador> lista = new ArrayList<Administrador>();
				
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()){
				Administrador AdmRS = new Administrador();
				
				AdmRS.setId_admin(rs.getInt("id_admin"));
				AdmRS.setId_academia(rs.getInt("id_academia"));
				AdmRS.setNome(rs.getString("nome"));
				AdmRS.setSobrenome(rs.getString("sobrenome"));
				AdmRS.setMatricula(rs.getInt("matricula"));
				AdmRS.setAtivo(rs.getBoolean("ativo"));
				AdmRS.setId_usuario	(rs.getInt("id_usuario"));

				lista.add(AdmRS);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public Administrador buscarPorId(Integer id){		
		String sql = "Select * from Administrador where id_admin=?";

		try (PreparedStatement smtm = con.prepareStatement(sql)){
			smtm.setInt(1, id);
			
			ResultSet rs = smtm.executeQuery();
						
			if(rs.next()){
				Administrador AdmRS = new Administrador();
				
				AdmRS.setId_admin(rs.getInt("id_admin"));
				AdmRS.setId_academia(rs.getInt("id_academia"));
				AdmRS.setNome(rs.getString("nome"));
				AdmRS.setSobrenome(rs.getString("sobrenome"));
				AdmRS.setMatricula(rs.getInt("matricula"));
				AdmRS.setAtivo(rs.getBoolean("ativo"));
				AdmRS.setId_usuario	(rs.getInt("id_usuario"));
				return AdmRS;
			}			
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
		return null;
	}
	
	public Administrador buscarPorIdUsuario(Integer idusuario ){
		String sql = "Select * from Administrador where id_usuario=?";
		try (PreparedStatement smtm = con.prepareStatement(sql)){
			smtm.setInt(1, idusuario);
			
			ResultSet rs = smtm.executeQuery();
						
			if(rs.next()){
				Administrador AdmRS = new Administrador();
				
				AdmRS.setId_admin(rs.getInt("id_admin"));
				AdmRS.setId_academia(rs.getInt("id_academia"));
				AdmRS.setNome(rs.getString("nome"));
				AdmRS.setSobrenome(rs.getString("sobrenome"));
				AdmRS.setMatricula(rs.getInt("matricula"));
				AdmRS.setAtivo(rs.getBoolean("ativo"));
				AdmRS.setId_usuario	(rs.getInt("id_usuario"));
				return AdmRS;	
			}	
		}catch (SQLException e){
				e.printStackTrace();
				System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
		
		return null;
		
	}

}
