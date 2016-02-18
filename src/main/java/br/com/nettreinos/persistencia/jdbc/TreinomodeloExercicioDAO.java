package br.com.nettreinos.persistencia.jdbc;

import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.nettreinos.persistencia.entidade.Exercicio;
import br.com.nettreinos.persistencia.entidade.Treinomodelo;
import br.com.nettreinos.persistencia.entidade.TreinomodeloExercicio;

public class TreinomodeloExercicioDAO {
	private Connection  con = FabConexao.getConnection();

	public List<TreinomodeloExercicio> buscarPorIdTreino(Integer id) {
		String sql = "Select treinomodelo_exercicio.id_treinomodelo_exercicio, treinomodelo.nome, "
				+ "treinomodelo_exercicio.divisao, treinomodelo_exercicio.numsequencia, exercicio.nome, "
				+ "exercicio.id_exercicio, treinomodelo_exercicio.qtderepeticoes, treinomodelo_exercicio.qtdeseries, "
				+ "treinomodelo_exercicio.intervalo, treinomodelo_exercicio.tempodescanco, treinomodelo_exercicio.carga "
				+ "from treinomodelo_exercicio " 
				+ "inner join treinomodelo on treinomodelo.id_treinomodelo = treinomodelo_exercicio.id_treinomodelo "
				+ "inner join exercicio on exercicio.id_exercicio = treinomodelo_exercicio.id_exercicio "
				+ "where treinomodelo_exercicio.id_treinomodelo = ? "
				+ "order by treinomodelo_exercicio.divisao, treinomodelo_exercicio.numsequencia; ";
		
		List<TreinomodeloExercicio> lista = new ArrayList<TreinomodeloExercicio>();
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				TreinomodeloExercicio tremodexeRS = new TreinomodeloExercicio();
				Treinomodelo tremodRS = new Treinomodelo();
				Exercicio exeRS = new Exercicio();
				
				tremodexeRS.setId_Treinomodelo_exercicio(rs.getInt(1));
				tremodRS.setNome(rs.getString(2));
				tremodexeRS.setDivisao(rs.getString(3));
				tremodexeRS.setNumsequencia(rs.getInt(4));
				exeRS.setNome(rs.getString(5));
				exeRS.setId_Exercicio(rs.getInt(6));
				tremodexeRS.setQtderepetcoes(rs.getInt(7));
				tremodexeRS.setQtdeseries(rs.getInt(8));
				tremodexeRS.setIntervalo(rs.getInt(9));
				tremodexeRS.setTempodescanco(rs.getInt(10));
				tremodexeRS.setCarga(rs.getInt(11));
				
				tremodexeRS.setTreinomodelo(tremodRS);
				tremodexeRS.setExercicio(exeRS);
				
							
				lista.add(tremodexeRS);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}

	public void adicionar(TreinomodeloExercicio tremodexe) {
		String sql = "insert into treinomodelo_exercicio (id_exercicio, id_treinomodelo, qtderepeticoes, qtdeseries, intervalo, tempodescanco, divisao, numsequencia, carga) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, tremodexe.getExercicio().getId_Exercicio());
			stmt.setInt(2, tremodexe.getTreinomodelo().getId_Treinomodelo());
			stmt.setInt(3, tremodexe.getQtderepetcoes());
			stmt.setInt(4, tremodexe.getQtdeseries());
			stmt.setInt(5, tremodexe.getIntervalo());
			stmt.setInt(6, tremodexe.getTempodescanco());
			stmt.setString(7, tremodexe.getDivisao());
			stmt.setInt(8, tremodexe.getNumsequencia());
			stmt.setInt(9, tremodexe.getCarga());
			
			stmt.execute();
			stmt.close();
						
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	

	public void remover(Integer id_exercicio) {
		String sql = "delete from treinomodelo_exercicio where id_treinomodelo_exercicio = ?;";

		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id_exercicio);
			
			stmt.execute();
			stmt.close();
						
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	public TreinomodeloExercicio buscarPorIdExercicio(Integer id_exercicio) {
		String sql = "Select treinomodelo_exercicio.id_treinomodelo_exercicio, treinomodelo_exercicio.divisao, "
				+ "treinomodelo_exercicio.numsequencia, exercicio.nome, exercicio.id_exercicio, " 
				+ "treinomodelo_exercicio.qtderepeticoes, treinomodelo_exercicio.qtdeseries, treinomodelo_exercicio.intervalo, "
				+ "treinomodelo_exercicio.tempodescanco, treinomodelo_exercicio.carga "
				+ "from treinomodelo_exercicio "
				+ "inner join exercicio on exercicio.id_exercicio = treinomodelo_exercicio.id_exercicio "
				+ "where treinomodelo_exercicio.id_treinomodelo_exercicio = ? "
				+ "order by treinomodelo_exercicio.divisao, treinomodelo_exercicio.numsequencia;";
				
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id_exercicio);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()){
				TreinomodeloExercicio tremodexeRS = new TreinomodeloExercicio();
				Exercicio exeRS = new Exercicio();
				
				tremodexeRS.setId_Treinomodelo_exercicio(rs.getInt(1));
				tremodexeRS.setDivisao(rs.getString(2));
				tremodexeRS.setNumsequencia(rs.getInt(3));
				exeRS.setNome(rs.getString(4));
				exeRS.setId_Exercicio(rs.getInt(5));
				tremodexeRS.setQtderepetcoes(rs.getInt(6));
				tremodexeRS.setQtdeseries(rs.getInt(7));
				tremodexeRS.setIntervalo(rs.getInt(8));
				tremodexeRS.setTempodescanco(rs.getInt(9));
				tremodexeRS.setCarga(rs.getInt(10));
				
				tremodexeRS.setExercicio(exeRS);
				
				return tremodexeRS;
			}
			
			stmt.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}

	public void alterar(TreinomodeloExercicio tremodexe) {
		String sql = "update treinomodelo_exercicio set divisao=?, numsequencia=?, id_exercicio=?, qtderepeticoes=?, qtdeseries=?, intervalo=?, tempodescanco=?, carga=? " 
					+ " where id_treinomodelo_exercicio = ?;";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, tremodexe.getDivisao());
			stmt.setInt(2, tremodexe.getNumsequencia());
			stmt.setInt(3, tremodexe.getExercicio().getId_Exercicio());
			stmt.setInt(4, tremodexe.getQtderepetcoes());
			stmt.setInt(5, tremodexe.getQtdeseries());
			stmt.setInt(6, tremodexe.getIntervalo());
			stmt.setInt(7, tremodexe.getTempodescanco());
			stmt.setInt(8, tremodexe.getCarga());
			stmt.setInt(9, tremodexe.getId_TreinomodeloExercicio());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e){
		e.printStackTrace();
		System.err.println( e.getClass().getName()+": "+ e.getMessage() );			
		}
	}
}












