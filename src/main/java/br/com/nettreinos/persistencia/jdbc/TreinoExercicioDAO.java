package br.com.nettreinos.persistencia.jdbc;

import br.com.nettreinos.persistencia.entidade.Exercicio;
import br.com.nettreinos.persistencia.entidade.Prof;
import br.com.nettreinos.persistencia.entidade.TipoTreino;
import br.com.nettreinos.persistencia.entidade.Treino;
import br.com.nettreinos.persistencia.entidade.TreinoExercicio;
import br.com.nettreinos.persistencia.entidade.TreinomodeloExercicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreinoExercicioDAO {

	private Connection  con = FabConexao.getConnection();

	public void vincular(List<TreinoExercicio> listate) {
		String sql = "Insert into treino_exercicio (id_exercicio, id_treino, qtderepeticoes, qtdeseries, intervalo, tempodescanco, divisao, numsequencia) "
					+ "values (?,?,?,?,?,?,?,?);";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			for(TreinoExercicio te: listate){
					
				
				stmt.setInt(1, te.getExercicio().getId_Exercicio());
				stmt.setInt(2, te.getTreino().getId_Treino());
				stmt.setInt(3, te.getQtderepetcoes());
				stmt.setInt(4, te.getQtdeseries());
				stmt.setInt(5, te.getIntervalo());
				stmt.setInt(6, te.getTempodescanco());
				stmt.setString(7, te.getDivisao());
				stmt.setInt(8, te.getNumsequencia());
				
				stmt.execute();
				}
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		
	}
	
	public List<TreinoExercicio> buscarPorIdTreino(Integer id_treino){
		String sql = "select treino_exercicio.divisao, treino_exercicio.numsequencia, "
				+ "treino.id_treino, treino.nome, exercicio.nome, treino_exercicio.qtderepeticoes, "
				+ "treino_exercicio.qtdeseries, treino_exercicio.intervalo, treino_exercicio.tempodescanco, "
				+ "treino_exercicio.id_treino_exercicio "
				+ "from treino_exercicio "
				+ "inner join treino on treino_exercicio.id_treino = treino.id_treino "
				+ "inner join exercicio on treino_Exercicio.id_exercicio = exercicio.id_exercicio "
				+ "where treino_exercicio.id_treino = ? "
				+ "order by treino_exercicio.divisao, treino_exercicio.numsequencia;";
	
		List<TreinoExercicio> listate = new ArrayList<TreinoExercicio>();
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id_treino);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				Treino treRS = new Treino();
				TreinoExercicio treexeRS = new TreinoExercicio();
				Exercicio exeRS = new Exercicio();
				TipoTreino tpotreRS = new TipoTreino();
				Prof prfRS = new Prof();
				
				treexeRS.setDivisao(rs.getString(1));
				treexeRS.setNumsequencia(rs.getInt(2));
				treRS.setId_Treino(rs.getInt(3));
				treRS.setNome(rs.getString(4));
				exeRS.setNome(rs.getString(5));
				treexeRS.setQtderepetcoes(rs.getInt(6));
				treexeRS.setQtdeseries(rs.getInt(7));
				treexeRS.setIntervalo(rs.getInt(8));
				treexeRS.setTempodescanco(rs.getInt(9));
				treexeRS.setId_treinoexercicio(rs.getInt(10));
				
				treexeRS.setTreino(treRS);
				treexeRS.setExercicio(exeRS);
				
				listate.add(treexeRS);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return listate;
	}

	public void atualizarcarga(TreinoExercicio treexe) {
		String sql = "update treino_exercicio set carga=? "
				+ "where id_treino_exercicio=?";

		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, treexe.getCarga());
			stmt.setInt(2, treexe.getId_treinoexercicio());
			
			stmt.execute();
			stmt.close();
						
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	/*public void vincular(TreinoExercicio te) {
		String sql = "Insert into treino_exercicio (id_exercicio, id_treino, qtderepeticoes, qtdeseries, intervalo, tempodescanco, divisao, numsequencia) "
					+ "values (?,?,?,?,?,?,?,?);";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, te.getExercicio().getId_Exercicio());
			stmt.setInt(2, te.getTreino().getId_Treino());
			stmt.setInt(3, te.getQtderepetcoes());
			stmt.setInt(4, te.getQtdeseries());
			stmt.setInt(5, te.getIntervalo());
			stmt.setInt(6, te.getTempodescanco());
			stmt.setString(7, te.getDivisao());
			stmt.setInt(8, te.getNumsequencia());
			
			stmt.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
			
	}*/
}
