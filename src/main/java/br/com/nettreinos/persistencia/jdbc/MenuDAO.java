package br.com.nettreinos.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.Menu;

public class MenuDAO {
	private Connection con = FabConexao.getConnection();
	
	public List<Menu> buscarMenu(Integer id){
		String sql = "Select * from menuadm where id_tipousuario=?";
		List<Menu> lista = new ArrayList<Menu>();
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Menu men = new Menu();
				men.setId_menuadm(rs.getInt("id_menuadm"));
				men.setItem(rs.getString("item"));
				men.setDescr(rs.getString("descr"));
				men.setId_tipousuario(rs.getInt("id_tipousuario"));
				men.setId_perfilacesso(rs.getInt("id_perfilacesso"));
				men.setAtivo(true);
				men.setLink(rs.getString("link"));
				lista.add(men);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
