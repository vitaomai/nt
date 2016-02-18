package br.com.nettreinos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nettreinos.persistencia.entidade.Datatreino;
import br.com.nettreinos.persistencia.entidade.Treino;
import br.com.nettreinos.persistencia.entidade.TreinoExercicio;
import br.com.nettreinos.persistencia.jdbc.DatatreinoDAO;
import br.com.nettreinos.persistencia.jdbc.TreinoDAO;
import br.com.nettreinos.persistencia.jdbc.TreinoExercicioDAO;

@SuppressWarnings("serial")
@WebServlet("/treinoexerciciocontroller.do")

public class TreinoExercicioController extends HttpServlet {
	public TreinoExercicioController(){
		
	}
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		//http://localhost:8080/nettreinos/treinomodeloexerciciocontroller.do?acao=abrir&id=16TreinoDAO treDAO = new TreinoDAO();
		TreinoExercicioDAO treexeDAO = new TreinoExercicioDAO();
		DatatreinoDAO dtatreDAO = new DatatreinoDAO();
		
		String acao = req.getParameter("acao");
		
		if(acao.equals("abrir")){
			Integer id_treino = Integer.parseInt(req.getParameter("id_treino"));
			req.setAttribute("id_treino", id_treino);
			
			
			List<Datatreino> listadt = dtatreDAO.buscarTodos(id_treino); 
			req.setAttribute("listadt", listadt);
			
			List<TreinoExercicio> listate = treexeDAO.buscarPorIdTreino(id_treino);
			req.setAttribute("listate", listate);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ListaTreinoExercicio.jsp");
			dispatcher.forward(req, resp);
			
			
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		TreinoExercicio treexe = new TreinoExercicio();
		TreinoExercicioDAO treexeDAO = new TreinoExercicioDAO();
		
		treexe.setId_treinoexercicio(Integer.parseInt(req.getParameter("id_treinoexercicio")));
		treexe.setCarga(Integer.parseInt(req.getParameter("carga")));
		
		treexeDAO.atualizarcarga(treexe);
		
		
		
		
		
		
		
		
		
		
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}

}








