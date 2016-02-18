package br.com.nettreinos.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.TipoUsuario;
//import br.com.nettreinos.persistencia.entidade.Usuario;
//import br.com.nettreinos.persistencia.entidade.Usuario;

public class TipoUsuarioDAO {
	
	private Connection con = FabConexao.getConnection();

	public void salvar(TipoUsuario TpoUsu){
		if(TpoUsu.getId_TipoUsuario()!=null && TpoUsu.getId_TipoUsuario()!=0){
			alterar(TpoUsu);			
		}
		else{
			inserir(TpoUsu);
		}
	}

	
	public void inserir(TipoUsuario TpoUsu) {
		
		String sql = "Insert into tipousuario (nome, descr, ativo) values (?,?,?)"; 
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, TpoUsu.getNome());
			stmt.setString(2, TpoUsu.getDescr());
			stmt.setBoolean(3, TpoUsu.isAtivo());
			
			stmt.execute();
			stmt.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void alterar(TipoUsuario TpoUsu){
		String sql ="update tipousuario set nome=?, descr=?, ativo=? where id_tipousuario=?";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, TpoUsu.getNome());
			stmt.setString(2, TpoUsu.getDescr());
			stmt.setBoolean(3, TpoUsu.isAtivo());
			stmt.setInt(4, TpoUsu.getId_TipoUsuario());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
	public void excluir(TipoUsuario TpoUsu) {

		String sql = "delete from tipousuario where id_tipousuario=?";
		
		try{ 
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, TpoUsu.getId_TipoUsuario());
			//System.out.println("O STMT.EXECUTE está desabilitado afim de evitar corrompimento do banco");
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void desativar(TipoUsuario TpoUsu){
		String sql = "update tipousuario set ativo=? where id_tipousuario=?";
		
		try{ 
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setBoolean(1, TpoUsu.isAtivo());
			stmt.setInt(2, TpoUsu.getId_TipoUsuario());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public TipoUsuario buscarPorId(TipoUsuario TpoUsu){
		
		String sql = "Select * from tipousuario where id_tipousuario=?";
		
		try (PreparedStatement smtm = con.prepareStatement(sql)){
			smtm.setInt(1, TpoUsu.getId_TipoUsuario());
			
			ResultSet rs = smtm.executeQuery();
			if(rs.next()){
				TipoUsuario TpoUsuRS= new TipoUsuario();
				TpoUsuRS.setId_TipoUsuario(rs.getInt("id_tipousuario"));
				TpoUsuRS.setNome(rs.getString("nome"));
				TpoUsuRS.setDescr(rs.getString("descr"));
				TpoUsuRS.setAtivo(rs.getBoolean("ativo"));
				return TpoUsuRS;
			}
			//resultado.close();
			//smtm.close();			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	
	
	public List<TipoUsuario> buscarTodos() {
		String sql = "select * from tipousuario;";
		List<TipoUsuario> lista = new ArrayList<TipoUsuario>();
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
						
			ResultSet rs = stmt.executeQuery();
						
			while(rs.next()){
				TipoUsuario TpoUsu = new TipoUsuario();
				TpoUsu.setId_TipoUsuario(rs.getInt("id_tipousuario"));
				TpoUsu.setNome(rs.getString("nome")); //resultado.getString("Login")
				TpoUsu.setDescr(rs.getString("descr"));
				TpoUsu.setAtivo(rs.getBoolean("ativo"));
				
				//Adicionando o usuario na lista
				lista.add(TpoUsu);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	
}
