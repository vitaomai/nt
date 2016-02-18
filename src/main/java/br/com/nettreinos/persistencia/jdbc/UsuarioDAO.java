package br.com.nettreinos.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.Usuario;

public class UsuarioDAO {
	
	private Connection con = FabConexao.getConnection();
	
	public void salvar(Usuario u){
		if(u.getId_Usuario()!=null && u.getId_Usuario()!=0){
			
			alterar(u);			
		}
		else{
			inserir(u);
		}
	}
	
	public void inserir(Usuario u) {
		String sql = "Insert into usuario (login, senha, id_tipousuario, ativo) values (?,?,?,'true')"; 
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getSenha());
			stmt.setInt(3, u.getId_TipoUsuario());
			
			stmt.execute();
			stmt.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar(Usuario U){
		String sql ="update usuario set login=?, senha=?, id_tipousuario=?, ativo=? where id_usuario=?";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, U.getLogin());
			stmt.setString(2, U.getSenha());
			stmt.setInt(3, U.getId_TipoUsuario());
			stmt.setBoolean(4, U.getAtivo());
			stmt.setInt(5, U.getId_Usuario());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void excluir(Usuario usu) {

		String sql = "delete from usuario where id_usuario=?";
		
		try{ 
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, usu.getId_Usuario());
			System.out.println("O STMT.EXECUTE está desabilitado afim de evitar corrompimento do banco");
			//stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void desativar(Usuario Usu){
		String sql = "update usuario set ativo=? where id_usuario=?";
		
		try{ 
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setBoolean(1, Usu.getAtivo());
			stmt.setInt(2, Usu.getId_Usuario());
	
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario buscarPorId(Integer id){
		
		String sql = "Select * from usuario where id_usuario=?";
		
		try (PreparedStatement smtm = con.prepareStatement(sql)){
			smtm.setInt(1, id);
			
			ResultSet resultado = smtm.executeQuery();
			
			if(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId_Usuario(resultado.getInt("id_usuario"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setId_TipoUsuario(resultado.getInt("id_tipousuario"));
				usuario.setAtivo(resultado.getBoolean("ativo"));
				return usuario;
			} 
			//resultado.close();
			//smtm.close();			
		} catch (SQLException e){
			e.printStackTrace();
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
		return null;
	}
	
	public List<Usuario> buscarTodos() {
		String sql = "select * from usuario;";
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
						
			ResultSet resultado = stmt.executeQuery();
						
			while(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId_Usuario(resultado.getInt("id_usuario")); //resultado.getInt("iduser")
				usuario.setLogin(resultado.getString("login")); //resultado.getString("Login")
				usuario.setSenha(resultado.getString("senha"));
				usuario.setId_TipoUsuario(resultado.getInt("id_tipousuario"));
				usuario.setAtivo(resultado.getBoolean("ativo"));
				
				//Adicionando o usuario na lista
				lista.add(usuario);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public Usuario autenticar(Usuario usuConsulta){
		String sql = "Select * from usuario where login=? and senha=?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, usuConsulta.getLogin());
			stmt.setString(2, usuConsulta.getSenha());
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				Usuario usu = new Usuario();
				usu.setId_Usuario(rs.getInt("id_usuario")); //resultado.getInt("iduser")
				usu.setLogin(rs.getString("login")); //resultado.getString("Login")
				usu.setSenha(rs.getString("senha"));
				usu.setId_TipoUsuario(rs.getInt("id_tipousuario"));
				usu.setAtivo(rs.getBoolean("ativo"));
				return usu;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
